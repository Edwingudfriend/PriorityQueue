package com.example.priorityqueue.hospital.model;


import java.util.Comparator;

public class TriageComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        // First compare by priority (higher priority comes first)
        int priorityComparison = p2.getPriority().compareTo(p1.getPriority());
        
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        
        // If priorities are equal, compare by arrival time (earlier comes first)
        return p1.getArrivalTime().compareTo(p2.getArrivalTime());
    }
}