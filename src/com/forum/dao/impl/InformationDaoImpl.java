package com.forum.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.ParamSupport;

import com.forum.dao.InformationDao;
import com.forum.entity.Information;

public class InformationDaoImpl extends BaseDao implements InformationDao {

	@Override
	public List<Information> getTopicInformations(int topicId,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		List<Information> informations = new ArrayList<Information>();
		try {
			openConnection();
			String sql = "select * from information where topicId=? limit ?,?";
			List<Object> params = new ArrayList<Object>();
			params.add(topicId);
			if(pageNo==1){	//第一页只有两个回复消息
				pageSize=2;
				params.add((pageNo-1)*pageSize);
				params.add(pageSize);
			}else{
				params.add((pageNo-1)*pageSize-1);
				params.add(pageSize);
			}
			
			ResultSet rs = executeQuery(sql, params.toArray());
			while(rs.next()){
				Information information = new Information();
				information.setContent(rs.getString("content"));
				information.setId(rs.getInt("id"));
				information.setTopicId(rs.getInt("topicId"));
				information.setUserId(rs.getInt("userId"));
				informations.add(information);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			closeResource();
		}

		return informations;
	}

	@Override
	public int addInformation(Information information) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			openConnection();
			String sql="insert into information(topicId,userId,content)" +
					"values(?,?,?)";
			Object[] params= new Object[]{
				information.getTopicId(),
				information.getUserId(),
				information.getContent()
			};
			count= executeUpdate(sql, params);
			//返回最新插入id
			sql="select last_insert_id()";
			ResultSet rs = executeQuery(sql, null);
			if(rs.next()){
				information.setId(rs.getInt(1));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			closeResource();
		}
		return count;
	}

	@Override
	public int getTopicsInfoRows(int topicId) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			openConnection();			
			String sql = "select count(*) from information where topicId=?";
			Object[] params = new Object[]{
				topicId
			};
			ResultSet rs = executeQuery(sql, params);
			if(rs.next()){
				count = rs.getInt(1);
			}	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			closeResource();
		}
		return count;
	}

	@Override
	public int deleteInformation(int information_id) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			openConnection();
			String sql = "delete from information where id=?";
			Object[] params = new Object[]{information_id};
			count= executeUpdate(sql, params);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			closeResource();
		}
		return count;
	}

}
