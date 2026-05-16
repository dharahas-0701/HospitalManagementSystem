package com.hms;

import java.util.ArrayList;

public interface DoctorDAO {

    void addDoctor(Doctor d);

    ArrayList<Doctor> getAllDoctors();

    Doctor getDoctorById(int doctorId);

    void updateDoctor(Doctor d);

    void deleteDoctor(int doctorId);

    void printDetails(Doctor d);
}