package com.conf;

import com.interceptors.SessionHandlerInterceptor;
import com.resolver.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:DanLongChen
 * @versioin:2018年11月20日下午9:35:37
 **/
@Configuration // 定义成配置类
public class MvcConfigurer implements WebMvcConfigurer {
    @Autowired
    SessionHandlerInterceptor myInterceptor;

    // 定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(myInterceptor).addPathPatterns("/View/test");// 路径最前面那个/是一定要加的（表示绝对路径）
    }

    // 定义跨域访问
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TODO Auto-generated method stub
        // registry.addMapping("/api/**").allowedOrigins("http://domain2.com").allowedMethods("POST",
        // "GET");// 限定访问路径，允许访问的域，允许的方法
    }

    // 定义格式化
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // TODO Auto-generated method stub
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));//"yyyy-MM-dd HH:mm:ss"
    }

    // 定义uri到视图的映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // TODO Auto-generated method stub
        // System.out.println("addViewControllers");
        // registry.addViewController("/test/admin").setViewName("/index.btl");//
        // 请求、被转发的地址
        // registry.addRedirectViewController("/**/*.do", "index.html");//
        // 请求，被转发的地址（使用的转发）
    }


    /*
    定义自己的配置类，然后加入到总的配置类集合中
     */
    public static class addConfiguration implements WebMvcConfigurer {//WebMvcConfigurerAdapter类型已经被禁用

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("index");//用于配置欢迎页，因为欢迎页的查找是在static等静态资源目录下查找的，这里将其重新定位到tenplates
            registry.addViewController("/index").setViewName("index");
            registry.addViewController("/main").setViewName("dashboard");
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            //SpringBoot已经做好静态资源映射，因此不需要对其进行排除
//            registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/index", "/user/login");
        }
    }

    @Bean
    public addConfiguration myConfiguration() {
        return new addConfiguration();
    }

    /*
    导入自定义的国际化类
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
