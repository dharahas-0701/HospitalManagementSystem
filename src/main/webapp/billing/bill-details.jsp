<%@ page import="com.hms.billing.Bill" %>

<%
    Bill bill =
            (Bill) request.getAttribute("bill");
%>

<html>
<head>
    <title>Bill Details</title>
</head>

<body>

<h1>Bill Details</h1>

<%
    if(bill == null){
%>

<h2>Bill Not Found</h2>

<%
}
else{
%>

<p>Bill ID : <%= bill.getBillId() %></p>

<p>Patient ID : <%= bill.getPatientId() %></p>

<p>Appointment ID : <%= bill.getAppointmentId() %></p>

<p>Consultation Fee : <%= bill.getConsultationFee() %></p>

<p>Medicine Charges : <%= bill.getMedicineCharges() %></p>

<p>Test Charges : <%= bill.getTestCharges() %></p>

<p>Room Charges : <%= bill.getRoomCharges() %></p>

<p>Total Amount : <%= bill.getTotalAmount() %></p>

<p>Payment Status : <%= bill.getPaymentStatus() %></p>

<%
    }
%>

</body>
</html>