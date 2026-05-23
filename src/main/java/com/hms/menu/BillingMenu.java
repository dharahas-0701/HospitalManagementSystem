package com.hms.menu;

import com.hms.patient.*;
import com.hms.billing.*;
import com.hms.appointment.*;

import java.util.Scanner;
import java.util.ArrayList;

public class BillingMenu {
    private static final Scanner sc = new Scanner(System.in);

    private static final PatientDAO patientDAO = new PatientDAOImpl();
    private static final BillingDAO billingDAO = new BillingDAOImpl();
    private static final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    public static void start(){
        while(true){
            System.out.println("============ Billing Menu ============");
            System.out.println("1. Generate Bill");
            System.out.println("2. View All Bills");
            System.out.println("3. Search Bill");
            System.out.println("4. Mark Bill Paid");
            System.out.println("5. Back to Main Menu");

            int choice =sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    generateBill();
                    break;
                case 2:
                    viewAllBills();
                    break;
                case 3:
                    searchBill();
                    break;
                case 4:
                    markBillPaid();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void generateBill(){
        System.out.println("Enter Patient ID : ");
        int patientID = sc.nextInt();
        Patient p = patientDAO.getPatientById(patientID);
        if(p == null){
            System.out.println("Patient Not Found");
            return;
        }
        System.out.println("Enter Appointment ID : ");
        int appointmentID = sc.nextInt();
        Appointment a = appointmentDAO.getAppointmentById(appointmentID);
        if(a == null){
            System.out.println("Appointment Not Found");
            return;
        }
        if(a.getPatientId() != patientID){
            System.out.println("Patient ID does not match");
            return;
        }
        System.out.println("Enter Consultation Fee : ");
        double consultationFee = sc.nextDouble();

        System.out.println("Enter Medicine Fee : ");
        double medicineFee = sc.nextDouble();

        System.out.println("Enter Test Fee : ");
        double testFee = sc.nextDouble();

        System.out.println("Enter Room Fee : ");
        double roomFee = sc.nextDouble();


        Bill b = new Bill(patientID, appointmentID, consultationFee, medicineFee, testFee, roomFee,
                Bill.PaymentStatus.PENDING);

        billingDAO.generateBill(b);
    }

    private static void viewAllBills(){
        ArrayList<Bill> bills = billingDAO.getAllBills();
        if(bills.isEmpty()){
            System.out.println("No Bills Found");
            return;
        }
        for(Bill b : bills){
            billingDAO.printDetails(b);
            System.out.println("---------------------------------");
        }
    }
    private static void searchBill(){
        System.out.print("Enter Bill ID : ");
        int billID = sc.nextInt();
        sc.nextLine();
        Bill b = billingDAO.getBillById(billID);
        billingDAO.printDetails(b);
    }
    private static void markBillPaid(){
        System.out.print("Enter Bill ID : ");
        int billID = sc.nextInt();
        sc.nextLine();
        Bill b = billingDAO.getBillById(billID);
        if(b == null){
            System.out.println("Bill Not Found");
            return;
        }
        billingDAO.markBillAsPaid(billID);
    }
}
