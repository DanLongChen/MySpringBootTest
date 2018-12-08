package com.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * Created by DanLongChen on 2018/12/7
 **/
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    //返回的这个map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map = super.getErrorAttributes(webRequest,includeStackTrace);
        map.putAll((Map<String,Object>)webRequest.getAttribute("exc",0));
        return map;
    }

}
