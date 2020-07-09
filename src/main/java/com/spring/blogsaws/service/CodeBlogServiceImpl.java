package com.spring.blogsaws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blogsaws.model.Post;
import com.spring.blogsaws.repository.CodeBlogRepository;

@Service
public class CodeBlogServiceImpl implements CodeBlogService{

	@Autowired
	CodeBlogRepository codeblogRepository;
	@Override
	public List<Post> findAll() {
		return codeblogRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		return codeblogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return codeblogRepository.save(post);
	}

}
