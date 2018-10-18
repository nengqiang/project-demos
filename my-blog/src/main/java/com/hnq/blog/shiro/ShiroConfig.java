package com.hnq.blog.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
@Configuration
public class ShiroConfig {

    /**
     * 密码校验规则 HashedCredentialsMatcher
     * 这个类是为了对密码进行加密的，
     * 防止密码在数据库里明码保存， 当然在登陆认证的时候，
     * 这个类也负责对 form 里输入的密码进行加密
     * 处理认证匹配处理器：如果自定义需要实现继承 HashedCredentialsMatcher
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        // 指定加密方式为 md5
        credentialsMatcher.setHashAlgorithmName("MD5");
        // 加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean("authRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public AuthRealm authRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setAuthorizationCachingEnabled(false);
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }

    /**
     * 定义安全管理器 securityManager，注入自定义的realm
     */
    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        return manager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager")SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置 SecurityManager
        bean.setSecurityManager(manager);
        // 设置登陆页面，也可以写路由，也可以写 jsp 页面的访问路径
        bean.setLoginUrl("/back/login");
        // 设置登陆成功跳转的页面
        bean.setSuccessUrl("/back/dashboard");
        // 设置未授权跳转的页面
        bean.setUnauthorizedUrl("/back/unauthorized");
        // 定义过滤器
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("back/dashboard", "authc");
        filterChainDefinitionMap.put("back/login", "anon");
        filterChainDefinitionMap.put("back/loginUser", "authc");
        filterChainDefinitionMap.put("back/admin", "roles[admin]");
        filterChainDefinitionMap.put("back/createThirdTool", "perms[create]");
        filterChainDefinitionMap.put("back/deleteThirdTool", "perms[delete]");
        filterChainDefinitionMap.put("back/updateThirdTool", "perms[update]");
        filterChainDefinitionMap.put("back/queryThirdTool", "perms[query]");
        filterChainDefinitionMap.put("back/queryThirdToolAccurate", "perms[query]");
        filterChainDefinitionMap.put("/druid/**", "anon");
        // 需要登陆访问的资源，一般将 /** 放在最下面
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    /**
     * Spring 的一个 bean , 由 Advisor 决定对哪些类的方法进行AOP代理。
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor
    authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
     * lifecycleBeanPostProcessor 是负责生命周期的 , 初始化和销毁的类
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}
