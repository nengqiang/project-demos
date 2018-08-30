package com.hnq.crawler;

import com.hnq.crawler.dao.domain.BaiduHot;
import com.hnq.crawler.dao.domain.Stock;
import com.hnq.crawler.dao.mapper.BaiduHotMapper;
import com.hnq.crawler.dao.mapper.StockMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author henengqiang
 * @date 2018/8/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrawlerApplication.class)
public class MyBatisTest {

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private BaiduHotMapper baiduHotMapper;

    @Test
    public void connectionTest() {
        try {
            Stock stock = stockMapper.selectByPrimaryKey(1);
            BaiduHot baiduHot = baiduHotMapper.selectByPrimaryKey(40);
            System.out.println(stock);
            System.out.println(baiduHot);
        } catch (Exception e) {
            throw new RuntimeException("数据库繁忙，请稍后重试");
        }

    }

}
