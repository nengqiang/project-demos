package com.hnq.fly.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hnq.fly.model.bo.LoginUser;
import com.hnq.fly.model.bo.PermissionBO;
import com.hnq.fly.model.bo.UserBO;
import com.hnq.fly.service.PermissionService;
import com.hnq.fly.service.UserService;
import com.hnq.toolkit.util.BeanUtils;

/**
 * spring security登陆处理
 *
 * @author henengqiang
 * @date 2020/6/12
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserBO user = userService.getUserByUsername(s);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("用户名不存在");
        } else if (Objects.equals(user.getStatus(), UserBO.Status.LOCKED)) {
            throw new LockedException("用户被锁定，请联系管理员");
        } else if (Objects.equals(user.getStatus(), UserBO.Status.DISABLED)) {
            throw new DisabledException("用户已被禁用");
        }

        LoginUser loginUser = BeanUtils.convert(user, LoginUser.class);
        List<PermissionBO> permissions = permissionService.listPermissionsByUserNo(loginUser.getUserNo());
        loginUser.setPermissions(permissions);

        return loginUser;
    }

}
