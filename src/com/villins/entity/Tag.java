package com.villins.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tag")
public class Tag {
	private int tag_id;
	private String name;
	private Post post;
	
	@Id
	@GeneratedValue
	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tagId) {
		tag_id = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="postId")
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
