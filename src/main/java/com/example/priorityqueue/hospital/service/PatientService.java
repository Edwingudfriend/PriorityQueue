package com.example.priorityqueue.hospital.service;

import com.example.priorityqueue.hospital.model.Patient;

public interface PatientService {
    boolean validatePatient(Patient patient);
    Patient findById(Long id);
    Patient save(Patient patient);
}