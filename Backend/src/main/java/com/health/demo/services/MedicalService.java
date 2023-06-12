package com.health.demo.services;

import java.util.List;

import com.health.demo.dtos.MedicalDto;

public interface MedicalService {
	
	//register Medical Shop
	
	MedicalDto createMedical(MedicalDto medicalDto) ;
	
	//update information
	
	MedicalDto updateMedical(MedicalDto medicalDto,Integer medicalId);

	
	//get All medical 
	List<MedicalDto> getAllmedical();
	
	// get medical by pin
	List<MedicalDto> getMedicalByPin(String pin);
}
