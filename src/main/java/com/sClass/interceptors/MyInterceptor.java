package com.sClass.interceptors;

import com.sClass.entity.Student;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object method) throws Exception {
        //强制用户登录
        Student student = (Student) request.getSession().getAttribute("student1");
        if(student != null){
            return true;
        }
        //跳转到登录页面
        response.sendRedirect(request.getContextPath()+"/back/login.jsp");
        return false;
       //return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
