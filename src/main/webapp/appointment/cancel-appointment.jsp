<html>
<head>
    <title>Cancel Appointment</title>
</head>

<body>

<h1>Cancel Appointment</h1>

<form action="${pageContext.request.contextPath}/appointment"
      method="post">

    <input type="hidden"
           name="action"
           value="cancel">

    <label>Appointment ID :</label>

    <input type="number"
           name="appointmentId"
           required>

    <button type="submit">
        Cancel Appointment
    </button>

</form>

</body>
</html>