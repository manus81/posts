package com.devskiller.tasks.blog.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devskiller.tasks.blog.model.Post;
import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import com.devskiller.tasks.blog.repository.PostRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentService commentService;

	@Test
	public void shouldAddComment() {
		Post post = createTestPost();

		NewCommentDto comment = new NewCommentDto();
		comment.setAuthor("Author");
		comment.setContent("Content");
		String commentId = commentService.addComment(post.getId(), comment);

		assertThat("Comment id shouldn't be null", commentId, notNullValue());
	}

	private Post createTestPost() {
		Post post = new Post("1","Test title","Test content", LocalDateTime.of(2018, 5, 20, 20, 51, 16));
		postRepository.save(post);
		return post;
	}

	@Test
	public void shouldReturnAddedComment() {
		Post post = createTestPost();

		NewCommentDto comment = new NewCommentDto();
		comment.setAuthor("Author");
		comment.setContent("Content");

		commentService.addComment(post.getId(), comment);

		List<CommentDto> comments = commentService.getCommentsForPost(post.getId());

		assertThat("There should be one comment", comments, hasSize(1));
		assertThat(comments.get(0).getAuthor(), equalTo("Author"));
		assertThat(comments.get(0).getComment(), equalTo("Content"));
	}
}