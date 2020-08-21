package com.devskiller.tasks.blog.model.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

public class PostDto {

	@NotBlank
	private String title;

	@NotBlank
	private String content;

	private LocalDateTime creationDate;

	public PostDto(String title, String content, LocalDateTime creationDate) {
		this.title = title;
		this.content = content;
		this.creationDate = creationDate;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}
}
