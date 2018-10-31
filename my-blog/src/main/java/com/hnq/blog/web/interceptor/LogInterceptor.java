package com.hnq.blog.web.interceptor;

import java.time.Clock;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 此拦截器统一打印输入输出日志
 * 
 * @author henengqiang
 * @date 2018/10/31
 */
public class LogInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
        throws Exception {
        // 打印请求头
        Enumeration<String> headNames = httpServletRequest.getHeaderNames();
        while (headNames.hasMoreElements()) {
            String s = headNames.nextElement();
            logger.debug("httpRequestHeader:" + s + "=" + httpServletRequest.getHeader(s));
        }

        String requestUrl = httpServletRequest.getRequestURI();
        String parameters = getParameters(httpServletRequest);
        Long mills = Clock.systemDefaultZone().millis();
        logger.info("requestUrl - {}, requestParams - {}, time - {}", requestUrl, parameters, mills);
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
        ModelAndView modelAndView) throws Exception {
        // 打印响应头
        Collection<String> headNames = httpServletResponse.getHeaderNames();
        headNames.forEach(
            headName -> logger.debug("httpResponseHeader:" + headName + "=" + httpServletResponse.getHeader(headName)));
        // TODO: 2018/10/31 henengqiang: 如何获取 httpServletResponse 内容
        String result = "";
        Long mills = Clock.systemDefaultZone().millis();
        logger.info("responseData - {}, time - {}", result, mills);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        Object o, Exception e) throws Exception {
    }

    private String getParameters(HttpServletRequest request) {
        Map<String, String[]> paramMap = request.getParameterMap();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        paramMap.forEach((key, value) -> sb.append(key).append(": ").append(Arrays.toString(value)).append(", "));
        // 当map有值时删掉最后的 ", "
        if (MapUtils.isNotEmpty(paramMap)) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("}");
        return sb.toString();
    }

}
