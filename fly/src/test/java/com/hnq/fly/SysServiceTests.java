package com.hnq.fly;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.hnq.fly.model.bo.PermissionBO;
import com.hnq.fly.model.bo.RoleBO;
import com.hnq.fly.model.bo.UserBO;
import com.hnq.fly.service.PermissionService;
import com.hnq.fly.service.RoleService;
import com.hnq.fly.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 登录相关测试类
 *
 * @author henengqiang
 * @date 2020/5/5
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ImportResource("classpath:/spring/appContext.xml")
class SysServiceTests {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Test
    void testAddUser() throws ParseException {
        UserBO user = new UserBO();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setNickname("管理员");
        user.setHeadImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588697939913&di=318e3aa13651f4913ee38b7069accd44&imgtype=0&src=http%3A%2F%2Fbpic.588ku.com%2Felement_pic%2F19%2F03%2F20%2Fd5a22ed27e949080bbab0ba64cc53491.jpg");
        user.setPhone("15178288888");
        user.setEmail("admin@admin.com");
        user.setBirthday(DateUtils.parseDate("1990-09-09", DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.getPattern()));
        user.setSex("男");
        UserBO res = userService.saveUser(user);
        System.out.println(res);
    }

    @Test
    void testUpdateUser() {
        UserBO user = userService.getUserByUsername("admin");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        UserBO res = userService.updateUser(user);
        System.out.println(res);
    }

    @Test
    void testAddRole() {
        RoleBO role = new RoleBO();
        role.setRoleName("ADMIN");
        role.setDescription("管理员");
        roleService.saveRole(role);
    }

    @Test
    void testAddPermissions() throws IOException {
        String jsonStr = FileUtils.readFileToString(
                new File(com.hnq.toolkit.util.FileUtils.getResourceFilePath(
                        this.getClass(), "sql/permission_initial.json")), Charsets.UTF_8);
        List<PermissionBO> permissions = JSONObject.parseArray(jsonStr, PermissionBO.class);
        for (PermissionBO permission : permissions) {
            permissionService.savePermission(permission);
        }
    }

}
