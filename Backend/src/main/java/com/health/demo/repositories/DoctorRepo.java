package com.health.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.demo.entities.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
	

	Doctor findByEmail(String email);

	Optional<Doctor> findByEmailAndPassword(String email, String password);
	
	List<Doctor> findBypin(String pin);

}
