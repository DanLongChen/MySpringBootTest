package com.conf;

import com.servlet.myServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by DanLongChen on 2018/12/7
 **/
@Configuration
public class MyServletConfig {
    /**
     * 注册servlet三大组件
     */
    @Bean
    public ServletRegistrationBean myServet(){
        ServletRegistrationBean bean= new ServletRegistrationBean(new myServlet(),"/servlet");
        return bean;
    }
}
