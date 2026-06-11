package com.hms.servlet;

import com.hms.patient.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/patient")
public class PatientServlet extends HttpServlet {
    private PatientDAO patientDAO;
    public void init(){
        patientDAO = new PatientDAOImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if(action==null){
            action = "viewAll";
        }
        switch(action){
            case "viewAll":
                viewAllPatients(request, response);
                break;
            case "search":
                searchPatient(request, response);
            default:
                response.getWriter().println("Invalid action");

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        switch (action){
            case "add":
                addPatient(request, response);
                break;
        }
    }

    protected void addPatient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            Patient.Gender gender = Patient.Gender.valueOf(request.getParameter("gender"));
            Patient.BloodType bloodType = Patient.BloodType.valueOf(request.getParameter("bloodGroup"));
            String disease = request.getParameter("disease");
            String phone = request.getParameter("phone");
            Patient p = new Patient(name, age, gender, bloodType, disease, phone);
            patientDAO.addPatient(p);
            response.sendRedirect(request.getContextPath() + "/patient?action=viewAll");
        }
        catch (Exception e){
            e.printStackTrace();
            response.getWriter().println("<h2> Error Adding Patient </h2>");
        }
    }
    protected void viewAllPatients(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ArrayList<Patient> patients = patientDAO.getAllPatients();
            request.setAttribute("patients", patients);
            request.getRequestDispatcher("/patient/view-patients.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void searchPatient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Patient p = patientDAO.getPatientById(id);
            request.setAttribute("patient", p);
            request.getRequestDispatcher("/patient/patient-details.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
