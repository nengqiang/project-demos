package com.hnq.crawler.service;

import com.hnq.crawler.dao.domain.BaiduHot;
import com.hnq.crawler.dao.domain.Stock;
import com.hnq.crawler.dao.mapper.BaiduHotMapper;
import com.hnq.crawler.dao.mapper.StockMapper;
import com.hnq.crawler.process.BaiduHotProcess;
import com.hnq.crawler.process.GetJson;
import io.webfolder.cdp.Launcher;
import io.webfolder.cdp.session.Session;
import io.webfolder.cdp.session.SessionFactory;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author henengqiang
 * @date 2018/9/1
 */
@Service
public class BaiduHotDownService {

    private static final Logger logger = LoggerFactory.getLogger(BaiduHotDownService.class);

    @Autowired
    private BaiduHotMapper baiduHotMapper;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private BaiduHotProcess baiduHotProcess;

    @Autowired
    private GetJson getJson;

    /**
     * 1分钟跑一次
     */
    @Scheduled(cron = "0/60 * * * * ? ")
    public void downBaiduHot0() {
        String url = "https://gupiao.baidu.com/concept/";
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<BaiduHot> baiduHots = baiduHotProcess.processBaiduHot(doc);
            int count = 0;
            if (baiduHots != null && baiduHots.size() > 0) {
                for (BaiduHot baiduHot : baiduHots) {
                    count += baiduHotMapper.insert(baiduHot);
                }
                logger.info("Jsoup方式成功爬取页面数据，保存了{}条BaiduHot。", count);
            } else {
                logger.info("Jsoup方式爬取到0条BaiduHot");
            }
        } catch (Exception e) {
            logger.error("Jsoup方式爬取页面数据出错：", e);
            // 抛出异常 告知 controller 层
            throw new RuntimeException(e);
        }
    }

    /**
     * 1分钟跑一次
     */
    @Scheduled(cron = "0/60 * * * * ? ")
    public void downStockPrice() {
        // url 生成
        String url = "https://gupiao.baidu.com/api/stocks/stocktimeline?from=pc&os_ver=1&cuid=xxx&vv=100&format=json&" +
                "stock_code=sh600358&timestamp=" + System.currentTimeMillis();
        try {
            // 访问获得 json 数据
            JSONObject stock = getJson.getHttpJson(url, 1);
            if (stock != null) {
                Stock aStock = new Stock();
                aStock.setStockId("sh60035");
                aStock.setData(stock.toString());
                // 将 json 数据存入数据库中
                stockMapper.insert(aStock);
                logger.info("成功获取到stock数据，data={}", stock.toString());
            } else {
                logger.info("获取stock数据失败");
            }
        } catch (Exception e) {
            logger.error("获取stock数据出错：", e);
            // 抛出异常 告知 controller 层
            throw new RuntimeException(e);
        }
    }

    /**
     * 1分钟跑一次
     */
    @Scheduled(cron = "0/60 * * * * ? ")
    public void downBaiduHot1() {
        ArrayList<String> command = new ArrayList<>();
        // 不显示 Google 浏览器
        command.add("--headless");
        Launcher launcher = new Launcher();
        try (SessionFactory factory = launcher.launch(command);
             Session session = factory.create()) {
            session.navigate("https://gupiao.baidu.com/concept/");
            session.waitDocumentReady();
            String content = session.getContent();
            Document doc = Jsoup.parse(content);
            ArrayList<BaiduHot> baiduHots = new BaiduHotProcess().processBaiduHot(doc);
            if (baiduHots != null && baiduHots.size() > 0) {
                int count = 0;
                for (BaiduHot baiduHot : baiduHots) {
                    count += baiduHotMapper.insert(baiduHot);
                }
                logger.info("launcher方式成功爬取页面数据，保存了{}条BaiduHot。", count);
            } else {
                logger.info("launcher方式爬取到0条BaiduHot");
            }
        } catch (Exception e) {
            logger.error("launcher方式爬取页面数据出错：", e);
            // 抛出异常 告知 controller 层
            throw new RuntimeException(e);
        }
    }

}
