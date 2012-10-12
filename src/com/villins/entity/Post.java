package com.villins.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "tb_post")
@JsonIgnoreProperties(value={"tags","comments"})
public class Post {
	private int post_id;
	private String title;
	private Date created_at;
	private String content;
	private List<Tag> tags = new ArrayList<Tag>();
	private List<Comment> comments = new ArrayList<Comment>();

	@Id
	@GeneratedValue
	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int postId) {
		post_id = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date createdAt) {
		created_at = createdAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="post",
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}
			)
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "postId")
	public List<Comment> getComments() {
		return comments;
	}

	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
