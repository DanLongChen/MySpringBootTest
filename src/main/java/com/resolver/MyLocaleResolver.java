package com.resolver;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by DanLongChen on 2018/11/24
 **/
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l=request.getParameter("l");
//        System.out.println(l);
        Locale locale=Locale.getDefault();
        if(l!=null&&l.length()!=0){
            String[] la=l.split("_");
            locale=new Locale(la[0],la[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
