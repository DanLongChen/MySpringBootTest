package com.service.impl;

import com.entity.User;
import com.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author:DanLongChen
 * @versioin:2018年11月21日下午2:47:14
 **/
@Service
//@Transactional
public class UserServiceImpl implements UserService {

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(Long id, Integer type) {
		// TODO Auto-generated method stub

	}

}
