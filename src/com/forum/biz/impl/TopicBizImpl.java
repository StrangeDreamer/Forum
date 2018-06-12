package com.forum.biz.impl;

import java.util.List;

import com.forum.biz.TopicBiz;
import com.forum.dao.TopicDao;
import com.forum.dao.impl.TopicDaoImpl;
import com.forum.entity.Topic;


public class TopicBizImpl implements TopicBiz{
	TopicDao topicDao = new TopicDaoImpl();
	@Override
	public List<Topic> getTopicsByPage(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		return topicDao.getTopicsByPage(pageNo,pageSize);
	}
	@Override
	public int getTopicsRows() {
		// TODO Auto-generated method stub
		return topicDao.getTopicsRows();
	}
	@Override
	public int addTopic(Topic topic) {
		// TODO Auto-generated method stub
		return topicDao.addTopic(topic);
	}
	@Override
	public Topic getTopicById(int topicId) {
		// TODO Auto-generated method stub
		
		return topicDao.getTopicById(topicId);
	}

}
