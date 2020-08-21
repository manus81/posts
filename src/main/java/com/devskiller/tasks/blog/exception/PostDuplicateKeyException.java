package com.devskiller.tasks.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostDuplicateKeyException extends RuntimeException {

	private static final long serialVersionUID = -5483957072712508903L;

	public PostDuplicateKeyException(String exception) {
		super(exception);
	}

}
