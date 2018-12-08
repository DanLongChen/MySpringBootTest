package com.controller;

import com.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DanLongChen on 2018/12/7
 **/
//特殊的Controller，用于处理异常
@ControllerAdvice
public class ExceptionController {


    /*@ResponseBody//浏览器和客户端都会返回json（直接return的话会把信息写死，不能够自适应<浏览器访问和客户端访问不同>）
    @ExceptionHandler(UserNotExistException.class)//处理这类异常
    public Map<String,Object> handlerException(Exception e){
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("code","user not exist");
        map.put("message",e.getMessage());
        return map;
    }*/

    @ExceptionHandler(UserNotExistException.class)//处理这类异常
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<String ,Object>();
        //需要设置状态码400,500等，不然默然是200
        /***
         * Integer status = getAttribute(requestAttributes,
         * 				"javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user not exist");
        map.put("message","用户出错了");
        request.setAttribute("exc",map);
        return "forward:/error";//可以直接交给SpringBoot来做自适应(传给Spring对应的异常处理机制)
    }
}
