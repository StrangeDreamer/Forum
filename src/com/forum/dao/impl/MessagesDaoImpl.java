package com.forum.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.forum.dao.MessagesDao;
import com.forum.entity.Messages;

public class MessagesDaoImpl extends BaseDao implements MessagesDao {

	@Override
	public int isRead(int id) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			openConnection();
			String sql = "select count(*) from messages where receiverid=? and isread=0";
			Object[] params = new Object[] { id };
			ResultSet rs = executeQuery(sql, params);
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

	@Override
	public List<Messages> getMessagesById(int id) {
		// TODO Auto-generated method stub
		List<Messages> messages = new ArrayList<Messages>();
		try {
			openConnection();
			String sql = "select * from messages where receiverid=? order by sendtime desc";
			Object[] params = new Object[] { id };
			ResultSet rs = executeQuery(sql, params);
			while (rs.next()) {
				Messages message = new Messages();
				message.setContent(rs.getString("content"));
				message.setId(rs.getInt("id"));
				message.setIsdeletedbyreceiver(rs
						.getBoolean("isdeletedbyreceiver"));
				message.setIsdeletedbysender(rs.getBoolean("isdeletedbysender"));
				message.setIsread(rs.getBoolean("isread"));
				message.setReceiverid(rs.getInt("receiverid"));
				message.setSenderid(rs.getInt("senderid"));
				message.setSendtime(rs.getDate("sendtime"));
				message.setTitle(rs.getString("title"));
				messages.add(message);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return messages;
	}

	public int addMsg(Messages message) {
		int count = 0;
		try {
			openConnection();
			String sql = "insert into messages(title,sendtime,content,senderid,receiverid) values(?,?,?,?,?)";

			Object[] paramsObjects = new Object[] { message.getTitle(),
					message.getSendtime(), message.getContent(),
					message.getSenderid(), message.getReceiverid() };
			count = executeUpdate(sql, paramsObjects);
			ResultSet resultSet = executeQuery("select last_insert_id()", null);
			while (resultSet.next()) {
				message.setId(resultSet.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return count;
	}

	@Override
	public int updateMsg(int id) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			openConnection();
			String sql = "update messages set isread=1 where id=?";
			Object[] params =new Object[]{id};
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
	public List<Messages> getMessagesBySenderId(int id) {
		// TODO Auto-generated method stub
		List<Messages> messages = new ArrayList<Messages>();
		try {
			openConnection();
			String sql = "select * from messages where senderid=? order by sendtime desc";
			Object[] params = new Object[] { id };
			ResultSet rs = executeQuery(sql, params);
			while (rs.next()) {
				Messages message = new Messages();
				message.setContent(rs.getString("content"));
				message.setId(rs.getInt("id"));
				message.setIsdeletedbyreceiver(rs
						.getBoolean("isdeletedbyreceiver"));
				message.setIsdeletedbysender(rs.getBoolean("isdeletedbysender"));
				message.setIsread(rs.getBoolean("isread"));
				message.setReceiverid(rs.getInt("receiverid"));
				message.setSenderid(rs.getInt("senderid"));
				message.setSendtime(rs.getDate("sendtime"));
				message.setTitle(rs.getString("title"));
				messages.add(message);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return messages;
	}

}
