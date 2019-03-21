package com.ccsu.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ccsu.domain.User;

@Service
public interface UserService {
	public Map<String,Object> registerUser(User user);
	public Map<String,Object> login(String number,String password);
}
