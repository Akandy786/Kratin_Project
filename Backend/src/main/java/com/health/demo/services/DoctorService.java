package com.health.demo.services;

import java.util.List;

import com.health.demo.dtos.DoctorDto;
import com.health.demo.dtos.MedicalDto;

public interface DoctorService {

	//register doctor
	
		DoctorDto createDoctor(DoctorDto doctorDto) ;
		
		//update information
		
		DoctorDto updateDoctor(DoctorDto doctorDto,Integer doctorId);
		
		//get all doctor
		
		List<DoctorDto> getAllDoctor();
		
		//get all Doctor By pin
		
		List<DoctorDto> getDoctorByPin(String pin);
}
