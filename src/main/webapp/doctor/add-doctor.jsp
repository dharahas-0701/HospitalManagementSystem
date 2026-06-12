<html>
<head>
    <title>Add Doctor</title>
</head>

<body>

<h1>Add Doctor</h1>

<form action="${pageContext.request.contextPath}/doctor"
      method="post">

    <input type="hidden"
           name="action"
           value="add">

    Name:
    <input type="text"
           name="doctorName"
           required>

    <br><br>

    Specialization:

    <select name="specialization">

        <option value="CARDIOLOGIST">CARDIOLOGIST</option>
        <option value="NEUROLOGIST">NEUROLOGIST</option>
        <option value="ORTHOPEDIC">ORTHOPEDIC</option>
        <option value="PEDIATRICIAN">PEDIATRICIAN</option>
        <option value="DERMATOLOGIST">DERMATOLOGIST</option>
        <option value="GENERAL_PHYSICIAN">GENERAL_PHYSICIAN</option>
        <option value="ENT">ENT</option>
        <option value="PSYCHIATRIST">PSYCHIATRIST</option>

    </select>

    <br><br>

    Phone:
    <input type="text"
           name="phone"
           required>

    <br><br>

    Experience:
    <input type="number"
           name="experience"
           required>

    <br><br>

    Availability:

    <select name="availability">

        <option value="AVAILABLE">
            AVAILABLE
        </option>

        <option value="UNAVAILABLE">
            UNAVAILABLE
        </option>

    </select>

    <br><br>

    <button type="submit">
        Add Doctor
    </button>

</form>

</body>
</html>