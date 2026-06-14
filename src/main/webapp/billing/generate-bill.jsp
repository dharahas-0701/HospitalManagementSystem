<html>
<head>
    <title>Generate Bill</title>
</head>

<body>

<h1>Generate Bill</h1>

<form action="${pageContext.request.contextPath}/billing"
      method="post">

    <input type="hidden"
           name="action"
           value="generate">

    <p>
        Patient ID :
        <input type="number"
               name="patientId"
               required>
    </p>

    <p>
        Appointment ID :
        <input type="number"
               name="appointmentId"
               required>
    </p>

    <p>
        Consultation Fee :
        <input type="number"
               step="0.01"
               name="consultationFee"
               required>
    </p>

    <p>
        Medicine Charges :
        <input type="number"
               step="0.01"
               name="medicineCharges"
               required>
    </p>

    <p>
        Test Charges :
        <input type="number"
               step="0.01"
               name="testCharges"
               required>
    </p>

    <p>
        Room Charges :
        <input type="number"
               step="0.01"
               name="roomCharges"
               required>
    </p>

    <p>
        Payment Status :

        <select name="paymentStatus">

            <option value="PENDING">
                PENDING
            </option>

            <option value="PAID">
                PAID
            </option>

        </select>

    </p>

    <button type="submit">
        Generate Bill
    </button>

</form>

</body>
</html>