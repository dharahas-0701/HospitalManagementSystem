package com.hms.doctor;
import com.hms.DBConnection;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Scanner;
public class DoctorDAOImpl implements DoctorDAO  {
    Connection conn = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);
    @Override
    public void addDoctor(Doctor d) {
        try{
            String query = "INSERT INTO doctors" +
                    "(name, specialization, phone, experience, availability)"+
                    "VALUES(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, d.getDoctorName());
            ps.setString(2, d.getSpecialization().name());
            ps.setString(3, d.getPhone());
            ps.setInt(4, d.getExperience());
            ps.setString(5,d.getAvailability().name());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                d.setDoctorId(rs.getInt(1));
                System.out.println("Doctor added successfully");
                System.out.println("Doctor ID: "+d.getDoctorId());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void deleteDoctor(int doctorId) {
        try{
            String query = "DELETE FROM doctors WHERE doctor_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,doctorId);
            int rows = ps.executeUpdate();
            if(rows>0){
                System.out.println("Doctor deleted successfully");
            }
            else{
                System.out.println("Doctor not found");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void updateDoctor(Doctor d) {
        System.out.println("Select the Field you want to update : ");
        System.out.println("1 name : ");
        System.out.println("2 specialization : ");
        System.out.println("3 phone : ");
        System.out.println("4 experience : ");
        System.out.println("5 availability : ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the new value : ");
        String new_value = sc.nextLine();
        updateDoctorField(d.getDoctorId(), choice, new_value);
    }
    @Override
    public void updateDoctorField(int  doctorId, int choice, String new_value) {
        try{
            String column = "";
            switch (choice){
                case 1:
                    column = "name";
                    break;
                case 2:
                    column = "specialization";
                    break;
                case 3:
                    column = "phone";
                    break;
                case 4:
                    column = "experience";
                    break;
                case 5:
                    column = "availability";
                    break;

                default:
                    System.out.println("Invalid choice");
                    return;
            }
            String query = "UPDATE doctors SET "+
                    column + "= ?"+
                    " WHERE doctor_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            if(column.equals("experience")){
                ps.setInt(1, Integer.parseInt(new_value));
            }
            else{
                ps.setString(1, new_value);
            }
            ps.setInt(2, doctorId);
            int rows = ps.executeUpdate();
            if(rows>0){
                System.out.println("Doctor updated successfully");
            }
            else{
                System.out.println("Doctor not found");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public  ArrayList<Doctor> getAllDoctors(){
        ArrayList<Doctor> doctors = new ArrayList<>();
        try{
            String query = "SELECT * FROM doctors";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt(1));
                d.setDoctorName(rs.getString(2));
                d.setSpecialization(Doctor.Specialization.valueOf(rs.getString(3)));
                d.setPhone(rs.getString(4));
                d.setExperience(rs.getInt(5));
                d.setAvailability(Doctor.Availability.valueOf(rs.getString(6)));
                doctors.add(d);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return doctors;
    }
    @Override
    public Doctor getDoctorById(int doctorId) {
        Doctor d = null;
        try{
            String query = "SELECT * FROM doctors WHERE doctor_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,doctorId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                d = new Doctor();
                d.setDoctorId(rs.getInt(1));
                d.setDoctorName(rs.getString(2));
                d.setSpecialization(Doctor.Specialization.valueOf(rs.getString(3)));
                d.setPhone(rs.getString(4));
                d.setExperience(rs.getInt(5));
                d.setAvailability(Doctor.Availability.valueOf(rs.getString(6)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return d;
    }
    @Override
    public void printDetails(Doctor d) {
        if(d == null){
            System.out.println("Doctor not found");
        }
        else{
            System.out.println("Doctor id : "+d.getDoctorId());
            System.out.println("Doctor name : "+d.getDoctorName());
            System.out.println("Specialization : "+d.getSpecialization().name());
            System.out.println("Phone : "+d.getPhone());
            System.out.println("Experience : "+d.getExperience());
            System.out.println("Availability : "+d.getAvailability().name());
        }
    }
    @Override
    public ArrayList<Doctor> getAvailableDoctorsBySpecialization(Doctor.Specialization specialization) {
        ArrayList<Doctor> list = new ArrayList<>();
        try{
            String query = "Select * from doctors"+
                    " where specialization = ?"+
                    " and availability = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, specialization.name());
            ps.setString(2, "AVAILABLE");
            ResultSet rs = ps.executeQuery();;
            while(rs.next()){
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt(1));
                d.setDoctorName(rs.getString(2));
                d.setSpecialization(Doctor.Specialization.valueOf(rs.getString(3)));
                d.setPhone(rs.getString(4));
                d.setExperience(rs.getInt(5));
                d.setAvailability(Doctor.Availability.valueOf(rs.getString(6)));
                list.add(d);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
