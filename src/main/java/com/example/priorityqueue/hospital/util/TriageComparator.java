package com.example.priorityqueue.hospital.util;

import com.example.priorityqueue.hospital.model.Patient;
import com.example.priorityqueue.hospital.model.TriagePriority;
import java.util.Comparator;

public class TriageComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        int priorityComparison = p2.getPriority().compareTo(p1.getPriority());
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        return p1.getArrivalTime().compareTo(p2.getArrivalTime());
    }
}