package com.hms.doctor;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;
    @Column(name = "name",  nullable = false)
    private String doctorName;
    @Enumerated(EnumType.STRING)
    @Column(name = "specialization")
    private Specialization specialization;
    @Column(name = "phone", unique = true)
    private String phone;
    @Column(name = "experience")
    private int experience;
    @Enumerated(EnumType.STRING)
    @Column(name = "availability")
    private Availability availability;

    public Doctor() {

    }
    public Doctor(int doctorId) {
        this.doctorId = doctorId;
    }
    public Doctor( String doctorName,  Specialization specialization, String phone, int experience
            , Availability availability) {
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.phone = phone;
        this.experience = experience;
        this.availability = availability;
    }

    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public Specialization getSpecialization() {
        return specialization;
    }
    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public Availability getAvailability() {
        return availability;
    }
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
