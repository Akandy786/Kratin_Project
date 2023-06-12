package com.health.demo.dtos;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter


public class UserDto {
private Integer user_id;
	
	@NotEmpty
	@Size(min = 3,message = "Username Must be of min 3 characters")
	private String name;
	@Email (message = "Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min = 3 , max = 10 ,message = "Password must be min of 3 characters and max of 10 characters")
	private String password;

	
	@NotNull
	private Integer age;
	
	
	private String address;
	
	private String pin;
	
	private String mobileNo;

}
