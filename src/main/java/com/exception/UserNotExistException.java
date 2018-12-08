package com.exception;

/**
 * Created by DanLongChen on 2018/12/7
 **/
public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("用户不存在");
    }
}
