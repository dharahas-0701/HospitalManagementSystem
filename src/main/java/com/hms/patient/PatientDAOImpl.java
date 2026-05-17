package com.hms.patient;
import com.hms.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientDAOImpl implements PatientDAO {
    Connection conn = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);

    @Override
    public void addPatient(Patient p) {
        try {
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
            if (rs.next()) {
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
    public ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> list = new ArrayList<>();
        try {
            String query = "select * from patients";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Patient p = new Patient();

                p.setPatientId(
                        rs.getInt("patient_id")
                );

                p.setName(
                        rs.getString("name")
                );

                p.setAge(
                        rs.getInt("age")
                );

                p.setGender(
                        Patient.Gender.valueOf(
                                rs.getString("gender")
                        )
                );

                p.setBloodGroup(
                        Patient.BloodType.valueOf(
                                rs.getString("blood_group")
                        )
                );

                p.setDisease(
                        rs.getString("disease")
                );

                p.setPhone(
                        rs.getString("phone")
                );

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Patient getPatientById(int id) {
        Patient p = null;
        try {
            String Query = "Select * from patients where patient_id = ?";
            PreparedStatement ps = conn.prepareStatement(Query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setGender(Patient.Gender.valueOf(rs.getString("gender")));
                p.setBloodGroup(Patient.BloodType.valueOf(rs.getString("blood_group")));
                p.setDisease(rs.getString("disease"));
                p.setPhone(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void updatePatient(Patient p) {
        System.out.println("Select the Field you want to update");
        System.out.println("1. name");
        System.out.println("2. age");
        System.out.println("3 gender");
        System.out.println("4 blood group");
        System.out.println("5 Disease");
        System.out.println("6 phone");

        int choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the new value to be updated : ");
        String update = sc.nextLine();
        updatePatientField(p.getPatientId(), choice, update);
    }

    @Override
    public void updatePatientField(
            int patientId,
            int choice,
            String newValue
    ) {

        try {

            String column = "";

            switch (choice) {

                case 1:
                    column = "name";
                    break;

                case 2:
                    column = "age";
                    break;

                case 3:
                    column = "gender";
                    break;

                case 4:
                    column = "blood_group";
                    break;
                case 5:
                    column = "disease";
                    break;
                case 6:
                    column = "phone";
                    break;

                default:
                    System.out.println("Invalid Choice");
                    return;
            }

            String query =
                    "UPDATE patients SET " +
                            column +
                            " = ? WHERE patient_id = ?";

            PreparedStatement ps =
                    conn.prepareStatement(query);

            if (column.equals("age")) {

                ps.setInt(1, Integer.parseInt(newValue));

            } else {

                ps.setString(1, newValue);
            }

            ps.setInt(2, patientId);

            int rowsUpdated =
                    ps.executeUpdate();

            if (rowsUpdated > 0) {

                System.out.println(
                        "Patient updated successfully!"
                );

            } else {

                System.out.println(
                        "Patient not found!"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void printDetails(Patient p) {
        if (p == null) {
            System.out.println("Patient not found");
            return;
        }
        System.out.println("Patient ID is: " + p.getPatientId());
        System.out.println("Name is: " + p.getName());
        System.out.println("Age is: " + p.getAge());
        System.out.println("Gender is: " + p.getGender().name());
        System.out.println("Blood group is: " + p.getBloodGroup().name());
        System.out.println("Disease is:" + p.getDisease());
        System.out.println("phone is: " + p.getPhone());
    }

    @Override
    public void deletePatient(int patientId) {

        try {

            String query =
                    "DELETE FROM patients " +
                            "WHERE patient_id = ?";

            PreparedStatement ps =
                    conn.prepareStatement(query);

            ps.setInt(1, patientId);

            int rowsDeleted =
                    ps.executeUpdate();

            if (rowsDeleted > 0) {

                System.out.println(
                        "Patient deleted successfully!"
                );

            } else {

                System.out.println(
                        "Patient not found!"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
