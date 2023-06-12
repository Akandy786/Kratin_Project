package com.health.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.demo.dtos.MedicalDto;
import com.health.demo.entities.Medical;
import com.health.demo.exceptions.ResourceNotFoundException;
import com.health.demo.repositories.MedicalRepo;
import com.health.demo.services.MedicalService;

@Service
public class MedicalServiceImpl implements MedicalService {
	
	@Autowired
	MedicalRepo medicalRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public MedicalDto createMedical(MedicalDto medicalDto) {
		Medical medical = new Medical();
		medical.setShopkeeperName(medicalDto.getShopkeeperName());
		medical.setShopName(medicalDto.getShopName());
		medical.setEmail(medicalDto.getEmail());
		medical.setMobileNo(medicalDto.getMobileNo());
		medical.setPassword(medicalDto.getPassword());
		medical.setAddress(medicalDto.getAddress());
		medical.setPin(medicalDto.getPin());
		medical.setOpenTime(medicalDto.getOpenTime());
		medical.setCloseTime(medicalDto.getCloseTime());
		Medical med = medicalRepo.save(medical);
		MedicalDto medicalDto1 = modelMapper.map(med, MedicalDto.class);
		return medicalDto1;
	}

	@Override
	public MedicalDto updateMedical(MedicalDto medicalDto, Integer medicalId) {
		
		Medical med =medicalRepo.findById(medicalId).orElseThrow(()-> new ResourceNotFoundException("Medical","medical id", medicalId));
		med.setShopkeeperName(medicalDto.getShopkeeperName());
		med.setShopName(medicalDto.getShopName());
		med.setEmail(medicalDto.getEmail());
		med.setMobileNo(medicalDto.getMobileNo());
		med.setPassword(medicalDto.getPassword());
		med.setAddress(medicalDto.getAddress());
		med.setPin(medicalDto.getPin());
		med.setOpenTime(medicalDto.getOpenTime());
		med.setCloseTime(medicalDto.getCloseTime());
		Medical med1 = medicalRepo.save(med);
		
		MedicalDto medicalDto1 = modelMapper.map(med1, MedicalDto.class);
		// TODO Auto-generated method stub
		return medicalDto1;
	}

	@Override
	public List<MedicalDto> getAllmedical() {
		List<Medical> medicals = medicalRepo.findAll();
		
		List<MedicalDto> medicaldtos = medicals.stream().map((medical)-> modelMapper.map(medical, MedicalDto.class)).collect(Collectors.toList());
		
		
		
		
		
		// TODO Auto-generated method stub
		return medicaldtos;
	}

	@Override
	public List<MedicalDto> getMedicalByPin(String pin) {
		List<Medical> medicals = medicalRepo.findBypin(pin);
		
		List<MedicalDto> medicaldtos = medicals.stream().map((medical)-> modelMapper.map(medical, MedicalDto.class)).collect(Collectors.toList());
		
		// TODO Auto-generated method stub
		return medicaldtos;
	}

}
