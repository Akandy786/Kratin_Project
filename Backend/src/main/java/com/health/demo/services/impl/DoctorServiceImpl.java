package com.health.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.demo.dtos.DoctorDto;
import com.health.demo.dtos.MedicalDto;
import com.health.demo.entities.Doctor;
import com.health.demo.entities.Medical;
import com.health.demo.exceptions.ResourceNotFoundException;
import com.health.demo.repositories.DoctorRepo;
import com.health.demo.services.DoctorService;


@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DoctorDto createDoctor(DoctorDto doctorDto) {
		Doctor doctor = new Doctor();
		doctor.setDoctorName(doctorDto.getDoctorName());
		doctor.setHospitalName(doctorDto.getHospitalName());
		doctor.setEmail(doctorDto.getEmail());
		doctor.setMobileNo(doctorDto.getMobileNo());
		doctor.setPassword(doctorDto.getPassword());
		doctor.setAddress(doctorDto.getAddress());
		doctor.setPin(doctorDto.getPin());
		doctor.setOpenTime(doctorDto.getOpenTime());
		doctor.setSpeciality(doctorDto.getSpeciality());
		doctor.setCloseTime(doctorDto.getCloseTime());
		
		
		Doctor doctor1 = doctorRepo.save(doctor);
		DoctorDto doctorDto1 = modelMapper.map(doctor1, DoctorDto.class);
		return doctorDto1;
		
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto doctorDto, Integer doctorId) {
		Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(()-> new ResourceNotFoundException("Doctor","doctor id", doctorId));
		doctor.setDoctorName(doctorDto.getDoctorName());
		doctor.setHospitalName(doctorDto.getHospitalName());
		doctor.setEmail(doctorDto.getEmail());
		doctor.setMobileNo(doctorDto.getMobileNo());
		doctor.setPassword(doctorDto.getPassword());
		doctor.setAddress(doctorDto.getAddress());
		doctor.setPin(doctorDto.getPin());
		doctor.setOpenTime(doctorDto.getOpenTime());
		doctor.setCloseTime(doctorDto.getCloseTime());
		doctor.setSpeciality(doctorDto.getSpeciality());
		
		Doctor doctor1 = doctorRepo.save(doctor);
		DoctorDto doctorDto1 = modelMapper.map(doctor1, DoctorDto.class);
		// TODO Auto-generated method stub
		return doctorDto1;
	}

	@Override
	public List<DoctorDto> getAllDoctor() {
		
		List<Doctor> doctors= doctorRepo.findAll();
		
		List<DoctorDto> doctorDto = doctors.stream().map((doctor)-> modelMapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());
		
		// TODO Auto-generated method stub
		return doctorDto;
	}

	@Override
	public List<DoctorDto> getDoctorByPin(String pin) {
		List<Doctor> doctors = doctorRepo.findBypin(pin);
		List<DoctorDto> doctorDto = doctors.stream().map((doctor)-> modelMapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return doctorDto;
	}

}
