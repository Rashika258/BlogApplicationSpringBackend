package com.springboot.web.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.entities.Comment;
import com.springboot.web.entities.Post;
import com.springboot.web.exceptions.ResourceNotFoundException;
import com.springboot.web.payloads.CommentDto;
import com.springboot.web.repositories.CommentRepo;
import com.springboot.web.repositories.PostRepo;
import com.springboot.web.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post ", "post id ", postId));
		
		Comment comment=this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		Comment savedComment=this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
		
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		Comment com=this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment ", "Comment Id ", commentId));
		this.commentRepo.delete(com);
	}

}
