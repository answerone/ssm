package com.ccsu.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccsu.commons.Constants;
import com.ccsu.dao.UserDao;
import com.ccsu.domain.User;
import com.ccsu.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Map<String, Object> registerUser(User user) {
		Map<String,Object> map = new HashMap<String,Object>();
		User u = userDao.findUserByMobile(user.getMobile());
		if(u!= null && u.getMobile() != null&& !"".equals(u.getMobile())) {
			map.put("code", Constants.RESPONSE_CODE_FAIL);
			map.put("msg","该手机号码已经注册过，不需要重复注册");
			return map;
		}
		return null;
	}

	@Override
	public Map<String, Object> login(String number, String password) {
		return null;
	}

}
