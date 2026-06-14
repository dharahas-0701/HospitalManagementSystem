package com.hms.servlet;

import com.hms.billing.Bill;
import com.hms.billing.BillingDAO;
import com.hms.billing.BillingDAOImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/billing")
public class BillingServlet extends HttpServlet {
    private BillingDAO billingDAO;

    public void init(){
        billingDAO = new BillingDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch(action){
            case "viewAll":
                viewAllBills(request, response);
                break;
            case "search":
                searchBill(request, response);
                break;
            default:
                response.getWriter().println("Invalid action");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (action){
            case "generate":
                generateBill(request, response);
                break;
            default:
                response.getWriter().println("Invalid action");
        }
    }


    protected void generateBill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            int patientId = Integer.parseInt(request.getParameter("patientId"));
            int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
            double consultationFee = Double.parseDouble(request.getParameter("consultationFee"));
            double medicineCharges = Double.parseDouble(request.getParameter("medicineCharges"));
            double testCharges = Double.parseDouble(request.getParameter("testCharges"));
            double roomCharges = Double.parseDouble(request.getParameter("roomCharges"));
            Bill.PaymentStatus paymentStatus = Bill.PaymentStatus.valueOf(request.getParameter("paymentStatus"));
            Bill bill = new Bill(patientId, appointmentId, consultationFee, medicineCharges, testCharges, roomCharges, paymentStatus);
            billingDAO.generateBill(bill);
            response.sendRedirect(request.getContextPath()+"/billing?action=viewAll");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void viewAllBills(HttpServletRequest request, HttpServletResponse response) throws IOException,  ServletException {
        try{
            ArrayList<Bill> bills = billingDAO.getAllBills();
            request.setAttribute("bills", bills);
            request.getRequestDispatcher("/billing/view-bills.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void searchBill(HttpServletRequest request, HttpServletResponse response) throws IOException,  ServletException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Bill bill = billingDAO.getBillById(id);
            request.setAttribute("bill", bill);
            request.getRequestDispatcher("/billing/bill-details.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
