package com.example.priorityqueue.hospital.service;

import com.example.priorityqueue.hospital.model.Patient;
import java.util.List;

public interface TriageService {
    Patient addPatient(Patient patient);
    Patient getNextPatient();
    List<Patient> getAllPatients();
}