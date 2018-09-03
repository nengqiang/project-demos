package com.hnq.crawler.process;

import com.hnq.crawler.dao.domain.BaiduHot;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author henengqiang
 * @date 2018/9/1
 */
@Service
public class BaiduHotProcess {

    public ArrayList<BaiduHot> processBaiduHot(Document doc) {
        ArrayList<BaiduHot> baiduHots = new ArrayList<>();
        // 提取数据
        Elements divsBig = doc.getElementsByClass("hot-concept clearfix");
        for (Element element : divsBig) {
            BaiduHot baiduHot = new BaiduHot();
            // 获得行业数据 //
            Elements column1 = element.getElementsByClass("concept-header column1");
            // 获取行数数据
            baiduHot.setTitleLine1(column1.get(0).getElementsByClass("text-ellipsis").get(0).ownText());
            // 获取热搜指数
            baiduHot.setTitleLine2(Integer.parseInt(column1.get(0).getElementsByTag("h3")
                    .get(0).getElementsByTag("span").get(0).ownText()));
            // 获得发布时间
            baiduHot.setTitleLine3(column1.get(0).getElementsByTag("p").get(0).ownText());
            // 获得简要内容
            baiduHot.setTitleLine4(column1.get(0).getElementsByTag("p").get(1).ownText());

            // 概述内容
            baiduHot.setDrivingThing(element.getElementsByClass("concept-event column3").get(0).ownText());
            // 获得推荐股价
            Elements stockU1 = element.getElementsByClass("no-click");
            // 股票1名称
            baiduHot.setHotStockName1(stockU1.get(0).getElementsByTag("a")
                    .get(0).getElementsByTag("div").get(0).ownText());
            // 股票1代码
            baiduHot.setHotStockCode1(stockU1.get(0).getElementsByTag("a")
                    .get(0).getElementsByTag("div").get(1).ownText());
            // 股票1价格
            baiduHot.setHotStockPrice1(Double.parseDouble(stockU1.get(0)
                    .getElementsByClass("column2").get(1).ownText()));
            // 股票1涨幅
            baiduHot.setHotStockIncrement1(stockU1.get(0).child(2).ownText());

            // 股票2名称
            baiduHot.setHotStockName2(stockU1.get(1).getElementsByTag("a")
                    .get(0).getElementsByTag("div").get(0).ownText());
            // 股票2代码
            baiduHot.setHotStockCode2(stockU1.get(1).getElementsByTag("a")
                    .get(0).getElementsByTag("div").get(1).ownText());
            // 股票2价格
            baiduHot.setHotStockPrice2(Double.parseDouble(stockU1.get(1)
                    .getElementsByClass("column2").get(1).ownText()));
            // 股票2涨幅
            baiduHot.setHotStockIncrement2(stockU1.get(1).child(2).ownText());

            // 股票2名称
            baiduHot.setHotStockName3(stockU1.get(2).getElementsByTag("a")
                    .get(0).getElementsByTag("div").get(0).ownText());
            // 股票3代码
            baiduHot.setHotStockCode3(stockU1.get(2).getElementsByTag("a")
                    .get(0).getElementsByTag("div").get(1).ownText());
            // 股票3价格
            baiduHot.setHotStockPrice3(Double.parseDouble(stockU1.get(2)
                    .getElementsByClass("column2").get(1).ownText()));
            // 股票3涨幅
            baiduHot.setHotStockIncrement3(stockU1.get(2).child(2).ownText());
            baiduHots.add(baiduHot);
        }
        return baiduHots;
    }

}
