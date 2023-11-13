package com.blog.services;

import java.util.List;

import com.blog.entites.Post;
import com.blog.payloads.PostDto;

public interface PostService {

	//create 
	PostDto createPost(PostDto postDto,Integer userId ,Integer categoryId);
	
	//update 
	PostDto updatePost(PostDto postDto,Integer postId);
	
	// delete
	void deletePost(Integer postId);
	
	// get all post
	List<PostDto> getAllPost();
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	// get all post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// getallpostbyuser
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//Search posts
	List<Post> searchPosts(String keyword);

	
	
	
	
}
