<%@page import="com.manthan.employee.DaoImplement.EmployeeDaoImplement"%>
<%@page import="com.manthan.employee.DaoImplement.EmployeeDao"%>
<%@page import="com.manthan.employee.ServletDB.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	EmployeeDao dao=new EmployeeDaoImplement();
    	ArrayList<EmployeeBean> al= dao.AllEmployee();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
th, td{
border: 1px solid balck;
}
</style>
</head>
<body>

<table style="border: 1px solid balck;">
<tr>
  	<th>Employee ID</th>
	<th>Employee name</th>
	<th>Designation</th>
	<th>Salary</th>
</tr>

<%
for(EmployeeBean bean : al) 
{
%>
<tr>
<td><%=bean.getEmp_ID() %></td>
<td><%=bean.getEmp_name() %></td>
<td><%=bean.getEmp_designation() %></td>
<td><%=bean.getEmp_salary() %></td>
</tr>
<%} %>

</table>
</body>
</html>