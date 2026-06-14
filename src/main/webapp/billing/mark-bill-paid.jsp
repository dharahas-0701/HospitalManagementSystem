<html>
<head>
    <title>Mark Bill Paid</title>
</head>

<body>

<h1>Mark Bill as Paid</h1>

<form action="${pageContext.request.contextPath}/billing"
      method="post">

    <input type="hidden"
           name="action"
           value="pay">

    <label>Bill ID :</label>

    <input type="number"
           name="billId"
           required>

    <button type="submit">
        Mark Paid
    </button>

</form>

</body>
</html>