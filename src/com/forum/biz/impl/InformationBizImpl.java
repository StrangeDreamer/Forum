package com.forum.biz.impl;

import java.util.List;

import com.forum.biz.InformationBiz;
import com.forum.dao.InformationDao;
import com.forum.dao.impl.InformationDaoImpl;
import com.forum.entity.Information;

public class InformationBizImpl implements InformationBiz{
	InformationDao informationDao = new InformationDaoImpl();
	@Override
	public List<Information> getTopicInformations(int topicId,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		return informationDao.getTopicInformations(topicId,pageNo,pageSize);
	}
	
	@Override
	public int addInformation(Information information) {
		// TODO Auto-generated method stub
		return informationDao.addInformation(information);
	}

	@Override
	public int getTopicsInfoRows(int topicId) {
		// TODO Auto-generated method stub
		return informationDao.getTopicsInfoRows(topicId);
	}

	@Override
	public int deleteInformation(int information_id) {
		// TODO Auto-generated method stub
		return informationDao.deleteInformation(information_id);
	}
}
