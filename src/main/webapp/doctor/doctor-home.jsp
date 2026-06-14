<html>
<head>
    <title>Doctor Management</title>
</head>

<body>

<h1>Doctor Management</h1>

<hr>

<ul>

    <li>
        <a href="add-doctor.jsp">
            Add Doctor
        </a>
    </li>

    <li>
        <a href="${pageContext.request.contextPath}/doctor?action=viewAll">
            View All Doctors
        </a>
    </li>

    <li>
        <a href="search-doctor.jsp">
            Search Doctor
        </a>
    </li>

    <li>
        <a href="update-doctor-search.jsp">
            Update Doctor
        </a>
    </li>

    <li>
        <a href="delete-doctor.jsp">
            Delete Doctor
        </a>
    </li>

</ul>

<br>

<a href="../index.jsp">
    Back to Home
</a>

</body>
</html>