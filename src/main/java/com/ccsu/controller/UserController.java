package com.ccsu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccsu.dao.UserDao;
import com.ccsu.domain.User;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/getUser")
	@ResponseBody
	public Map<String,Object> getUser(String number) {
		Map<String,Object> map= new HashMap<String,Object>();
		User user = userDao.findUserByUserNumber(number);
		map.put("name", user.getName());
		return map;
	}
}
