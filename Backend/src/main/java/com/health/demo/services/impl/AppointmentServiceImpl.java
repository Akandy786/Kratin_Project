package com.health.demo.services.impl;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.demo.dtos.AppointmentDto;
import com.health.demo.entities.Appointment;
import com.health.demo.entities.Doctor;
import com.health.demo.entities.User;
import com.health.demo.exceptions.ResourceNotFoundException;
import com.health.demo.repositories.AppointmentRepo;
import com.health.demo.repositories.DoctorRepo;
import com.health.demo.repositories.UserRepo;
import com.health.demo.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public AppointmentDto CreateAppoiment(AppointmentDto dto, Integer docterId,Integer userId) {
		
		
		Doctor docter = doctorRepo.findById(docterId).orElseThrow(()-> new ResourceNotFoundException("Docter","Doctor Id",docterId));
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User Id",userId));
		
	Appointment app=new Appointment();
	app.setAppointment(dto.getAppointment());
	app.setDescription(dto.getDescription());
	app.setTime(dto.getTime());
	app.setDoctor(docter);
	app.setUser(user);
	
	Appointment app1=appointmentRepo.save(app);
	AppointmentDto appdtos = modelMapper.map(app1,AppointmentDto.class );
	


		
		return appdtos;

}}
