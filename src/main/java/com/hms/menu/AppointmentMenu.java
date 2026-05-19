package com.hms.menu;
import com.hms.appointment.*;
import com.hms.doctor.*;
import com.hms.patient.*;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;
public class AppointmentMenu {
    private static Scanner sc = new Scanner(System.in);
    private static AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private static DoctorDAO doctorDAO = new DoctorDAOImpl();
    private static PatientDAO patientDAO = new PatientDAOImpl();
    public static void start(){
        while(true){
            System.out.println("========== Appointment Menu ===========");
            System.out.println("1. Add Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Search Appointment");
            System.out.println("4. Mark Appointment Completed");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. Back to Main Menu");

            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    bookAppointment();
                    break;
                case 2:
                    viewAllAppointments();
                    break;
                case 3:
                    searchAppointment();
                    break;
                case 4:
                    markCompleted();
                    break;
                case 5:
                    cancelAppointment();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }

    private static void bookAppointment(){
        System.out.print("Enter Patient ID : ");
        int patientId = sc.nextInt();
        sc.nextLine();
        Patient patient = patientDAO.getPatientById(patientId);
        if(patient == null){
            System.out.println("Patient Not Found");
            return;
        }
        else{
            System.out.print("Enter Specialization : ");
            String specialization = sc.nextLine();
            ArrayList<Doctor> list = doctorDAO.getAvailableDoctorsBySpecialization(
                    Doctor.Specialization.valueOf( specialization.toUpperCase() )
            );
            if(list.isEmpty()){
                System.out.println("No Doctor Available");
                return;
            }
            else{
                for(Doctor d : list){
                    System.out.println("ID : " +d.getDoctorId()
                    + " | Name : " + d.getDoctorName());

                }
                System.out.print("Enter Doctor Id : ");
                int doctorId = sc.nextInt();
                sc.nextLine();
                boolean validDoctor = false;

                for(Doctor d : list){
                    if(d.getDoctorId() == doctorId){
                        validDoctor = true;
                        break;
                    }
                }

                if(!validDoctor){
                    System.out.println("Invalid Doctor Id");
                    return;
                }
                System.out.print("Enter Appointment Date (YYYY-MM-DD) : ");
                String date = sc.nextLine();
                System.out.print("Enter Appointment Time (HH:MM:SS) : ");
                String time = sc.nextLine();
                Date appointmentDate = Date.valueOf(date);
                Time appointmentTime = Time.valueOf(time);
                Appointment appointment = new Appointment(
                        patientId, doctorId, appointmentDate,appointmentTime,
                        Appointment.Status.BOOKED
                );

                appointmentDAO.bookAppointment(appointment);
            }
        }
    }

    private static void viewAllAppointments(){
        ArrayList<Appointment> appointments = appointmentDAO.getAppointments();
        if(appointments.isEmpty()){
            System.out.println("No Appointments Available");
            return;
        }
        else{
            for(Appointment a : appointments){
                appointmentDAO.printDetails(a);
                System.out.println("----------------------------");
            }


        }
    }

    private static void searchAppointment(){
        System.out.print("Enter Appointment Id : ");
        int appointmentId = sc.nextInt();
        sc.nextLine();
        Appointment appointment = appointmentDAO.getAppointmentById(appointmentId);
        appointmentDAO.printDetails(appointment);
    }
    private static void markCompleted(){
        System.out.print("Enter Appointment Id : ");
        int appointmentId = sc.nextInt();
        sc.nextLine();
        appointmentDAO.updateAppointmentStatus(appointmentId, Appointment.Status.COMPLETED);

    }
    private static void cancelAppointment(){
        System.out.print("Enter Appointment Id : ");
        int appointmentId = sc.nextInt();
        sc.nextLine();
        appointmentDAO.cancelAppointment(appointmentId);
    }


}
