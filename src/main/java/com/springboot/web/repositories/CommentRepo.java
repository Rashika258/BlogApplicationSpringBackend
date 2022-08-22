package com.springboot.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
