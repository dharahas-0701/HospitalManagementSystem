
<html>
<head>
    <title>Delete Doctor</title>
</head>
<body>
<h1>Delete Doctor</h1>
<form action="${pageContext.request.contextPath}/doctor" method="POST">
    <input type="hidden" name="action" value="delete">
    <label>Doctor ID :</label>
    <input type="number" name="doctorId" required>
    <button type="submit">Delete Doctor</button>
</form>

</body>
</html>
