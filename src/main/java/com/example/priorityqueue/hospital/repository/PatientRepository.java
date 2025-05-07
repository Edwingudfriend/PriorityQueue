package com.example.priorityqueue.hospital.repository;

import com.example.priorityqueue.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Basic CRUD operations are inherited from JpaRepository
}