<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(msg!=null){
%>
<p style="font-size: 20px; color:red;"><%=msg%></p>
<%} %>
<form action="./add" method="get">
		<table>
			<tr>
				<td>Employee Id:</td>
				<td><input type="number" name="empID" required></td>
			</tr><br>
			<tr>
				<td>Employee Name:</td>
				<td><input type="text" name="empName" required></td>
			</tr><br>
			<tr>
				<td>Employee Designation:</td>
				<td><input type="text" name="empDesignation" required></td>
			</tr><br>
			<tr>
				<td>Employee Salary:</td>
				<td><input type="text" name="empSalary" required></td>
			</tr><br>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password" required></td>
			</tr><br>
			<tr>
				<td>Confirm Password: </td>
				<td><input type="password" name="cpassword" required></td>
			</tr><br>
			<tr>
				<td><input type="submit" value="ADD EMPLOYEE"></td>
			</tr>
		</table>

	</form>

</body>
</html>