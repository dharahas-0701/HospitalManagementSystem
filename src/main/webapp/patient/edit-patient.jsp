<%@ page import="com.hms.patient.Patient" %>

<%
    Patient p =
            (Patient) request.getAttribute("patient");
%>

<html>
<head>
    <title>Edit Patient</title>
</head>

<body>

<%
    if(p == null){
%>

<h2>Patient Not Found</h2>

<%
}
else{
%>

<h1>Edit Patient</h1>

<form action="${pageContext.request.contextPath}/patient"
      method="post">

    <input type="hidden"
           name="action"
           value="update">

    <input type="hidden"
           name="patientId"
           value="<%= p.getPatientId() %>">

    <p>
        Patient ID :
        <b><%= p.getPatientId() %></b>
    </p>

    <p>
        Name :
        <input type="text"
               name="name"
               value="<%= p.getName() %>"
               required>
    </p>

    <p>
        Age :
        <input type="number"
               name="age"
               value="<%= p.getAge() %>"
               required>
    </p>

    <p>
        Gender :
        <select name="gender">

            <option value="MALE"
                    <%= p.getGender() == Patient.Gender.MALE ? "selected" : "" %>>
                MALE
            </option>

            <option value="FEMALE"
                    <%= p.getGender() == Patient.Gender.FEMALE ? "selected" : "" %>>
                FEMALE
            </option>

            <option value="OTHER"
                    <%= p.getGender() == Patient.Gender.OTHER ? "selected" : "" %>>
                OTHER
            </option>

        </select>
    </p>

    <p>
        Blood Group :
        <input type="text"
               name="bloodGroup"
               value="<%= p.getBloodGroup() %>"
               required>
    </p>

    <p>
        Disease :
        <input type="text"
               name="disease"
               value="<%= p.getDisease() %>"
               required>
    </p>

    <p>
        Phone :
        <input type="text"
               name="phone"
               value="<%= p.getPhone() %>"
               required>
    </p>

    <button type="submit">
        Save Changes
    </button>

</form>

<%
    }
%>

</body>
</html>