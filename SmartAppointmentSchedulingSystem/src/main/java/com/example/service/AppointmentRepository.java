package com.example.service;

import java.util.List;

import com.example.model.Appointment;

public interface AppointmentRepository {

	List<Appointment> findByProviderId(Long providerId);

}
