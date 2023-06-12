package com.health.demo.services;

import com.health.demo.dtos.UserDto;

public interface UserService {
	//create User
		UserDto createUser(UserDto userDto);
		
		//update User
		
		UserDto updateUser(UserDto userDto , Integer userId);
		
		// 
}
