package com.blog.controllers;

import java.util.List;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.API_Response;
import com.blog.payloads.UserDto;
import com.blog.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {

	
	@Autowired
	private UserServices userService;
	

	//POST -create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto =this.userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createUserDto,HttpStatus.CREATED);
	}
	
	
	//PUT -update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer userId){
	UserDto updateUser =this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updateUser);
		
	}
	
	
	//DELETE - DELETE USER
	@DeleteMapping("/{userId}")
	public ResponseEntity<API_Response> deleteUser(@PathVariable("userId")Integer uid){
		 	 this.userService.deleteUser(uid);
		 	return new ResponseEntity<API_Response>(new API_Response("User deleted sucessfully",true), HttpStatus.OK);
	}
	
	
	//GET - user get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	//GET - get user by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserbyId(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
}
