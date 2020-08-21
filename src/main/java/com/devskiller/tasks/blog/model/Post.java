package com.devskiller.tasks.blog.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class Post {

	@Id
	@NotBlank
	private String id;

	@NotBlank
	private String title;

	@NotBlank
	private String content;

	@NotBlank
	private LocalDateTime creationDate;

	public Post(String id, String title, String content, LocalDateTime creationDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
}
