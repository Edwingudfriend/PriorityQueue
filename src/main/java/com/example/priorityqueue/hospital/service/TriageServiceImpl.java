package com.example.priorityqueue.hospital.service;

import com.example.priorityqueue.hospital.model.Patient;
import com.example.priorityqueue.hospital.model.TriagePriority;
import com.example.priorityqueue.hospital.repository.PatientRepository;
import com.example.priorityqueue.hospital.util.TriageComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PriorityQueue;

@Service
public class TriageServiceImpl implements TriageService {

    private final PriorityQueue<Patient> patientQueue;
    private final PatientRepository patientRepository;

    @Autowired
    public TriageServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        this.patientQueue = new PriorityQueue<>(new TriageComparator());
        // Initialize with existing patients from repository if needed
        patientQueue.addAll(patientRepository.findAll());
    }

    @Override
    public Patient addPatient(Patient patient) {
        patientQueue.add(patient);
        return patientRepository.save(patient);
    }

    @Override
    public Patient getNextPatient() {
        Patient nextPatient = patientQueue.poll();
        if (nextPatient != null) {
            patientRepository.delete(nextPatient);
        }
        return nextPatient;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientQueue.stream().toList();
    }
}