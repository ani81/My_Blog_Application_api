package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entites.User;
import com.blog.payloads.UserDto;
import com.blog.repositories.UserRepo;
import com.blog.services.UserServices;
import com.blog.exception.*;

@Service
public class UserServiceimpl implements UserServices {

    @Autowired
	private UserRepo userRepo;
    @Autowired
    private ModelMapper modelmapper;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.DtoToUser(userDto);
		
		User  savedUser = this.userRepo.save(user);
		
     
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

	User user= this.userRepo.findById(userId)
			.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
	user.setName(userDto.getName());
	user.setEmail(userDto.getEmail());
	user.setPassword(userDto.getPassword());
	user.setAbout(userDto.getAbout());

    User updateUser =	this.userRepo.save(user);
	UserDto userDto1 =   this.userToDto(updateUser);
	return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {

		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos =	users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {

	User user =	this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);
		
	}
   
	private User DtoToUser(UserDto userDto)
	{
		User user = this.modelmapper.map(userDto , User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		
		return user;
	}
	
	
	public UserDto userToDto(User user) {
		
		UserDto userDto =this.modelmapper.map(user, UserDto.class);
		
		return userDto;
			}

}
