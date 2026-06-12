<%@ page import="com.hms.doctor.Doctor" %>

<%
    Doctor d =
            (Doctor) request.getAttribute("doctor");
%>

<html>
<head>
    <title>Doctor Details</title>
</head>

<body>

<h1>Doctor Details</h1>

<%
    if(d == null){
%>

<h2>Doctor Not Found</h2>

<%
}
else{
%>

<p>
    Doctor ID :
    <%= d.getDoctorId() %>
</p>

<p>
    Name :
    <%= d.getDoctorName() %>
</p>

<p>
    Specialization :
    <%= d.getSpecialization() %>
</p>

<p>
    Phone :
    <%= d.getPhone() %>
</p>

<p>
    Experience :
    <%= d.getExperience() %>
</p>

<p>
    Availability :
    <%= d.getAvailability() %>
</p>

<%
    }
%>

</body>
</html>
