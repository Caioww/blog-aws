package com.spring.blogsaws.service;

import java.util.List;

import com.spring.blogsaws.model.Post;

public interface CodeBlogService {
	
	List<Post> findAll();
	Post findById(long id );
	Post save(Post post);
}
