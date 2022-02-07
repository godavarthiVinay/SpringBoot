<%--
  Created by IntelliJ IDEA.
  User: developer
  Date: 26/01/22
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add Employee</title>
    <script rel="script" src="scripts/register.js"></script>
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
<h2 style="text-align: center">Add/Edit Employee</h2>
<%--onsubmit="return validate(this)"--%>
<form:form method="post" modelAttribute="emp" >
    <table align="center">
        <tr style="${emp.empNo==0?"display:none":""}">
            <td>Employee No</td>
            <td><form:input path="empNo" readonly="true" /></td>
        </tr>
        <tr>
            <td>Employee Name</td>
            <td><form:input path="ename" maxlength="30"/>
                <form:errors path="ename" cssClass="error"/>
                <span class="error" id="eNameErr"></span>
            </td>
        </tr>
        <tr>
            <td>Employee Gender</td>
            <td><form:radiobuttons path="gender" items="${genders}"/>
                <form:errors path="gender" cssClass="error"/>
                <span class="error" id="genderErr"></span>
            </td>
        </tr>
        <tr>
            <td>Employee Job</td>
            <td><form:input path="job" maxlength="30"/>
                <form:errors path="job" cssClass="error"/>
                <span class="error" id="jobErr"></span>
            </td>
        </tr>
        <tr>
            <td>Employee Salary</td>
            <td><form:input path="esal" type="number" maxlength="10"/>
                <form:errors path="esal" cssClass="error"/>
                <span class="error" id="salErr"></span>
            </td>
        </tr>
        <tr>
            <td>Employee DeptNo</td>
            <td><form:input path="deptNo" type="number" maxlength="4"/>
                <form:errors path="deptNo" cssClass="error"/>
                <span class="error" id="deptNoErr"></span>
            </td>
        </tr>

        <tr>
            <td>Employee Date of Joining</td>
            <td><form:input path="doj" type="date"/>
                <form:errors path="doj" cssClass="error"/>
                <span class="error" id="deptNoErr"></span>
            </td>
        </tr>

        <tr>
            <td>Employee Date of Birth</td>
            <td><form:input path="dob" type="datetime-local" />
                <form:errors path="dob" cssClass="error"/>
                <span class="error" id="deptNoErr"></span>
            </td>
        </tr>

        <tr>
            <td>Employee Login Time</td>
            <td><form:input path="loginTime" type="time" />
                <form:errors path="loginTime" cssClass="error"/>
                <span class="error" id="deptNoErr"></span>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
                <input type="reset" />
            </td>

        </tr>
    </table>
    <form:hidden path="vflag" value="false"/>
</form:form>


</body>
</html>
