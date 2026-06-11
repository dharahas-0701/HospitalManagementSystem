<html>
<head>
    <title>Delete Patient</title>
</head>

<body>

<h1>Delete Patient</h1>

<form action="${pageContext.request.contextPath}/patient"
      method="post">

    <input type="hidden"
           name="action"
           value="delete">

    <label>Patient ID :</label>

    <input type="number"
           name="patientId"
           required>

    <button type="submit">
        Delete Patient
    </button>

</form>

</body>
</html>