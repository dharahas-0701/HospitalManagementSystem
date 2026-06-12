<html>
<head>
    <title>Search Doctor</title>
</head>

<body>

<h1>Search Doctor</h1>

<form action="${pageContext.request.contextPath}/doctor"
      method="get">

    <input type="hidden"
           name="action"
           value="search">

    Doctor ID :

    <input type="number"
           name="id"
           required>

    <button type="submit">
        Search
    </button>

</form>

</body>
</html>