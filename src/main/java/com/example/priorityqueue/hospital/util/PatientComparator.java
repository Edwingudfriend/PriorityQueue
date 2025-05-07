package com.example.priorityqueue.hospital.util;

import com.example.priorityqueue.hospital.model.Patient;
import com.example.priorityqueue.hospital.model.TriagePriority;
import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        return p1.getPriority().compareTo(p2.getPriority());
    }
}