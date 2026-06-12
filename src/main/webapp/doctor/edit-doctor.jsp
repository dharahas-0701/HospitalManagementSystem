<%@ page import="com.hms.doctor.Doctor" %>

<%
    Doctor d =
            (Doctor) request.getAttribute("doctor");
%>

<html>
<head>
    <title>Edit Doctor</title>
</head>

<body>

<%
    if(d == null){
%>

<h2>Doctor Not Found</h2>

<%
}
else{
%>

<h1>Edit Doctor</h1>

<form action="${pageContext.request.contextPath}/doctor"
      method="post">

    <input type="hidden"
           name="action"
           value="update">

    <input type="hidden"
           name="doctorId"
           value="<%= d.getDoctorId() %>">

    <p>
        Doctor ID :
        <b><%= d.getDoctorId() %></b>
    </p>

    <p>
        Name :
        <input type="text"
               name="doctorName"
               value="<%= d.getDoctorName() %>"
               required>
    </p>

    <p>
        Phone :
        <input type="text"
               name="phone"
               value="<%= d.getPhone() %>"
               required>
    </p>

    <p>
        Experience :
        <input type="number"
               name="experience"
               value="<%= d.getExperience() %>"
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
                    <%= d.getSpecialization() == s ?
                            "selected" : "" %>>
                <%= s %>
            </option>

            <%
                }
            %>

        </select>
    </p>

    <p>
        Availability :
        <select name="availability">

            <option value="AVAILABLE"
                    <%= d.getAvailability() ==
                            Doctor.Availability.AVAILABLE ?
                            "selected" : "" %>>
                AVAILABLE
            </option>

            <option value="UNAVAILABLE"
                    <%= d.getAvailability() ==
                            Doctor.Availability.UNAVAILABLE ?
                            "selected" : "" %>>
                UNAVAILABLE
            </option>

        </select>
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