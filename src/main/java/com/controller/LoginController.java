package com.controller;

import com.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by DanLongChen on 2018/11/26
 **/
@Controller
public class LoginController {
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,String> map, HttpSession session){
        //后面的参数都会被放入到request对象中
        if(!username.isEmpty() && password.equals("123")){
            session.setAttribute("username",username);
            return "redirect:/main";
        }else{
            map.put("msg","用户名密码错误");
            return "index";
        }
    }

    @GetMapping("/test/{id}")
    @ResponseBody
    public String hello(@PathVariable("id") Integer id){
        if(id==0){
            throw new UserNotExistException();
        }else{
            return "hello";
        }
    }
}
