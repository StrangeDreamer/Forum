package com.forum.biz;

import java.util.List;

import com.forum.entity.Information;

public interface InformationBiz {
	List<Information> getTopicInformations(int topicId,int pageNo,int pageSize);
	//获取该topic的information总记录数
	int getTopicsInfoRows(int topicId);
	
	//添加回复信息
	int addInformation(Information information);
	//删除信息
	int deleteInformation(int information_id);
}
