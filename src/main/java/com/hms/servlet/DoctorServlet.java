package com.hms.servlet;

import com.hms.doctor.Doctor;
import com.hms.doctor.DoctorDAO;
import com.hms.doctor.DoctorDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/doctor")
public class DoctorServlet extends HttpServlet {
    private DoctorDAO doctorDAO;
    public void init(){
        doctorDAO = new DoctorDAOImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "viewAll":
                viewAllDoctors(request, response);
                break;
            case "search":
                searchDoctor(request, response);
                break;
            case "edit":
                editDoctor(request, response);
                break;
            default:
                response.getWriter().println("Invalid action");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "add":
                addDoctor(request,response);
                break;
            case "update":
                updateDoctor(request,response);
                break;
            case "delete":
                deleteDoctor(request,response);
                break;
            default:
                response.getWriter().println("Invalid action");
        }
    }






    protected void addDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String doctorName = request.getParameter("doctorName");
            Doctor.Specialization specialization = Doctor.Specialization.valueOf(request.getParameter("specialization"));
            String phone =  request.getParameter("phone");
            int experience = Integer.parseInt(request.getParameter("experience"));
            Doctor.Availability availability = Doctor.Availability.valueOf(request.getParameter("availability"));
            Doctor d = new Doctor(doctorName,specialization,phone,experience,availability);
            doctorDAO.addDoctor(d);

            response.sendRedirect(request.getContextPath() + "/doctor?action=viewAll");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    protected  void viewAllDoctors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ArrayList<Doctor> doctors = doctorDAO.getAllDoctors();
            request.setAttribute("doctors", doctors);
            request.getRequestDispatcher("/doctor/view-doctors.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    protected  void searchDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Doctor doctor = doctorDAO.getDoctorById(id);
            request.setAttribute("doctor", doctor);
            request.getRequestDispatcher("/doctor/doctor-details.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    protected void editDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Doctor d = doctorDAO.getDoctorById(id);
            request.setAttribute("doctor", d);
            request.getRequestDispatcher("/doctor/edit-doctor.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    protected void updateDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int doctorId = Integer.parseInt(request.getParameter("doctorId"));
            String doctorName = request.getParameter("doctorName");
            String phone = request.getParameter("phone");
            int experience = Integer.parseInt(request.getParameter("experience"));
            Doctor.Availability availability = Doctor.Availability.valueOf(request.getParameter("availability"));
            Doctor.Specialization specialization = Doctor.Specialization.valueOf(request.getParameter("specialization"));

            Doctor d = new Doctor(doctorName, specialization,phone,experience,availability);
            d.setDoctorId(doctorId);
            doctorDAO.updateDoctorDetails(d);
            response.sendRedirect(request.getContextPath() + "/doctor?action=viewAll");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    protected void deleteDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int doctorId = Integer.parseInt(request.getParameter("doctorId"));
            doctorDAO.deleteDoctor(doctorId);
            response.sendRedirect(request.getContextPath() + "/doctor?action=viewAll");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
