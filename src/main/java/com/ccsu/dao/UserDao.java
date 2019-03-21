package com.ccsu.dao;

import com.ccsu.domain.User;

public interface UserDao {
	public User findUserByUserNumber(String number);
	public int addUser(User user);
	public User findUserByMobile(String mobile);
}
