package com.devskiller.tasks.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3283806405330059382L;

	public PostNotFoundException(String exception) {
		super(exception);
	}

}
