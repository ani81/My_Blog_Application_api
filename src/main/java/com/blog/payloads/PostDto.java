package com.blog.payloads;

import java.util.Date;

import com.blog.entites.Category;
import com.blog.entites.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor


public class PostDto {

	private Integer postid;
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user ;
	
	
	
	
	
	
	
	
	
	
}
