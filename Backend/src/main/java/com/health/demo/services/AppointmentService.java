package com.health.demo.services;

import org.springframework.stereotype.Service;

import com.health.demo.dtos.AppointmentDto;


public interface AppointmentService {
	
	AppointmentDto CreateAppoiment(AppointmentDto appoimentDto , Integer docterId,Integer userId);

}
