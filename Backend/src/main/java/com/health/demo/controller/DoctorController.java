package com.health.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.demo.dtos.DoctorDto;
import com.health.demo.entities.Doctor;
import com.health.demo.repositories.DoctorRepo;
import com.health.demo.services.DoctorService;
@CrossOrigin(maxAge = 3000)
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@PostMapping("/register")
	public ResponseEntity<?> RegisterUser(@Valid @RequestBody DoctorDto doctorDto)
	{
		Doctor existingUser = doctorRepo.findByEmail(doctorDto.getEmail());
		
		if(existingUser == null)
		{
			System.out.println("Doctor profile created");
			DoctorDto doctordtos=doctorService.createDoctor(doctorDto);
			return new ResponseEntity<DoctorDto>(doctordtos , HttpStatus.CREATED);
			
		}else
		{
			System.out.println("Existing user");
			return new ResponseEntity<>("Use New Email !!!", HttpStatus.NOT_ACCEPTABLE);
		}
}
	

	@PostMapping("/login")
	public Optional<Doctor> login(@RequestBody DoctorDto loginUser) {
		System.out.println(loginUser);
		Doctor userFromMail = doctorRepo.findByEmail(loginUser.getEmail());
		String normalPass = loginUser.getPassword();
		String encodedPass = userFromMail.getPassword();
		if (normalPass.equals(encodedPass)) {
			System.out.println("Login Method Called");
			Optional<Doctor> validatedUser = doctorRepo.findByEmailAndPassword(loginUser.getEmail(),
					userFromMail.getPassword());
			System.out.println(validatedUser);
			return validatedUser;
		} else {
			return null;
		}

	}
	
	@PutMapping("/{doctorId}")
public ResponseEntity<DoctorDto> updateUser(@Valid @RequestBody DoctorDto medicalDto ,@PathVariable Integer doctorId)
{
		DoctorDto updatedDoctor=doctorService.updateDoctor(medicalDto, doctorId);
		
	return 	 ResponseEntity.ok(updatedDoctor);
}
	
	
	@GetMapping("/allDoctors")
	
	public ResponseEntity<List<DoctorDto>> getallDoctor()
	{
		List<DoctorDto> doctorDto=doctorService.getAllDoctor();
		
		return ResponseEntity.ok(doctorDto);
	}
	
	@GetMapping("/search/{pin}")
	public ResponseEntity<List<DoctorDto>> getDoctorsBypin(@PathVariable String pin)
	{
		List<DoctorDto> doc = doctorService.getDoctorByPin(pin);
		return ResponseEntity.ok(doc);
	}
}
