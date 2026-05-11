package com.hms;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientDAO patientDAO = new PatientDAOImpl();
        while (true) {
            System.out.println("============== ABCD HOSPITAL ===============");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient ");
            System.out.println("4. Update Patient ");
            System.out.println("5. Delete Patient ");
            System.out.println("6. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Patient Name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter Patient Age : ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Patient Gender (MALE/FEMALE/OTHER) : ");
                    String gender = sc.nextLine();
                    System.out.println("Enter Patient Blood Group (A_POSITIVE, O_NEGATTIVE etc..) : ");
                    String bloodGroup = sc.nextLine();
                    System.out.println("Enter Patient Disease : ");
                    String disease = sc.nextLine();
                    System.out.println("Enter Patient Phone Number : ");
                    String phone = sc.nextLine();
                    Patient patient = new Patient(name,
                            age,
                            Patient.Gender.valueOf(gender.toUpperCase()),
                            Patient.BloodType.valueOf(bloodGroup.toUpperCase()),
                            disease,
                            phone
                    );
                    patientDAO.addPatient(patient);
                    break;
                case 2:
                    ArrayList<Patient> list = patientDAO.getAllPatients();
                    for (Patient p : list) {
                        System.out.println("Patient ID is: " + p.getPatientId());
                        System.out.println("Name is: " + p.getName());
                    }
                    break;
                case 3:
                    System.out.println("Enter Patient ID : ");
                    int patientId = sc.nextInt();
                    Patient patient1 = patientDAO.getPatientById(patientId);
                    if (patient1 != null) {
                        patientDAO.printDetails(patient1);
                    }
                    else{
                        System.out.println("Invalid Patient ID");
                    }
                    break;
                case 4:
                    System.out.println("Enter Patient ID : ");
                    int userId = sc.nextInt();
                    Patient patient2 = patientDAO.getPatientById(userId);
                    if (patient2 != null) {
                        patientDAO.printDetails(patient2);
                        patientDAO.updatePatient(patient2);
                    } else {
                        System.out.println("Invalid Patient ID");
                    }
                    break;
                case 5:
                    System.out.println("Enter Patient ID : ");
                    int Id = sc.nextInt();
                    patientDAO.deletePatient(Id);
                    break;
                case 6:
                    System.out.println("Closing the Program");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}