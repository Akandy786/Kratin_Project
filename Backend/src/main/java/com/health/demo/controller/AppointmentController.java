package com.health.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.demo.dtos.AppointmentDto;
import com.health.demo.services.AppointmentService;

@CrossOrigin(maxAge = 3000)
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appService;
	
	
	@PostMapping("/user/{userId}/doctor/{doctorId}")
	public String createAppointment(@RequestBody AppointmentDto dto,
			@PathVariable Integer userId,@PathVariable Integer doctorId)
	{
		appService.CreateAppoiment(dto, userId, doctorId);
	
	return  "added sucessfully";
	
}
}
