package com.forum.dao.impl;

import java.sql.ResultSet;

import com.forum.dao.UserDao;
import com.forum.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public User checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			openConnection();
			String sql = "select * from user where username=? and password=?";
			ResultSet rs = executeQuery(sql, new Object[]{username,password});
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			closeResource();
		}
		return user;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User user=null;
		try {
			openConnection();
			String sql = "select * from User where id=?";
			Object[] params= new Object[]{id};
			ResultSet rs = executeQuery(sql, params);
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			closeResource();
		}
		return user;
	}
	
}
