package com.hms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

public class PatientDAOImpl implements PatientDAO {
    Connection conn = DBConnection.getConnection();
    @Override
    public void addPatient(Patient p){
        try{
            String query = "Insert INTO patients" +
                    "(name, age, gender,blood_group, disease, phone)" +
                    "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getGender().name());
            ps.setString(4, p.getBloodGroup().name());
            ps.setString(5, p.getDisease());
            ps.setString(6, p.getPhone());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                p.setPatientId(id);
                System.out.println("Patient added successfully");
                System.out.println("The ID of the patient is : " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<Patient> getAllPatients(){
        ArrayList<Patient> list = new ArrayList<>();
        try{
            String query = "select * from patient";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(getPatientById(rs.getInt("patient_id")));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Patient getPatientById(int id){
        Patient p = new Patient();
        try {
            String Query = "Select * from patients where id = ?";
            PreparedStatement ps = conn.prepareStatement(Query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setGender(Patient.Gender.valueOf(rs.getString("gender")));
                p.setBloodGroup(Patient.BloodType.valueOf(rs.getString("blood_group")));
                p.setDisease(rs.getString("disease"));
                p.setPhone(rs.getString("phone"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    @Override
    public void updatePatient(Patient p){

    }
    @Override
    public void deletePatient(int id){

    }

}
