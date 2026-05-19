package com.hms.appointment;

import java.util.ArrayList;
public interface AppointmentDAO {
    void bookAppointment(Appointment a);

    ArrayList<Appointment> getAppointments();

    Appointment getAppointmentById(int id);

    void updateAppointmentStatus(int appointmentId, Appointment.Status s);

    void cancelAppointment(int appointmentId);

    void printDetails(Appointment a);

}
