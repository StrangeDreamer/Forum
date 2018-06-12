package com.forum.biz;

import java.util.List;

import com.forum.entity.Topic;

public interface TopicBiz {
	List<Topic> getTopicsByPage(int pageNo,int pageSize);
	int getTopicsRows();
	//增加topic
	int addTopic(Topic topic);
	//通过topicId查找topic
	Topic getTopicById(int topicId);
}
