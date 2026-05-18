package com.hms.appointment;

import java.util.ArrayList;
public interface AppointmentDAO {
    void bookAppointment(Appointment a);

    ArrayList<Appointment> getAppointments();

    Appointment getAppointmentById(int id);

    void updateAppointment(Appointment a);

    void cancelAppointment(Appointment a);

    void printDetails(Appointment a);

}
