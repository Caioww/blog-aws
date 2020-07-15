package com.spring.blogsaws.controller;


import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/posts/{id}")
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postsDetail");
		Post postId = service.findById(id);	
		mv.addObject("post", postId);
		return mv;
	}
	
	@GetMapping("/newpost")
	public ModelAndView getPostForm() {
		ModelAndView mv = new ModelAndView("postForm");
		return mv;
	}
	
	@PostMapping("/newpost")
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		service.save(post);
		
		return "redirect:/posts";
	}
	
	

}
