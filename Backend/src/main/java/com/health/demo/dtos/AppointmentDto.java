package com.health.demo.dtos;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Service;

import com.health.demo.entities.Doctor;
import com.health.demo.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class AppointmentDto {

	private Integer id;
	private Date appointment;
	private  LocalTime time;
private String description ;
	private UserDto userDto;
	private DoctorDto doctorDto;
}
