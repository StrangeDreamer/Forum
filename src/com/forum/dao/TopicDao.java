package com.forum.dao;

import java.util.List;

import com.forum.entity.Topic;

public interface TopicDao {
	List<Topic> getTopicsByPage(int pageNo,int pageSize);
	//获取总记录数
	int getTopicsRows();
	//增加topic
	int addTopic(Topic topic);
	//通过topicId查找topic
	Topic getTopicById(int topicId);
}
