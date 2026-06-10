<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hms.patient.Patient" %>

<%
    ArrayList<Patient> patients =
            (ArrayList<Patient>) request.getAttribute("patients");
%>

<html>
<head>
    <title>View Patients</title>
</head>

<body>

<h1>All Patients</h1>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Blood Group</th>
        <th>Disease</th>
        <th>Phone</th>
    </tr>

    <%
        for(Patient p : patients){
    %>

    <tr>
        <td><%= p.getPatientId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getAge() %></td>
        <td><%= p.getGender() %></td>
        <td><%= p.getBloodGroup() %></td>
        <td><%= p.getDisease() %></td>
        <td><%= p.getPhone() %></td>
    </tr>

    <%
        }
    %>

</table>

</body>
</html>