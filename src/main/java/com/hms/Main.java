package com.hms;

import com.hms.menu.AppointmentMenu;
import com.hms.menu.DoctorMenu;
import com.hms.menu.PatientMenu;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("============== ABCD HOSPITAL ===============");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    PatientMenu.start();
                    break;
                case 2:
                    DoctorMenu.start();
                    break;
                case 3:
                    AppointmentMenu.start();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}