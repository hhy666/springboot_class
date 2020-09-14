package com.sClass.configs;

import com.sClass.interceptors.MyInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//对拦截器进行配置
@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    //覆盖父类中添加拦截器的方法
    @Override
    //InterceptorRegistry:拦截器注册对象
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyInterceptor())//用来添加一个拦截器
                .addPathPatterns("/**")//拦截哪些请求
                .excludePathPatterns("/student/login")
                .excludePathPatterns("/student/imageCode")
                .excludePathPatterns("/statics/**");//放行哪些请求
    }
}
