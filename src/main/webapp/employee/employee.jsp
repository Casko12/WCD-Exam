<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28-Oct-23
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<div align="center">
    <h1>Employee Add Form</h1>
    <form action="<%= request.getContextPath() %>/add-employee" method="post">
        <table style="with: 80%">
            <tr>
                <td>Full Name</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Birthday</td>
                <td><input type="date" name="birthday" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" /></td>
            </tr>
            <tr>
                <td>Position</td>
                <td><input type="text" name="position" /></td>
            </tr>
            <tr>
                <td>Department</td>
                <td><input type="text" name="department" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>
