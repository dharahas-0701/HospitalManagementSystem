<html>
<head>
    <title>Update Doctor</title>
</head>

<body>

<h1>Update Doctor</h1>

<form action="${pageContext.request.contextPath}/doctor"
      method="get">

    <input type="hidden"
           name="action"
           value="edit">

    Doctor ID :

    <input type="number"
           name="id"
           required>

    <button type="submit">
        Load Doctor
    </button>

</form>

</body>
</html>