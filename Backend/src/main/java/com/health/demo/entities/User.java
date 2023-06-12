package com.health.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Setter
@Getter



public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
private Integer id;
	private String name;
private String email;
private String password;
private Integer age;
private String address;
private String  pin;
private String mobileNo;
	
	
}
