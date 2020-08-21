package com.devskiller.tasks.blog.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devskiller.tasks.blog.model.Post;
import com.devskiller.tasks.blog.model.dto.PostDto;
import com.devskiller.tasks.blog.repository.PostRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

	@Autowired
	PostRepository postRepository;

	@Autowired
	PostService postService;

	@Test
	public void shouldReturnCreatedPost() {
		LocalDateTime creationDate = LocalDateTime.of(2018, 5, 20, 20, 51, 16);
		Post post = new Post("1","Test title","Test content",creationDate);
		postRepository.save(post);

		PostDto postDto = postService.getPost(post.getId());
		
		assertNotNull("Post shouldn't be null", postDto);
		assertThat(postDto.getContent(), equalTo("Test content"));
		assertThat(postDto.getTitle(), equalTo("Test title"));
		assertThat(postDto.getCreationDate(), equalTo(creationDate));
	}

	@Test
	public void shouldReturnNullForNotExistingPost() {
		PostDto postDto = postService.getPost("123");

		assertNull(postDto);
	}
}