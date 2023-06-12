package com.health.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.health.demo.dtos.UserDto;
import com.health.demo.entities.User;

import com.health.demo.repositories.UserRepo;
import com.health.demo.services.UserService;
//@CrossOrigin(maxAge = 3000)
@RestController
@RequestMapping("/health/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	
	
	
	@PostMapping("/register")
	public ResponseEntity<?> RegisterUser(@Valid @RequestBody UserDto userDto)
	{
		User existingUser = userRepo.findByEmail(userDto.getEmail());
		
		if(existingUser == null)
		{
			System.out.println("user created");
			UserDto userdtos=userService.createUser(userDto);
			return new ResponseEntity<UserDto>(userdtos , HttpStatus.CREATED);
			
		}else
		{
			System.out.println("Existing user");
			return new ResponseEntity<>("Use New Email !!!", HttpStatus.NOT_ACCEPTABLE);
		}
}
	

	@PostMapping("/login")
	public Optional<User> login(@RequestBody UserDto loginUser) {
		System.out.println(loginUser);
		User userFromMail = userRepo.findByEmail(loginUser.getEmail());
		String normalPass = loginUser.getPassword();
		String encodedPass = userFromMail.getPassword();
		if (normalPass.equals(encodedPass)) {
			System.out.println("Login Method Called");
			Optional<User> validatedUser = userRepo.findByEmailAndPassword(loginUser.getEmail(),
					userFromMail.getPassword());
			System.out.println(validatedUser);
			return validatedUser;
		} else {
			return null;
		}

	}
	
	@PutMapping("/{userId}")
public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto ,@PathVariable Integer userId)
{
		UserDto updatedUser=userService.updateUser(userDto, userId);
		
	return 	 ResponseEntity.ok(updatedUser);
}

	

	

}
