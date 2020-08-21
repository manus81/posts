package com.devskiller.tasks.blog.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devskiller.tasks.blog.exception.PostNotFoundException;
import com.devskiller.tasks.blog.model.Comment;
import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import com.devskiller.tasks.blog.repository.CommentRepository;

@Service
public class CommentService {
	
	final static String SEPARATOR = " ";

	private final CommentRepository commentRepository;
	private final PostService postService;

	public CommentService(CommentRepository commentRepository, PostService postService) {
		this.commentRepository = commentRepository;
		this.postService = postService;
	}

	/**
	 * Returns a list of all comments for a blog post with passed id.
	 *
	 * @param postId id of the post
	 * @return list of comments sorted by creation date descending - most recent
	 *         first
	 *
	 * @throws IllegalArgumentException if there is no blog post for passed postId
	 */
	public List<CommentDto> getCommentsForPost(String id) {

		return commentRepository.findByPostId(id).stream().map(comment -> new CommentDto(comment.getId(),
				comment.getContent(), comment.getAuthor(), comment.getCreationDate())).collect(Collectors.toList());
	}

	/**
	 * Creates a new comment
	 * 
	 * @param id post id 
	 * @param newCommentDto data of new comment
	 * 
	 * @return id of the created comment
	 *
	 * @throws IllegalArgumentException if there is no blog post for passed
	 *                                  newCommentDto.postId
	 */
	public String addComment(String id, NewCommentDto newCommentDto) {

		if (postService.getPost(id) == null) {
			throw new PostNotFoundException(String.join(SEPARATOR, "Post not exist with id", id));
		}

		Comment comment = commentRepository.insert(new Comment(id, newCommentDto.getContent(),
				newCommentDto.getAuthor(), LocalDateTime.now()));

		return comment.getId();
	}
}
