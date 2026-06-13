<%@ page import="com.hms.appointment.Appointment" %>

<%
    Appointment a =
            (Appointment) request.getAttribute("appointment");
%>

<html>
<head>
    <title>Appointment Details</title>
</head>

<body>

<h1>Appointment Details</h1>

<%
    if(a == null){
%>

<h2>Appointment Not Found</h2>

<%
}
else{
%>

<p>
    Appointment ID :
    <%= a.getAppointmentId() %>
</p>

<p>
    Patient ID :
    <%= a.getPatientId() %>
</p>

<p>
    Doctor ID :
    <%= a.getDoctorId() %>
</p>

<p>
    Date :
    <%= a.getAppointmentDate() %>
</p>

<p>
    Time :
    <%= a.getAppointmentTime() %>
</p>

<p>
    Status :
    <%= a.getStatus() %>
</p>

<%
    }
%>

</body>
</html>