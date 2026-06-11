<html>
<head>
    <title>Search Patient</title>
</head>

<body>

<h1>Search Patient</h1>

<form action="${pageContext.request.contextPath}/patient"
      method="get">

    <input type="hidden"
           name="action"
           value="search">

    Patient ID :

    <input type="number"
           name="id"
           required>

    <button type="submit">
        Search
    </button>

</form>

</body>
</html>