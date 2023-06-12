package com.health.demo.dtos;

import java.sql.Time;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MedicalDto {
	
	   private Integer medid ;
	   
	   
		@NotBlank
		private String shopkeeperName;
		
		@NotBlank
		private String shopName;
		
		private Time openTime;
		
		private Time closeTime;
		
		
		private String mobileNo;
		
		@Email (message = "Email address is not valid !!")
		private String email;
		
		private String password;
		

		private String address;
		
		private String pin;

}
