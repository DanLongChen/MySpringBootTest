package com.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * @author:DanLongChen
 * @versioin:2018年11月19日上午11:28:22
 **/
public class User {
	// 定义更新时校验组
	public interface Update {
	}

	public interface Add {
	}

	@NotNull(groups = { Update.class })
	@Null(groups = { Add.class })
	public long id;
	@Size(min = 2, max = 3, message = "名字长度要在2~3之间")
	public String name;
	@Email(message = "Email格式错误")
	public String email;
}
