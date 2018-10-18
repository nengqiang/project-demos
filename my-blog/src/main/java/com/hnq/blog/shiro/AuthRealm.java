package com.hnq.blog.shiro;

import com.hnq.blog.dao.domain.Permission;
import com.hnq.blog.dao.domain.Role;
import com.hnq.blog.dao.domain.User;
import com.hnq.blog.service.ILoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
public class AuthRealm extends AuthorizingRealm {

    private static final Logger logger =LoggerFactory.getLogger(AuthRealm.class);

    @Autowired
    private ILoginService loginService;

    /**
     * 为用户授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取前端输入的用户信息，封装为 User 对象
        User userWeb = (User) principals.getPrimaryPrincipal();
        // 获取前端输入的用户名
        String userName = userWeb.getUserName();
        // 根据前端输入的用户名查询数据库中对应的记录
        User user = loginService.findUserRolesPermissionsByName(userName);
        // 如果数据库中有该用户名对应的记录，就进行授权操作
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            Collection<String> roleCollection = new HashSet<>();
            Collection<String> permissionCollection = new HashSet<>();
            // 获取 user 的 role List
            List<Role> roles = user.getRoles();
            roles.forEach(role -> {
                roleCollection.add(role.getRoleName());
                List<Permission> permissions = role.getPermissions();
                permissions.forEach(permission -> permissionCollection.add(permission.getPermission()));
                // 为用户授权
                info.addStringPermissions(permissionCollection);
            });
            // 为用户授予角色
            info.addRoles(roleCollection);
            // 监控点
            logger.info("{}的角色{}", user.getUserName(), info.getRoles());
            logger.info("{}的权限{}", user.getUserName(), info.getStringPermissions());
            return info;
        } else {
            return null;
        }
    }

    /**
     * 认证登陆
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // token 携带了用户信息
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        // 获取前端输入的用户名
        String userName = usernamePasswordToken.getUsername();
        // 根据用户名查询数据库中对应的记录
        User user = loginService.findUserRolesPermissionsByName(userName);
        // 当前 realm 对象的 name
        String realmName = getName();
        // 盐值
        ByteSource credentialSalt = ByteSource.Util.bytes(user.getUserName());
        // 封装用户信息，构建 AuthenticationInfo 对象并返回
        return new SimpleAuthenticationInfo(user, user.getPassword(), credentialSalt, realmName);
    }

}
