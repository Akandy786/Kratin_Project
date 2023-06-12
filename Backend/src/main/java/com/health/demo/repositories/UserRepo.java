package com.health.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.demo.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
		User findByEmail(String email);

		Optional<User> findByEmailAndPassword(String email, String password);

}
