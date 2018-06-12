package com.forum.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BaseDao {
	//mysql驱动类
	String className = "com.mysql.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/forum";
	
	Connection connection;	//连接
	PreparedStatement statement;//命令
	ResultSet resultSet; //结果集
	
	//打开连接
	public void openConnection() throws ClassNotFoundException, SQLException{
		//加载驱动类
		Class.forName(className);
		connection = DriverManager.getConnection(dbUrl,"root","root");
	}
	
	//执行增删改
	public int executeUpdate(String sql,Object[] params) throws SQLException{
		
		statement = connection.prepareStatement(sql);
		if(params!=null){	//追加参数
			int i = 1;	//第几个占位符
			for(Object object : params){
				statement.setObject(i, object);
				i++;
			}
		}
		//执行sql
		int count = statement.executeUpdate();
		return count;
	}
	//查询
	public ResultSet executeQuery(String sql, Object[] params) throws SQLException{ //Object[] params解决sql语句中的占位符“？”
		statement = connection.prepareStatement(sql);
		if(params!=null){	//追加参数
			int i = 1;
			for(Object object : params){
				statement.setObject(i, object);
				i++;
			}
		}
		//执行select
		resultSet = statement.executeQuery();
		return resultSet;
	}
	//释放资源
	public void closeResource()
	{
		try {
			if(resultSet!=null){
				resultSet.close();	//关闭结果集	
			}
			if(statement!=null){
				statement.close();		
			}
			if(connection!=null){
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
