package com.hms.billing;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.hms.DBConnection;

public class BillingDAOImpl implements BillingDAO {
    Connection conn = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);

    @Override
    public void generateBill(Bill b){
        try{
            String query = "insert into billing" +
                    "(patient_id, appointment_id, consultation_fee, medicine_charges, test_charges, room_charges, payment_status)" +
                    "values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, b.getPatientId());
            ps.setInt(2, b.getAppointmentId());
            ps.setDouble(3, b.getConsultationFee());
            ps.setDouble(4, b.getMedicineCharges());
            ps.setDouble(5, b.getTestCharges());
            ps.setDouble(6, b.getRoomCharges());
            ps.setString(7, b.getPaymentStatus().toString());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                b.setBillId(id);
                PreparedStatement ps1 = conn.prepareStatement("select * from billing where bill_id = ?");
                ps1.setInt(1, id);
                ResultSet rs1 = ps1.executeQuery();
                if(rs1.next()){
                    b.setTotalAmount(rs1.getDouble("total_amount"));
                }
                System.out.println("Bill Generated Successfully");
                System.out.println("Bill ID : " + b.getBillId());
                System.out.println("Total Amount : " + b.getTotalAmount());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public ArrayList<Bill> getAllBills() {
        ArrayList<Bill> bills = new ArrayList<>();
        try{
            String query = "select * from billing";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Bill b = new Bill();
                b.setBillId(rs.getInt("bill_id"));
                b.setPatientId(rs.getInt("patient_id"));
                b.setAppointmentId(rs.getInt("appointment_id"));
                b.setConsultationFee(rs.getDouble("consultation_fee"));
                b.setMedicineCharges(rs.getDouble("medicine_charges"));
                b.setTestCharges(rs.getDouble("test_charges"));
                b.setRoomCharges(rs.getDouble("room_charges"));
                b.setTotalAmount(rs.getDouble("total_amount"));
                b.setPaymentStatus(Bill.PaymentStatus.valueOf(rs.getString("payment_status")));
                bills.add(b);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return bills;
    }
    @Override
    public Bill getBillById(int id) {
        Bill b = null;
        try{
            String query = "select * from billing where bill_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                b = new Bill();
                b.setBillId(rs.getInt("bill_id"));
                b.setPatientId(rs.getInt("patient_id"));
                b.setAppointmentId(rs.getInt("appointment_id"));
                b.setConsultationFee(rs.getDouble("consultation_fee"));
                b.setMedicineCharges(rs.getDouble("medicine_charges"));
                b.setTestCharges(rs.getDouble("test_charges"));
                b.setRoomCharges(rs.getDouble("room_charges"));
                b.setTotalAmount(rs.getDouble("total_amount"));
                b.setPaymentStatus(Bill.PaymentStatus.valueOf(rs.getString("payment_status")));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }
    @Override
    public void markBillAsPaid(int id) {
        try{
            String query = "update billing set payment_status = 'PAID' where bill_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Bill Paid Successfully");
            }
            else{
                System.out.println("Bill Not Found");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void printDetails(Bill b) {
        if(b == null){
            System.out.println("Bill Not Found");
            return;
        }
        System.out.println("Bill ID : " + b.getBillId());
        System.out.println("Patient ID : " + b.getPatientId());
        System.out.println("Appointment ID : " + b.getAppointmentId());
        System.out.println("Consultation Fee : " + b.getConsultationFee());
        System.out.println("Medicine Charges : " + b.getMedicineCharges());
        System.out.println("Test Charges : " + b.getTestCharges());
        System.out.println("Room Charges : " + b.getRoomCharges());
        System.out.println("Total Amount : " + b.getTotalAmount());
        System.out.println("Payment Status : " + b.getPaymentStatus());
    }
}

