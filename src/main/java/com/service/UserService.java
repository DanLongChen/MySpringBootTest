package com.service;

import com.entity.User;

/**
 * @author:DanLongChen
 * @versioin:2018年11月21日下午2:45:32
 **/
public interface UserService {
	public User getUserById(Long id);

	public void updateUser(Long id, Integer type);
}
