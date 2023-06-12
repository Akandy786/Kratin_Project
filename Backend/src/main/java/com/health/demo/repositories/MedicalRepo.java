package com.health.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.demo.dtos.MedicalDto;
import com.health.demo.entities.Medical;
import com.health.demo.entities.User;

public interface MedicalRepo extends JpaRepository<Medical, Integer>{

	Medical findByEmail(String email);

	Optional<Medical> findByEmailAndPassword(String email, String password);
	
	List<Medical> findBypin(String pin);
}
