package com.hms.menu;
import com.hms.doctor.*;
import java.util.ArrayList;
import java.util.Scanner;
public class DoctorMenu {
    private static final Scanner sc = new Scanner(System.in);
    private static final DoctorDAO doctorDAO = new DoctorDAOImpl();
    public static void start(){
        while(true){
            System.out.println("========= DOCTOR MENU ===========");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Search Doctor");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. View Available Doctors By Specialization");
            System.out.println("7. Back to Main Menu");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addDoctor();
                    break;
                case 2:
                    viewAllDoctors();
                    break;
                case 3:
                    searchDoctor();
                    break;
                case 4:
                    updateDoctor();
                    break;
                case 5:
                    deleteDoctor();
                    break;
                case 6:
                    viewAvailableDoctors();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    private static void addDoctor(){
        sc.nextLine();
        System.out.println("Enter Doctor's Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Doctor's Specialization (" +
                "CARDIOLOGIST, NEUROLOGIST, ORTHOPEDIC, PEDIATRICIAN" +
                "DERMATOLOGIST, GENERAL_PHYSICIAN, ENT, PSYCHIATRIST) : ");
        String specialization = sc.nextLine();
        System.out.println("Enter Doctor's Phone Number : ");
        String phone = sc.nextLine();
        System.out.println("Enter Doctor's Experience : ");
        int experience = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Doctor's Availability(" +
                "AVAILABLE/UNAVAILABLE) : ");
        String availability = sc.nextLine();

        Doctor d = new Doctor(name, Doctor.Specialization.valueOf(specialization), phone,experience,
                Doctor.Availability.valueOf(availability));
        doctorDAO.addDoctor(d);
    }
    private static void viewAllDoctors(){
        ArrayList<Doctor> doctors = doctorDAO.getAllDoctors();
        if(doctors.isEmpty()){
            System.out.println("No doctors found");
        }
        else{
            for(Doctor d : doctors){
                System.out.print("Doctor ID : " +  d.getDoctorId());
                System.out.print(" | ");
                System.out.println("Doctor Name : " + d.getDoctorName());
            }
        }
    }
    private static void searchDoctor(){
        System.out.println("Enter Doctor's ID : ");
        int doctorId = sc.nextInt();
        sc.nextLine();
        Doctor d = doctorDAO.getDoctorById(doctorId);
        if(d == null){
            System.out.println("Invalid Doctor ID");
        }
        else{
            doctorDAO.printDetails(d);
        }
    }
    private static void updateDoctor(){
        System.out.println("Enter Doctor's ID : ");
        int doctorId = sc.nextInt();
        sc.nextLine();
        Doctor d = doctorDAO.getDoctorById(doctorId);
        if(d == null){
            System.out.println("Invalid Doctor ID");
        }
        else {
            doctorDAO.printDetails(d);
            doctorDAO.updateDoctor(d);
        }
    }
    private static void deleteDoctor(){
        System.out.println("Enter Doctor's ID : ");
        int doctorId = sc.nextInt();
        sc.nextLine();
        doctorDAO.deleteDoctor(doctorId);
    }
    private static void viewAvailableDoctors(){
        sc.nextLine();
        System.out.println("Enter Specialization : ");
        String specialization = sc.nextLine();
        ArrayList<Doctor> list = doctorDAO.getAvailableDoctorsBySpecialization(Doctor.Specialization.valueOf(specialization));
        if(list.isEmpty()){
            System.out.println("No Available doctors found");
        }
        else{
            System.out.println("Available Doctors : ");
            for(Doctor d : list){
                System.out.print("Doctor ID : " +  d.getDoctorId());
                System.out.print(" | ");
                System.out.println("Doctor Name : " + d.getDoctorName());
            }
        }

    }
}