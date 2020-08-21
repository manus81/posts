package com.devskiller.tasks.blog.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import com.devskiller.tasks.blog.model.dto.PostDto;
import com.devskiller.tasks.blog.service.CommentService;
import com.devskiller.tasks.blog.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController implements HandlerInterceptor {

	private final PostService postService;
	private final CommentService commentService;

	public PostController(PostService postService, CommentService commentService) {
		this.postService = postService;
		this.commentService = commentService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PostDto getPost(@PathVariable String id) {
		return postService.getPost(id);
	}

	@PostMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String savePost(@PathVariable String id, @Valid @RequestBody PostDto post) {
		return postService.savePost(id, post);
	}

	@GetMapping(value = "/{id}/comments")
	@ResponseStatus(HttpStatus.OK)
	public List<CommentDto> getComments(@PathVariable String id) {
		return commentService.getCommentsForPost(id);
	}

	@PostMapping(value = "/{id}/comments")
	@ResponseStatus(HttpStatus.CREATED)
	public String addComment(@PathVariable String id, @Valid @RequestBody NewCommentDto comment) {
		return commentService.addComment(id, comment);
	}
}
