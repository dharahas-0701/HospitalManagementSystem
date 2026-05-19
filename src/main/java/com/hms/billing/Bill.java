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
    private double
}