<html>
<head>
    <title>Search Bill</title>
</head>

<body>

<h1>Search Bill</h1>

<form action="${pageContext.request.contextPath}/billing"
      method="get">

    <input type="hidden"
           name="action"
           value="search">

    <label>Bill ID :</label>

    <input type="number"
           name="id"
           required>

    <button type="submit">
        Search Bill
    </button>

</form>

</body>
</html>