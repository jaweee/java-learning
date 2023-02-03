package com.hmdp.utils;

import com.hmdp.entity.User;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: 登录拦截，在访问所有的controller之前做登录校验，看是否有session
 * @author: jiawei
 * @date: 2023/2/3 13:59
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在访问controller之前需要做登录校验
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        // 如果没登录之前就访问，
        if (user == null) {
            response.setStatus(400);
            return false;
        }
        UserHolder.saveUser((User)user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}
