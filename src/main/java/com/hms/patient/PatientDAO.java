package com.hms.patient;

import java.sql.Connection;
import java.util.ArrayList;

public interface PatientDAO {
    void addPatient(Patient p);

    ArrayList<Patient> getAllPatients();

    Patient getPatientById(int id);

    void updatePatient(Patient p);

    void deletePatient(int id);

    void printDetails(Patient p);

    void updatePatientField(int patientId, int choice, String newValue);

    void updatePatientDetails(Patient p);

}
