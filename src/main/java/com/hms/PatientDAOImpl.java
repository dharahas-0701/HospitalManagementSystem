package com.hms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

public class PatientDAOImpl implements PatientDAO {
    Connection conn = DBConnection.getConnection();
    @Override
    public void addPatient(Patient p){

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
