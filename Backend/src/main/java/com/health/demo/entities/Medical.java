package com.health.demo.entities;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Medical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medid ;
	
	private String shopkeeperName;
	
	private String shopName;
	
	private Time openTime;
	
	private Time closeTime;
	
	private String mobileNo;
	
	private String email;
	private String password;
	

	private String address;
	
	private String pin;
	
	
	
	
}