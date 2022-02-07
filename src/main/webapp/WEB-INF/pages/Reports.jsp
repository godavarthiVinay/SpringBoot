<%--
  Created by IntelliJ IDEA.
  User: developer
  Date: 26/01/22
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Emp Details</title>
    <link rel="stylesheet" href="css/reports.css">
</head>
<body >
    <h2 style="text-align: center">Employee Reports</h2>
    <div class="addButton">
        <a href="emp_register?id=-1">
            <span>+</span>
            Add Employee
        </a>
    </div>

    <c:choose>
        <c:when test="${!empty page.getContent()}" >
            <table align="center" >
                <tr style="background-color: darkslategray;color: antiquewhite">
                    <th>Id</th>
                    <th>Name</th>
                    <th>Job</th>
                    <th>Salary</th>
                    <th>DeptNo </th>
                    <th>Date Of Joining </th>
                    <th>Date Of Birth </th>
                    <th>Login Time </th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="emp" items="${page.getContent()}" >
                    <tr style="padding: 0.8rem 0.8rem">
                        <td>${emp.empNo}</td>
                        <td>${emp.ename}</td>
                        <td>${emp.job}</td>
                        <td>${emp.esal}</td>
                        <td>${emp.deptNo}</td>
                        <td>${emp.doj}</td>
                        <td>${emp.dob}</td>
                        <td>${emp.loginTime}</td>
                        <td>
                            <a style="font-style: italic;color: blue;font-weight: bold;margin-right: 16px"
                             href="emp_register?id=${emp.empNo}">Edit</a>
                            <a style="font-style: italic;color: blue;font-weight: bold"
                               href="delete_emp?id=${emp.empNo}"
                               onclick="confirm('Do you want to Delete ?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <div style="text-align: center">
                <p style="color: crimson"><strong >No Records Found</strong></p>
            </div>

        </c:otherwise>
    </c:choose>
</br>
</br>
<p align="center">

</p>



</body>
</html>
