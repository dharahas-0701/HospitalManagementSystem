<%@ page import="com.hms.appointment.Appointment" %>

<%
    Appointment a =
            (Appointment) request.getAttribute("appointment");
%>

<html>
<head>
    <title>Edit Appointment</title>
</head>

<body>

<h1>Edit Appointment</h1>

<%
    if(a == null){
%>

<h2>Appointment Not Found</h2>

<%
}
else{
%>

<form action="${pageContext.request.contextPath}/appointment"
      method="post">

    <input type="hidden"
           name="action"
           value="update">

    <input type="hidden"
           name="appointmentId"
           value="<%= a.getAppointmentId() %>">

    <table>

        <tr>
            <td>Patient ID :</td>
            <td>
                <input type="number"
                       name="patientId"
                       value="<%= a.getPatientId() %>"
                       required>
            </td>
        </tr>

        <tr>
            <td>Doctor ID :</td>
            <td>
                <input type="number"
                       name="doctorId"
                       value="<%= a.getDoctorId() %>"
                       required>
            </td>
        </tr>

        <tr>
            <td>Date :</td>
            <td>
                <input type="date"
                       name="appointmentDate"
                       value="<%= a.getAppointmentDate() %>"
                       required>
            </td>
        </tr>

        <tr>
            <td>Time :</td>
            <td>
                <input type="time"
                       name="appointmentTime"
                       value="<%= a.getAppointmentTime().toString().substring(0,5) %>"
                       required>
            </td>
        </tr>

        <tr>
            <td>Status :</td>
            <td>

                <select name="status">

                    <option value="BOOKED"
                            <%= a.getStatus()==Appointment.Status.BOOKED ? "selected" : "" %>>
                        BOOKED
                    </option>

                    <option value="COMPLETED"
                            <%= a.getStatus()==Appointment.Status.COMPLETED ? "selected" : "" %>>
                        COMPLETED
                    </option>

                    <option value="CANCELLED"
                            <%= a.getStatus()==Appointment.Status.CANCELLED ? "selected" : "" %>>
                        CANCELLED
                    </option>

                </select>

            </td>
        </tr>

        <tr>
            <td colspan="2">
                <button type="submit">
                    Save Changes
                </button>
            </td>
        </tr>

    </table>

</form>

<%
    }
%>

</body>
</html>