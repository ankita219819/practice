package com.manthan.employee.ServletDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manthan.employee.DaoImplement.EmployeeDao;
import com.manthan.employee.DaoImplement.EmployeeDaoImplement;

@WebServlet("/login")
public class EmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int emp_ID=Integer.parseInt( req.getParameter("emp_ID"));
		String emp_name=req.getParameter("emp_name");
		String emp_designation=req.getParameter("emp_designation");
		long emp_salary=Long.parseLong(req.getParameter("emp_salary"));
		String emp_password=req.getParameter("emp_password");
		String image=req.getParameter("image");
		PrintWriter out=resp.getWriter();
		
		EmployeeBean bean=new EmployeeBean();
		EmployeeDao employeeDao=new EmployeeDaoImplement();
		
		bean.setEmp_ID(emp_ID);
		bean.setEmp_name(emp_name);
		bean.setEmp_designation(emp_designation);
		bean.setEmp_salary(emp_salary);
		bean.setEmp_password(emp_password);
		
		if(employeeDao.AddEmployee(bean)) {
			out.print("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
					"    <title>Document</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"    <table>\r\n" + 
					"\r\n" + 
					"        <thead>\r\n" + 
					"            <tr>\r\n" + 
					"                <th>Name</th>\r\n" + 
					"                <th>Designation</th>\r\n" + 
					"                <th>Image</th>\r\n" + 
					"            </tr>\r\n" + 
					"        </thead>\r\n" + 
					"        <tbody>\r\n" + 
					"            <tr>\r\n" + 
					"                <td>"+bean.getEmp_name()+"</td>\r\n" + 
					"                <td>"+bean.getEmp_designation()+"</td>\r\n" + 
					"            </tr>\r\n" + 
					"        </tbody>\r\n" + 
					"\r\n" + 
					"    </table>\r\n" + 
					"</body>\r\n" + 
					"</html> ");
		}
		else {
			out.print("file not found");
		}
	}

}
