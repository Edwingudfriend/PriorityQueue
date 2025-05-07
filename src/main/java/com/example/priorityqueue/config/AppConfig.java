package com.example.priorityqueue.config;

import com.example.priorityqueue.hospital.model.Patient;
import com.example.priorityqueue.hospital.util.PatientComparator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.PriorityQueue;

@Configuration
public class AppConfig {
    @Bean
    public PriorityQueue<Patient> patientPriorityQueue() {
        return new PriorityQueue<>(new PatientComparator());
    }
}