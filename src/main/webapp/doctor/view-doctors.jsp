<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hms.doctor.Doctor" %>

<%
    ArrayList<Doctor> doctors =
            (ArrayList<Doctor>)
                    request.getAttribute(
                            "doctors"
                    );
%>

<html>
<head>
    <title>View Doctors</title>
</head>

<body>

<h1>All Doctors</h1>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Specialization</th>
        <th>Phone</th>
        <th>Experience</th>
        <th>Availability</th>
    </tr>

    <%
        for(Doctor d : doctors){
    %>

    <tr>

        <td>
            <%= d.getDoctorId() %>
        </td>

        <td>
            <%= d.getDoctorName() %>
        </td>

        <td>
            <%= d.getSpecialization() %>
        </td>

        <td>
            <%= d.getPhone() %>
        </td>

        <td>
            <%= d.getExperience() %>
        </td>

        <td>
            <%= d.getAvailability() %>
        </td>

    </tr>

    <%
        }
    %>

</table>

</body>
</html>