package com.devskiller.tasks.blog.model.dto;

import javax.validation.constraints.NotBlank;

public class NewCommentDto {

	@NotBlank
	private String author;

	@NotBlank
	private String content;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
