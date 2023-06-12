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

import com.health.demo.dtos.MedicalDto;

import com.health.demo.entities.Medical;

import com.health.demo.repositories.MedicalRepo;

import com.health.demo.services.MedicalService;

@CrossOrigin(maxAge = 3000)
@RestController
@RequestMapping("/medical")
public class MedicalController {
	
	@Autowired
	private MedicalService medicalService;
	
	@Autowired
	private MedicalRepo medicalRepo;
	
	@PostMapping("/register")
	public ResponseEntity<?> RegisterUser(@Valid @RequestBody MedicalDto medicalDto)
	{
		Medical existingUser = medicalRepo.findByEmail(medicalDto.getEmail());
		
		if(existingUser == null)
		{
			System.out.println("medical shop created");
			MedicalDto medicaldtos=medicalService.createMedical(medicalDto);
			return new ResponseEntity<MedicalDto>(medicaldtos , HttpStatus.CREATED);
			
		}else
		{
			System.out.println("Existing user");
			return new ResponseEntity<>("Use New Email !!!", HttpStatus.NOT_ACCEPTABLE);
		}
}
	

	@PostMapping("/login")
	public Optional<Medical> login(@RequestBody MedicalDto loginUser) {
		System.out.println(loginUser);
		Medical userFromMail = medicalRepo.findByEmail(loginUser.getEmail());
		String normalPass = loginUser.getPassword();
		String encodedPass = userFromMail.getPassword();
		if (normalPass.equals(encodedPass)) {
			System.out.println("Login Method Called");
			Optional<Medical> validatedUser = medicalRepo.findByEmailAndPassword(loginUser.getEmail(),
					userFromMail.getPassword());
			System.out.println(validatedUser);
			return validatedUser;
		} else {
			return null;
		}

	}
	
	@PutMapping("/{medicalId}")
public ResponseEntity<MedicalDto> updateUser(@Valid @RequestBody MedicalDto medicalDto ,@PathVariable Integer medicalId)
{
		MedicalDto updatedMedical=medicalService.updateMedical(medicalDto, medicalId);
		
	return 	 ResponseEntity.ok(updatedMedical);
}
	
	@GetMapping("/allmedicals")
	
	public ResponseEntity<List<MedicalDto>> getAllMedicals()
	{
		List<MedicalDto> medicalDto = medicalService.getAllmedical();
		return ResponseEntity.ok(medicalDto);
	}
	
	@GetMapping("/search/{pin}")
	
	public ResponseEntity<List<MedicalDto>> getMedicalByPin(@PathVariable String pin)
	{
		List<MedicalDto> med = medicalService.getMedicalByPin(pin);
		
		return ResponseEntity.ok(med);
	}
	

}
