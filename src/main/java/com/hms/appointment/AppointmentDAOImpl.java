package com.hms.appointment;

import java.sql.*;
import java.util.ArrayList;

import com.hms.DBConnection;
public class AppointmentDAOImpl implements  AppointmentDAO {
    Connection conn = DBConnection.getConnection();
    @Override
    public void bookAppointment(Appointment a) {
        try{
            String query = "insert into appointments " +
                    "(patient_id, doctor_id, appointment_date, appointment_time, status)" +
                    "values (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setDate(3, a.getAppointmentDate());
            ps.setTime(4, a.getAppointmentTime());
            ps.setString(5, a.getStatus().toString());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int key = rs.getInt(1);
                a.setAppointmentId(key);
                System.out.println("Appointment Booked Successfully");
                System.out.println("Appointment ID: " + a.getAppointmentId());
            }
            else{
                System.out.println("Appointment Booked Failed");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<Appointment> getAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        try{
            String query = "select * from appointments";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Appointment a = new Appointment();
                a.setAppointmentId(rs.getInt(1));
                a.setPatientId(rs.getInt(2));
                a.setDoctorId(rs.getInt(3));
                a.setAppointmentDate(rs.getDate(4));
                a.setAppointmentTime(rs.getTime(5));
                a.setStatus(Appointment.Status.valueOf(rs.getString(6)));
                appointments.add(a);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return appointments;
    }
    @Override
    public Appointment getAppointmentById(int id) {
        Appointment a = null;
        try{
            String query = "select * from appointments where appointment_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                a = new Appointment();
                a.setAppointmentId(rs.getInt(1));
                a.setPatientId(rs.getInt(2));
                a.setDoctorId(rs.getInt(3));
                a.setAppointmentDate(rs.getDate(4));
                a.setAppointmentTime(rs.getTime(5));
                a.setStatus(Appointment.Status.valueOf(rs.getString(6)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }
    @Override
    public void updateAppointmentStatus(int appointmentId,  Appointment.Status s) {
        try{
            String query = "update appointments set status = ? where appointment_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, s.toString());
            ps.setInt(2, appointmentId);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Appointment Updated Successfully");
            }
            else{
                System.out.println("Appointment Updated Failed");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void cancelAppointment(int appointmentId) {
        updateAppointmentStatus(appointmentId, Appointment.Status.CANCELLED);
    }
    @Override
    public void printDetails(Appointment a) {
        if(a == null){
            System.out.println("Appointment Not Found");
        }
        else{
            System.out.println("Appointment ID: " + a.getAppointmentId());
            System.out.println("Patient ID: " + a.getPatientId());
            System.out.println("Doctor ID: " + a.getDoctorId());
            System.out.println("Appointment Date: " + a.getAppointmentDate());
            System.out.println("Appointment Time: " + a.getAppointmentTime());
            System.out.println("Status: " + a.getStatus().toString());
        }

    }
}
