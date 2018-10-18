package com.hnq.blog.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnq.blog.dao.domain.*;
import com.hnq.blog.dao.mapper.PermissionMapper;
import com.hnq.blog.dao.mapper.RoleMapper;
import com.hnq.blog.dao.mapper.UserMapper;
import com.hnq.blog.service.ILoginService;
import com.hnq.blog.utils.CryptUtil;
import com.mysql.jdbc.StringUtils;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
@Service
public class LoginServiceImpl implements ILoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User findUserRolesPermissionsByName(String name) {
        logger.info("===>> findUserRolesPermissionsByName: name={}", name);
        try {
            List<User> users = findUsersByName(name);
            if (CollectionUtils.isNotEmpty(users)) {
                User user = users.get(0);
                List<Role> roles = findRolesByUserId(user.getId());
                if (CollectionUtils.isNotEmpty(roles)) {
                    roles.forEach(role -> {
                        List<Permission> permissions = findPermissionsByRoleId(role.getId());
                        role.setPermissions(permissions);
                    });
                    user.setRoles(roles);
                }
                logger.info("查到User： {}", JSON.toJSONString(user));
                return user;
            }
        } catch (Exception e) {
            logger.error("查询出错：", e.getMessage(), e);
            throw e;
        }
        return null;
    }

    @Override
    public User regist(String userName, String password) {
        logger.info("===>> regist: userName={}", userName);
        String emptyMessage = "用户名或密码不能为空！";
        String usedMessage = "用户名已被使用！";
        try {
            if (StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(password)) {
                throw new RuntimeException(emptyMessage);
            }
            if (CollectionUtils.isNotEmpty(findUsersByName(userName))) {
                throw new RuntimeException(usedMessage);
            }
            User user = new User();
            user.setUserName(userName);
            user.setPassword(CryptUtil.md5Salt(password, userName));
            userMapper.insert(user);
            List<User> users = findUsersByName(userName);
            if (CollectionUtils.isNotEmpty(users)) {
                Integer userId = users.get(0).getId();
                Role role = new Role();
                role.setUserId(userId);
                role.setRoleName("guest");
                roleMapper.insert(role);
                List<Role> roles = findRolesByUserId(userId);
                if (CollectionUtils.isNotEmpty(roles)) {
                    roles.forEach(theRole -> {
                        Permission permission = new Permission();
                        permission.setRoleId(theRole.getId());
                        permission.setPermission("create");
                        permissionMapper.insert(permission);
                        permission.setPermission("query");
                        permissionMapper.insert(permission);
                        theRole.setPermissions(findPermissionsByRoleId(theRole.getId()));
                    });
                }
                user.setRoles(roles);
            }
            return user;
        } catch (Exception e) {
            logger.error("注册出错：{}", e.getMessage(), e);
            boolean hasErrorType = emptyMessage.equals(e.getMessage()) || usedMessage.equals(e.getMessage());
            throw hasErrorType ? new RuntimeException(e.getMessage()) : new RuntimeException("数据库或网络异常，请稍后重试。");
        }
    }

    private List<User> findUsersByName(String userName) {
        if (StringUtils.isNullOrEmpty(userName)) {
            return null;
        }
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.createCriteria().andUserNameEqualTo(userName);
        return userMapper.selectByExample(userCriteria);
    }

    private List<Role> findRolesByUserId(Integer userId) {
        if (userId == null) {
            return null;
        }
        RoleCriteria roleCriteria = new RoleCriteria();
        roleCriteria.createCriteria().andUserIdEqualTo(userId);
        return roleMapper.selectByExample(roleCriteria);
    }

    private List<Permission> findPermissionsByRoleId(Integer roleId) {
        if (roleId == null) {
            return null;
        }
        PermissionCriteria permissionCriteria = new PermissionCriteria();
        permissionCriteria.createCriteria().andRoleIdEqualTo(roleId);
        return permissionMapper.selectByExample(permissionCriteria);
    }

}
