<html>
<head>
    <title>Update Appointment</title>
</head>

<body>

<h1>Update Appointment</h1>

<form action="${pageContext.request.contextPath}/appointment"
      method="get">

    <input type="hidden"
           name="action"
           value="edit">

    <label>Appointment ID :</label>

    <input type="number"
           name="id"
           required>

    <button type="submit">
        Search Appointment
    </button>

</form>

</body>
</html>