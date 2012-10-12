package com.villins.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_comment")
public class Comment {
	private int comment_id;
	private String reviewer;
	private String email;
	private String content;
	
	@Id
	@GeneratedValue
	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int commentId) {
		comment_id = commentId;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
