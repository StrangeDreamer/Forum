package com.forum.biz.impl;

import java.util.List;

import com.forum.biz.MessagesBiz;
import com.forum.dao.MessagesDao;
import com.forum.dao.impl.MessagesDaoImpl;
import com.forum.entity.Messages;

public class MessagesBizImpl implements MessagesBiz{
	MessagesDao messagesDao = new MessagesDaoImpl();
	@Override
	public int isRead(int id) {
		// TODO Auto-generated method stub
		return messagesDao.isRead(id);
	}
	@Override
	public List<Messages> getMessagesById(int id) {
		// TODO Auto-generated method stub
		return messagesDao.getMessagesById(id);
	}
	@Override
	public int addMsg(Messages message) {
		// TODO Auto-generated method stub
		return messagesDao.addMsg(message);
	}
	@Override
	public int updateMsg(int id) {
		// TODO Auto-generated method stub
		return messagesDao.updateMsg(id);
	}
	@Override
	public List<Messages> getMessagesBySenderId(int id) {
		// TODO Auto-generated method stub
		return messagesDao.getMessagesBySenderId(id);
	}

}
