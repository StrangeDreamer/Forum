package com.forum.biz;

import java.util.List;

import com.forum.entity.Messages;

public interface MessagesBiz {
	//查找该id是否有未读邮件
	int isRead(int id);
	//查找该user_id的所有邮件
	List<Messages> getMessagesById(int id);
	
	//发送邮件
	int addMsg(Messages message);
	//修改邮件为已读
	int updateMsg(int id);
	//发件箱邮件
	List<Messages> getMessagesBySenderId(int id);
}
