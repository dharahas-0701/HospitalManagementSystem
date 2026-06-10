package com.hms.servlet;

import com.hms.patient.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/patient")
public class PatientServlet extends HttpServlet {
    private PatientDAO patientDAO;
    public void init(){
        patientDAO = new PatientDAOImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<h2> Patient has been successfully added.</h2>");
            out.println("<h3> Patient ID : " + p.getPatientId() + "</h3>");
        }
        catch (Exception e){
            e.printStackTrace();
            response.getWriter().println("<h2> Error Adding Patient </h2>");
        }
    }
}
