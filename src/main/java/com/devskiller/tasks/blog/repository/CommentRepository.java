package com.devskiller.tasks.blog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devskiller.tasks.blog.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
	
	List<Comment> findByPostId(String id);

}
