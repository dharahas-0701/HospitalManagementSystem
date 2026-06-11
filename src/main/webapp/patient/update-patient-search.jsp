<html>
<head>
    <title>Update Patient</title>
</head>

<body>

<h1>Update Patient</h1>

<form action="${pageContext.request.contextPath}/patient"
      method="get">

    <input type="hidden"
           name="action"
           value="edit">

    <label>Patient ID:</label>

    <input type="number"
           name="id"
           required>

    <button type="submit">
        Load Patient
    </button>

</form>

</body>
</html>