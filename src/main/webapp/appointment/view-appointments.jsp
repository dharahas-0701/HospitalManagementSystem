<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hms.appointment.Appointment" %>

<%
    ArrayList<Appointment> appointments =
            (ArrayList<Appointment>)
                    request.getAttribute("appointments");
%>

<html>
<head>
    <title>All Appointments</title>
</head>

<body>

<h1>All Appointments</h1>

<table border="1">

    <tr>
        <th>Appointment ID</th>
        <th>Patient ID</th>
        <th>Doctor ID</th>
        <th>Date</th>
        <th>Time</th>
        <th>Status</th>
    </tr>

    <%
        if(appointments != null){

            for(Appointment a : appointments){
    %>

    <tr>

        <td><%= a.getAppointmentId() %></td>

        <td><%= a.getPatientId() %></td>

        <td><%= a.getDoctorId() %></td>

        <td><%= a.getAppointmentDate() %></td>

        <td><%= a.getAppointmentTime() %></td>

        <td><%= a.getStatus() %></td>

    </tr>

    <%
            }
        }
    %>

</table>

</body>
</html>