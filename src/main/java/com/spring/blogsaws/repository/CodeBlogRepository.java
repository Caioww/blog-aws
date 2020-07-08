package com.spring.blogsaws.repository;

import com.spring.blogsaws.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeBlogRepository extends JpaRepository<Post, Long> {
}