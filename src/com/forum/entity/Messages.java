package com.forum.entity;

import java.util.Date;

/**
 * Messages entity. @author MyEclipse Persistence Tools
 */

public class Messages implements java.io.Serializable {

	// Fields

	private Integer id;
	private int senderid;
	private int receiverid;
	private String title;
	private Date sendtime;
	private String content;
	private Boolean isread;
	private Boolean isdeletedbysender;
	private Boolean isdeletedbyreceiver;

	// Constructors

	/** default constructor */
	public Messages() {
	}

	/** minimal constructor */
	public Messages(Integer id, String title, Date sendtime, Boolean isread,
			Boolean isdeletedbysender, Boolean isdeletedbyreceiver) {
		this.id = id;
		this.title = title;
		this.sendtime = sendtime;
		this.isread = isread;
		this.isdeletedbysender = isdeletedbysender;
		this.isdeletedbyreceiver = isdeletedbyreceiver;
	}

	/** full constructor */
	public Messages(Integer id, int senderid, int receiverid,
			String title, Date sendtime, String content, Boolean isread,
			Boolean isdeletedbysender, Boolean isdeletedbyreceiver) {
		this.id = id;
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.title = title;
		this.sendtime = sendtime;
		this.content = content;
		this.isread = isread;
		this.isdeletedbysender = isdeletedbysender;
		this.isdeletedbyreceiver = isdeletedbyreceiver;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getTitle() {
		return this.title;
	}

	public int getSenderid() {
		return senderid;
	}

	public void setSenderid(int senderid) {
		this.senderid = senderid;
	}

	public int getReceiverid() {
		return receiverid;
	}

	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsread() {
		return this.isread;
	}

	public void setIsread(Boolean isread) {
		this.isread = isread;
	}

	public Boolean getIsdeletedbysender() {
		return this.isdeletedbysender;
	}

	public void setIsdeletedbysender(Boolean isdeletedbysender) {
		this.isdeletedbysender = isdeletedbysender;
	}

	public Boolean getIsdeletedbyreceiver() {
		return this.isdeletedbyreceiver;
	}

	public void setIsdeletedbyreceiver(Boolean isdeletedbyreceiver) {
		this.isdeletedbyreceiver = isdeletedbyreceiver;
	}

}