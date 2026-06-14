<html>
<head>
    <title>Appointment Management</title>
</head>

<body>

<h1>Appointment Management</h1>

<hr>

<ul>

    <li>
        <a href="book-appointment.jsp">
            Book Appointment
        </a>
    </li>

    <li>
        <a href="${pageContext.request.contextPath}/appointment?action=viewAll">
            View All Appointments
        </a>
    </li>

    <li>
        <a href="search-appointment.jsp">
            Search Appointment
        </a>
    </li>

    <li>
        <a href="update-appointment-search.jsp">
            Update Appointment
        </a>
    </li>

    <li>
        <a href="cancel-appointment.jsp">
            Cancel Appointment
        </a>
    </li>

</ul>

<br>

<a href="../index.jsp">
    Back to Home
</a>

</body>
</html>