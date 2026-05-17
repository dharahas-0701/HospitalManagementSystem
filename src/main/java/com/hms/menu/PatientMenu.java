package com.hms.menu;

import com.hms.patient.Patient;
import com.hms.patient.PatientDAO;
import com.hms.patient.PatientDAOImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class PatientMenu {

    private static final Scanner sc = new Scanner(System.in);
    private static final PatientDAO patientDAO = new PatientDAOImpl();

    public static void start() {

        while (true) {
            System.out.println("=========== PATIENT MENU ===========");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back to Main Menu");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewAllPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    updatePatient();
                    break;

                case 5:
                    deletePatient();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addPatient() {
        sc.nextLine();

        System.out.print("Enter Patient Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Gender (MALE/FEMALE/OTHER) : ");
        String gender = sc.nextLine();

        System.out.print("Enter Patient Blood Group (A_POSITIVE, O_NEGATIVE etc..) : ");
        String bloodGroup = sc.nextLine();

        System.out.print("Enter Patient Disease : ");
        String disease = sc.nextLine();

        System.out.print("Enter Patient Phone Number : ");
        String phone = sc.nextLine();

        Patient patient = new Patient(
                name,
                age,
                Patient.Gender.valueOf(gender.toUpperCase()),
                Patient.BloodType.valueOf(bloodGroup.toUpperCase()),
                disease,
                phone
        );

        patientDAO.addPatient(patient);
    }

    private static void viewAllPatients() {
        ArrayList<Patient> list = patientDAO.getAllPatients();

        for (Patient p : list) {
            System.out.println("Patient ID is: " + p.getPatientId());
            System.out.println("Name is: " + p.getName());
            System.out.println("-----------------------------");
        }
    }

    private static void searchPatient() {
        System.out.print("Enter Patient ID : ");
        int patientId = sc.nextInt();

        Patient patient = patientDAO.getPatientById(patientId);

        if (patient != null) {
            patientDAO.printDetails(patient);
        } else {
            System.out.println("Invalid Patient ID");
        }
    }

    private static void updatePatient() {
        System.out.print("Enter Patient ID : ");
        int patientId = sc.nextInt();

        Patient patient = patientDAO.getPatientById(patientId);

        if (patient != null) {
            patientDAO.printDetails(patient);
            patientDAO.updatePatient(patient);
        } else {
            System.out.println("Invalid Patient ID");
        }
    }

    private static void deletePatient() {
        System.out.print("Enter Patient ID : ");
        int patientId = sc.nextInt();

        patientDAO.deletePatient(patientId);
    }
}