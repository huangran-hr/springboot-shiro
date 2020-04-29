package com.hr.springboot.interceptor;

import com.hr.springboot.request.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: HR
 * @Date: 2020/4/20 11:23
 * @Description:
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 由于跨域情况下会先发出一个 options 请求试探，这个请求是不带 cookie 信息的，所以 shiro 无法获取到 sessionId，将导致认证失败
        // 放行 options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变，shiro 验证失败
        if (HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isRemembered());
        System.out.println(subject.isAuthenticated());
        // 使用 shiro 验证
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            return false;
        }
        return true;
    }

    private boolean begingWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            if(requiredAuthPage.contains(page)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
