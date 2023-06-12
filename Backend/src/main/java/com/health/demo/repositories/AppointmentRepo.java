package com.health.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.demo.entities.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

}
