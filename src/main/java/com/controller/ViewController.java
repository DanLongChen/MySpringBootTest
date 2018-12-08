/*
package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

*/
/**
 * @author:DanLongChen
 * @versioin:2018年11月21日上午10:26:47
 **//*

@PropertySource(value = {"classpath:person.properties"})
@Controller
@RequestMapping("/View")
public class ViewController {
    @Value("${person.age}")
    private String port;

    @GetMapping("/test")
    public void test() {
        System.out.println(port);
    }

    @GetMapping("/time")
    @ResponseBody
    public Map now() {
        Map map = new HashMap();
        map.put("time", new Date());
        return map;
    }

    @GetMapping("/get")
    @ResponseBody
    public String get(@RequestParam(value = "id", defaultValue = "20", required = true) int uid) {
        return "haha" + uid;
    }
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("index");
        view.addObject("message","success");
        view.addObject("text","<h4>this is text</h4>");
        view.addObject("utext","<h4>this is utext</h4>");
        view.addObject("list", new ArrayList<String>(Arrays.asList("zhangsan lisi wangwu".split(" "))) {
        });
        return view;
    }

}
*/
