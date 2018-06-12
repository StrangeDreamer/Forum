package com.forum.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.forum.dao.TopicDao;
import com.forum.entity.Topic;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	@Override
	public List<Topic> getTopicsByPage(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		List<Topic> topics = new ArrayList<Topic>();
		try {
			openConnection();
			String sql = "select * from topic limit ?,?";
			Object[] params = new Object[]{
					(pageNo-1)*pageSize,
					pageSize
			};		
			
			ResultSet rs = executeQuery(sql, params);
			while(rs.next()){
				Topic topic = new Topic();
				topic.setDate(rs.getDate("date"));
				topic.setId(rs.getInt("id"));
				topic.setTitle(rs.getString("title"));
				topic.setUserId(rs.getInt("userId"));
				topics.add(topic);
			}
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			closeResource();
		}
		return topics;
	}

	@Override
	public int getTopicsRows() {
		// TODO Auto-generated method stub
		int count=0;
		try {
			openConnection();			
			String sql = "select count(*) from topic";
			ResultSet rs = executeQuery(sql, null);
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
	public int addTopic(Topic topic) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			openConnection();
			String sql = "insert into topic(title,userId,date,content) value(?,?,?,?)";
			Object[] params = new Object[]{
					topic.getTitle(),
					topic.getUserId(),
					topic.getDate(),
					topic.getContent()	
			};
			count = executeUpdate(sql, params);
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
	public Topic getTopicById(int topicId) {
		// TODO Auto-generated method stub
		
		Topic topic=null;
		try {
			openConnection();
			String sql = "select * from Topic where id = ?";
			
			Object[] params = new Object[]{topicId};
			ResultSet rs = executeQuery(sql, params);
			
			while(rs.next()){
				topic = new Topic();
				topic.setContent(rs.getString("content"));
				topic.setDate(rs.getDate("date"));
				topic.setId(rs.getInt("id"));
				topic.setTitle(rs.getString("title"));
				topic.setUserId(rs.getInt("userId"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			closeResource();
		}
		return topic;
	}

}
