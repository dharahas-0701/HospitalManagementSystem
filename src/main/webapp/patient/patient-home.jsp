<html>
<head>
    <title>Patient Management</title>
    <link rel="stylesheet" href="../css/module.css">
</head>

<body>

<h1>Patient Management</h1>

<ul>

    <li><a href="add-patient.jsp">Add Patient</a></li>

    <li>
        <a href="${pageContext.request.contextPath}/patient?action=viewAll">
            View All Patients
        </a>
    </li>

    <li><a href="search-patient.jsp">Search Patient</a></li>

    <li><a href="update-patient-search.jsp">Update Patient</a></li>

    <li><a href="delete-patient.jsp">Delete Patient</a></li>

</ul>

<br>

<a href="${pageContext.request.contextPath}/index.jsp">
    Back to Home
</a>

</body>
</html>