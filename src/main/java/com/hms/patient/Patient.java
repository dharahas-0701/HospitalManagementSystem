package com.hms.patient;

public class Patient {

    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    public enum BloodType {
        A_POSITIVE,
        A_NEGATIVE,
        B_POSITIVE,
        B_NEGATIVE,
        AB_POSITIVE,
        AB_NEGATIVE,
        O_POSITIVE,
        O_NEGATIVE
    }

    private int patientId;
    private String name;
    private int age;
    private Gender gender;
    private BloodType bloodGroup;
    private String disease;
    private String phone;

    public Patient() {

    }
    public Patient(String name, int age, Gender gender, BloodType bloodGroup
        ,String disease, String phone){
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.bloodGroup = bloodGroup;
            this.disease = disease;
            this.phone = phone;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BloodType getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodType bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}