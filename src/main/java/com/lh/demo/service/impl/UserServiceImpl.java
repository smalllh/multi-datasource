package com.lh.demo.service.impl;

import com.lh.demo.entity.User;
import com.lh.demo.mapper.UserMapper;
import com.lh.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User get() {
		return userMapper.selectByPrimaryKey(1);
	}

}
