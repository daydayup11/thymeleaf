package com.xq.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            return true;
        }else{
            request.setAttribute("msg","请先登录");
            //转发到登录页面
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
    }
}
