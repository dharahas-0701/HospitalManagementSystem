package com.hms.billing;

public class Bill {
    public enum PaymentStatus{
        PENDING,
        PAID
    }
    private int billId;
    private int patientId;
    private int appointmentId;

    private double consultationFee;
    private double medicineCharges;
    private double testCharges;
    private double roomCharges;
    private double totalAmount;

    private PaymentStatus paymentStatus;

    public Bill(){

    }

    public Bill(int patientId, int appointmentId, double consultationFee, double medicineCharges,
                double testCharges, double roomCharges, PaymentStatus paymentStatus){
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.consultationFee = consultationFee;
        this.medicineCharges = medicineCharges;
        this.testCharges = testCharges;
        this.roomCharges = roomCharges;
        this.paymentStatus = paymentStatus;
    }
    public int getBillId() {
        return billId;
    }
    public void setBillId(int billId) {
        this.billId = billId;
    }
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public int getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    public double getConsultationFee() {
        return consultationFee;
    }
    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }
    public double getMedicineCharges() {
        return medicineCharges;
    }
    public void setMedicineCharges(double medicineCharges) {
        this.medicineCharges = medicineCharges;
    }
    public double getTestCharges() {
        return testCharges;
    }
    public void setTestCharges(double testCharges) {
        this.testCharges = testCharges;
    }
    public double getRoomCharges() {
        return roomCharges;
    }
    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}