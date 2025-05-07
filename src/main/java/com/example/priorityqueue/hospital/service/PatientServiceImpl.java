package com.example.priorityqueue.hospital.service;

import com.example.priorityqueue.hospital.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Implementation of PatientService.
 */
@Service
public class PatientServiceImpl implements PatientService {
    
    // In-memory storage for patients (replace with repository if using persistence)
    private final Map<Long, Patient> patientMap = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1); // For generating IDs

    @Override
    public boolean validatePatient(Patient patient) {
        // Basic validation
        if (patient == null) {
            return false;
        }
        
        if (patient.getName() == null || patient.getName().trim().isEmpty()) {
            return false;
        }
        
        if (patient.getAge() < 0 || patient.getAge() > 150) {
            return false;
        }

        boolean b = patient.getPriority() != null;
        return b;
    }

    @Override
    public Patient findById(Long id) {
        if (id == null) {
            return null;
        }
        return patientMap.get(id);
    }

    @Override
    public Patient save(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        
        // Generate ID if it's a new patient
        if (patient.getId() == null) {
            patient.setId(idGenerator.getAndIncrement());
        }
        
        patientMap.put(patient.getId(), patient);
        return patient;
    }
}