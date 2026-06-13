<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hms.doctor.Doctor" %>

<%
    ArrayList<Doctor> doctors =
            (ArrayList<Doctor>) request.getAttribute("doctors");

    String patientId =
            request.getParameter("patientId");

    String specialization =
            request.getParameter("specialization");
%>

<html>
<head>
    <title>Book Appointment</title>
</head>

<body>

<h1>Book Appointment</h1>

<!-- STEP 1 -->
<form action="${pageContext.request.contextPath}/appointment"
      method="get">

    <input type="hidden"
           name="action"
           value="loadDoctors">

    <p>
        Patient ID :
        <input type="number"
               name="patientId"
               value="<%= patientId == null ? "" : patientId %>"
               required>
    </p>

    <p>
        Specialization :

        <select name="specialization">

            <%
                for(Doctor.Specialization s :
                        Doctor.Specialization.values()){
            %>

            <option value="<%= s %>"
                    <%= s.name().equals(specialization)
                            ? "selected" : "" %>>

                <%= s %>

            </option>

            <%
                }
            %>

        </select>

    </p>

    <button type="submit">
        Load Doctors
    </button>

</form>

<hr>

<%
    if(doctors != null && !doctors.isEmpty()){
%>

<!-- STEP 2 -->
<form action="${pageContext.request.contextPath}/appointment"
      method="post">

    <input type="hidden"
           name="action"
           value="book">

    <input type="hidden"
           name="patientId"
           value="<%= patientId %>">

    <p>

        Doctor :

        <select name="doctorId">

            <%
                for(Doctor d : doctors){
            %>

            <option value="<%= d.getDoctorId() %>">

                <%= d.getDoctorName() %>
                (
                <%= d.getSpecialization() %>
                )

            </option>

            <%
                }
            %>

        </select>

    </p>

    <p>

        Date :

        <input type="date"
               name="appointmentDate"
               required>

    </p>

    <p>

        Time :

        <input type="time"
               name="appointmentTime"
               required>

    </p>

    <button type="submit">
        Book Appointment
    </button>

</form>

<%
    }
%>

</body>
</html>