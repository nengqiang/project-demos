package com.hnq.blog;

import com.alibaba.fastjson.JSON;
import com.hnq.blog.dao.domain.User;
import com.hnq.blog.service.ILoginService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
public class ServiceTests extends AbstractTestCase {

    @Autowired
    private ILoginService loginService;

    @Test
    public void findUserByNameTest() {
        User user = loginService.findUserRolesPermissionsByName("hanif");
        logger.info("测试查询结果：{}", JSON.toJSONString(user));
    }

}
