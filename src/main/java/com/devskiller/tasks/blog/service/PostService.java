package com.devskiller.tasks.blog.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.devskiller.tasks.blog.exception.PostDuplicateKeyException;
import com.devskiller.tasks.blog.model.Post;
import com.devskiller.tasks.blog.model.dto.PostDto;
import com.devskiller.tasks.blog.repository.PostRepository;

@Service
public class PostService {

	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public PostDto getPost(String id) {
		return postRepository.findById(id)
				.map(post -> new PostDto(post.getTitle(), post.getContent(), post.getCreationDate())).orElse(null);
	}

	public String savePost(String id, PostDto postDto) {

		try {
			final LocalDateTime creationDate = Optional.ofNullable(postDto.getCreationDate()).orElse(LocalDateTime.now());
			Post post = postRepository
					.insert(new Post(id, postDto.getTitle(), postDto.getContent(), creationDate));
			return post.getId();
		} catch (DuplicateKeyException e) {
			throw new PostDuplicateKeyException("Post already exist with id" + id);
		}
	}
}
