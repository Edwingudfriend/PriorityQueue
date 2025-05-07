package com.example.priorityqueue.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int age;
    private String symptoms;
    
    @Enumerated(EnumType.STRING)
    private TriagePriority priority;
    
    private LocalDateTime arrivalTime;

    // Constructors
    public Patient() {
    }

    public Patient(String name, int age, String symptoms, TriagePriority priority, LocalDateTime arrivalTime) {
        this.name = name;
        this.age = age;
        this.symptoms = symptoms;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public TriagePriority getPriority() {
        return priority;
    }

    public void setPriority(TriagePriority priority) {
        this.priority = priority;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}