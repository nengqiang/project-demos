package com.hnq.blog.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置
 *
 * @author henengqiang
 * @date 2018/10/31
 */
@Configuration
public class WebMvcConfigurationAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*
         * 多个拦截器组成一个拦截器组
         * addPathPatterns 用于添加拦截规则
         * excludePathPatterns 用户排除拦截
         */
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
