package com.forum.biz.impl;

import com.forum.biz.UserBiz;
import com.forum.dao.UserDao;
import com.forum.dao.impl.UserDaoImpl;
import com.forum.entity.User;

public class UserBizImpl implements UserBiz{

	UserDao userDao = new  UserDaoImpl();
	@Override
	public User checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.checkLogin(username, password);
	}
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

}
