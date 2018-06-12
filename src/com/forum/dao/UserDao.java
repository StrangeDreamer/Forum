package com.forum.dao;

import com.forum.entity.User;


public interface UserDao {
	//登录
	User checkLogin(String username,String password);
	//通过id获取User
	User getUserById(int id);
}
