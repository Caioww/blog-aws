package com.spring.blogsaws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.blogsaws.model.Post;
import com.spring.blogsaws.service.CodeBlogService;

@Controller
public class CodeBlogController {
	
	@Autowired
	CodeBlogService service;
	
	@GetMapping("/posts")
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = service.findAll();	
		mv.addObject("listaPosts", posts);
		return mv;
	}

}
