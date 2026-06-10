<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Patient</title>
</head>
<body>

<h2>Add Patient</h2>

<form action="/hms/patient?action=add" method="post">

    <table>

        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name" required>
            </td>
        </tr>

        <tr>
            <td>Age:</td>
            <td>
                <input type="number" name="age" required>
            </td>
        </tr>

        <tr>
            <td>Gender:</td>
            <td>
                <select name="gender">

                    <option value="MALE">
                        Male
                    </option>

                    <option value="FEMALE">
                        Female
                    </option>

                    <option value="OTHER">
                        Other
                    </option>

                </select>
            </td>
        </tr>

        <tr>
            <td>Blood Group:</td>
            <td>
                <select name="bloodGroup">

                    <option value="A_POSITIVE">A+</option>
                    <option value="A_NEGATIVE">A-</option>

                    <option value="B_POSITIVE">B+</option>
                    <option value="B_NEGATIVE">B-</option>

                    <option value="AB_POSITIVE">AB+</option>
                    <option value="AB_NEGATIVE">AB-</option>

                    <option value="O_POSITIVE">O+</option>
                    <option value="O_NEGATIVE">O-</option>

                </select>
            </td>
        </tr>

        <tr>
            <td>Disease:</td>
            <td>
                <input type="text" name="disease" required>
            </td>
        </tr>

        <tr>
            <td>Phone:</td>
            <td>
                <input type="text" name="phone" required>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Add Patient">
            </td>
        </tr>

    </table>

</form>

</body>
</html>