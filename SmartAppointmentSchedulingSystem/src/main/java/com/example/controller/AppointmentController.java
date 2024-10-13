package com.example.controller;

import com.example.model.Appointment;
import com.example.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/provider/{providerId}")
    public List<Appointment> getAppointments(@PathVariable Long providerId) {
        return appointmentService.getAppointmentsByProvider(providerId);
    }
}