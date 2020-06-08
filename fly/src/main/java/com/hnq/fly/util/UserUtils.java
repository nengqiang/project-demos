package com.hnq.fly.util;

import com.hnq.fly.model.bo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author henengqiang
 * @date 2020/4/23
 */
@Slf4j
public class UserUtils {

    private UserUtils() {}

    public static LoginUser getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                log.warn("--没有获取到用户--");
                return null;
            }

            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                LoginUser loginUser = (LoginUser) authentication.getPrincipal();
                if (log.isDebugEnabled()) {
                    log.debug("获取到用户={}", loginUser);
                }
                return loginUser;
            }
        }
        log.warn("--没有获取到用户--");
        return null;
    }

}
