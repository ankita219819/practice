package com.manthan.employee.jspfile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manthan.employee.DaoImplement.EmployeeDao;
import com.manthan.employee.DaoImplement.EmployeeDaoImplement;
import com.manthan.employee.ServletDB.EmployeeBean;

@WebServlet("/add")
public class AddEmployeeJsp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeBean bean=new EmployeeBean();
		int empID=Integer.parseInt(req.getParameter("empID"));
		String empName=req.getParameter("empName");
		String empDesignation=req.getParameter("empDesignation");
		int empSalary=Integer.parseInt(req.getParameter("empSalary"));
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		if(cpassword.equals(password)) {
			
			bean.setEmp_ID(empID);
			bean.setEmp_name(empName);
			bean.setEmp_designation(empDesignation);
			bean.setEmp_salary(empSalary);
			bean.setEmp_password(password);
			
			EmployeeDao dao=new EmployeeDaoImplement();
			
			if(dao.AddEmployee(bean)) {
				req.setAttribute("msg", "You have successfully Signed in. Please Login in ");
				req.getRequestDispatcher("./loginPage").forward(req, resp);
			}
			else {
				req.setAttribute("msg", "couldn't add ");
				req.getRequestDispatcher("./loginPage").forward(req, resp);
			}
		}
		else {
			req.setAttribute("msg", "Confirm Password doesn't match with Password");
			req.getRequestDispatcher("./signin").forward(req, resp);
		}

		

		
	}
}
