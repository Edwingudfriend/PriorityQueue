package com.example.priorityqueue.hospital.controller;

import com.example.priorityqueue.hospital.model.Patient;
import com.example.priorityqueue.hospital.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/triage")
public class TriageController {
    @Autowired
    private TriageService triageService;

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return triageService.addPatient(patient);
    }

    @GetMapping("/next")
    public Patient getNextPatient() {
        return triageService.getNextPatient();
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return triageService.getAllPatients();
    }
}