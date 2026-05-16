package com.hms;

public class Doctor {
    public enum Specialization {
        CARDIOLOGIST,
        NEUROLOGIST,
        ORTHOPEDIC,
        PEDIATRICIAN,
        DERMATOLOGIST,
        GENERAL_PHYSICIAN,
        ENT,
        PSYCHIATRIST
    }
    public enum Availability {
        AVAILABLE,
        UNAVAILABLE
    }
    private int doctorId;
    private String doctorName;
    private Specialization specialization;
    private String phone;
    private int experience;
    private Availability availability;
}
