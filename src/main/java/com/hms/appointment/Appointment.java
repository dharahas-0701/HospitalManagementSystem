package com.hms.appointment;

import java.sql.Date;
import java.sql.Time;
public class Appointment {
    public enum Status {
        BOOKED,
        COMPLETED,
        CANCELLED,
    }
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private Date appointmentDate;
    private Time appointmentTime;
    private Status status;
    public Appointment() {}
    public Appointment(int patientId, int doctorId, Date appointmentDate,
                       Time appointmentTime, Status status){
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }
    public int getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public Time getAppointmentTime() {
        return appointmentTime;
    }
    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

}
