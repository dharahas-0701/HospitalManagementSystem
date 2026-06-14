<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hms.billing.Bill" %>

<%
    ArrayList<Bill> bills =
            (ArrayList<Bill>)
                    request.getAttribute(
                            "bills"
                    );
%>

<html>
<head>
    <title>View Bills</title>
</head>

<body>

<h1>All Bills</h1>

<table border="1">

    <tr>

        <th>Bill ID</th>

        <th>Patient ID</th>

        <th>Appointment ID</th>

        <th>Consultation Fee</th>

        <th>Medicine Charges</th>

        <th>Test Charges</th>

        <th>Room Charges</th>

        <th>Total Amount</th>

        <th>Payment Status</th>

    </tr>

    <%
        if(bills != null){

            for(Bill b : bills){
    %>

    <tr>

        <td>
            <%= b.getBillId() %>
        </td>

        <td>
            <%= b.getPatientId() %>
        </td>

        <td>
            <%= b.getAppointmentId() %>
        </td>

        <td>
            <%= b.getConsultationFee() %>
        </td>

        <td>
            <%= b.getMedicineCharges() %>
        </td>

        <td>
            <%= b.getTestCharges() %>
        </td>

        <td>
            <%= b.getRoomCharges() %>
        </td>

        <td>
            <%= b.getTotalAmount() %>
        </td>

        <td>
            <%= b.getPaymentStatus() %>
        </td>

    </tr>

    <%
            }
        }
    %>

</table>

</body>
</html>