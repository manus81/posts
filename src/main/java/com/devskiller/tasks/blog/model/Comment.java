package com.devskiller.tasks.blog.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class Comment {
	
	@Id
	private String id;
	
	@NotBlank
	private String postId;

	@NotBlank
	private String content;

	@NotBlank
	private String author;

	@NotBlank
	private LocalDateTime creationDate;
	
	public Comment(String postId, String content, String author, LocalDateTime creationDate) {
		this.postId=postId;
		this.content=content;
		this.author=author;
		this.creationDate=creationDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
}
