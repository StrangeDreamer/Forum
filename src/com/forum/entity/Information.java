package com.forum.entity;

/**
 * Information entity. @author MyEclipse Persistence Tools
 */

public class Information implements java.io.Serializable {

	// Fields

	private Integer id;
	private int topicId;
	private int userId;
	private String content;

	// Constructors

	/** default constructor */
	public Information() {
	}

	/** minimal constructor */
	public Information(int topicId, int userId) {
		this.topicId = topicId;
		this.userId = userId;
	}

	/** full constructor */
	public Information(int topicId, int userId, String content) {
		this.topicId = topicId;
		this.userId = userId;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTopicId() {
		return this.topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}