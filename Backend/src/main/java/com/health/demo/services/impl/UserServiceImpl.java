package com.health.demo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.demo.dtos.UserDto;
import com.health.demo.entities.User;
import com.health.demo.exceptions.ResourceNotFoundException;
import com.health.demo.repositories.UserRepo;
import com.health.demo.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAge(userDto.getAge());
		user.setMobileNo(userDto.getMobileNo());
		user.setAddress(userDto.getAddress());
		user.setPin(userDto.getPin());
		User user1= userRepo.save(user);
		
		UserDto userDto1 = modelMapper.map(user1, UserDto.class);
		return null;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userid",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAge(userDto.getAge());
		user.setMobileNo(userDto.getMobileNo());
		user.setAddress(userDto.getAddress());
		user.setPin(userDto.getPin());
User updatedUser=userRepo.save(user);
		
		UserDto userDto1=modelMapper.map(updatedUser, UserDto.class);
		// TODO Auto-generated method stub
		return userDto1;
	}

}
