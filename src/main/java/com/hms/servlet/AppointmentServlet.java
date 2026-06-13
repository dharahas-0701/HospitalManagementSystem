package com.hms.servlet;

import com.hms.appointment.Appointment;
import com.hms.appointment.AppointmentDAO;
import com.hms.appointment.AppointmentDAOImpl;
import com.hms.doctor.Doctor;
import com.hms.doctor.DoctorDAO;
import com.hms.doctor.DoctorDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

@WebServlet("/appointment")
public class AppointmentServlet extends HttpServlet {
    private AppointmentDAO appointmentDAO;
    private DoctorDAO doctorDAO;

    public void init() throws ServletException {
        appointmentDAO = new AppointmentDAOImpl();
        doctorDAO = new DoctorDAOImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "book":
                bookAppointment(request, response);
                break;
            default:
                response.getWriter().println("Invalid Action");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            request.getRequestDispatcher("/appointment/book-appointment.jsp").forward(request, response);
            return;
        }
        switch (action) {
            case "loadDoctors":
                loadDoctors(request, response);
                break;
            case "viewAll":
                viewAllAppointments(request, response);
                break;
            case "search":
                searchAppointment(request, response);
                break;
            default:
                response.getWriter().println("Invalid Action");
        }
    }


    protected void bookAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int patientId = Integer.parseInt(request.getParameter("patientId"));
            int doctorId = Integer.parseInt(request.getParameter("doctorId"));
            Date appointmentDate = Date.valueOf(request.getParameter("appointmentDate"));
            Time appointmentTime = Time.valueOf(request.getParameter("appointmentTime") + ":00");
            Appointment appointment = new Appointment(patientId, doctorId, appointmentDate, appointmentTime, Appointment.Status.BOOKED);
            appointmentDAO.bookAppointment(appointment);
            response.sendRedirect(request.getContextPath() + "/appointment?action=viewAll");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void loadDoctors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Doctor.Specialization specialization = Doctor.Specialization.valueOf(request.getParameter("specialization"));
            ArrayList<Doctor> doctors = doctorDAO.getAvailableDoctorsBySpecialization( specialization );
            request.setAttribute("doctors", doctors);
            request.setAttribute("patientId", request.getParameter("patientId"));
            request.getRequestDispatcher("/appointment/book-appointment.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void viewAllAppointments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ArrayList<Appointment> appointments = appointmentDAO.getAppointments();
            request.setAttribute("appointments", appointments);
            request.getRequestDispatcher("/appointment/view-appointments.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void searchAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id =  Integer.parseInt(request.getParameter("id"));
            Appointment appointment = appointmentDAO.getAppointmentById(id);
            request.setAttribute("appointment", appointment);
            request.getRequestDispatcher("/appointment/appointment-details.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
