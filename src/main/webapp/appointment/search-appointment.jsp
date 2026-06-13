<html>
<head>
    <title>Search Appointment</title>
</head>

<body>

<h1>Search Appointment</h1>

<form action="${pageContext.request.contextPath}/appointment"
      method="get">

    <input type="hidden"
           name="action"
           value="search">

    <label>Appointment ID :</label>

    <input type="number"
           name="id"
           required>

    <button type="submit">
        Search
    </button>

</form>

</body>
</html>