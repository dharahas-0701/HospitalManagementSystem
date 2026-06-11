<%@ page import="com.hms.patient.Patient" %>

<%
    Patient p =
            (Patient) request.getAttribute("patient");
%>

<html>
<head>
    <title>Patient Details</title>
</head>

<body>

<h1>Patient Details</h1>

<%
    if(p == null){
%>

<h2>Patient Not Found</h2>

<%
}
else{
%>

<p>ID : <%= p.getPatientId() %></p>

<p>Name : <%= p.getName() %></p>

<p>Age : <%= p.getAge() %></p>

<p>Gender : <%= p.getGender() %></p>

<p>Blood Group : <%= p.getBloodGroup() %></p>

<p>Disease : <%= p.getDisease() %></p>

<p>Phone : <%= p.getPhone() %></p>

<%
    }
%>

</body>
</html>