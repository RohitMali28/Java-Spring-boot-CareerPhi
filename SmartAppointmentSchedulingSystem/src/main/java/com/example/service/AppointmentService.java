package com.example.service;

import com.example.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsByProvider(Long providerId) {
        return appointmentRepository.findByProviderId(providerId);
    }
}