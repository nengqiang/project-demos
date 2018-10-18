package com.hnq.blog;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class AbstractTestCase {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

}
