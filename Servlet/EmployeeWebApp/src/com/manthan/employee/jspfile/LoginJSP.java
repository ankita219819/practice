package com.manthan.employee.jspfile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.employee.DaoImplement.EmployeeDao;
import com.manthan.employee.DaoImplement.EmployeeDaoImplement;

@WebServlet("/loginser")
public class LoginJSP extends HttpServlet{

	static int count;
	Map<Integer, Integer> m=new HashMap<Integer, Integer>();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int emp_ID=Integer.parseInt(req.getParameter("emp_ID"));
		String Password=req.getParameter("password");
		int c=1;
		EmployeeDao dao=new EmployeeDaoImplement();




		if(dao.LoginEmployee(emp_ID, Password)) {
			HttpSession httpSession=req.getSession(true);
			httpSession.setAttribute("ID", emp_ID);

			req.setAttribute("msg", "Employee Has been added");
			req.getRequestDispatcher("./HomePage").forward(req, resp);

		}//if condition
		
		
		else 
		{

			if(!m.containsKey(emp_ID))
			{
				m.put(emp_ID, 1);
			}
			else
			{
				count=m.get(emp_ID);
				m.put(emp_ID, count+1);
			}
			
			if(m.get(emp_ID)>1) {
				System.out.println("at");
				req.setAttribute("close", "hello");
				System.out.println("at2");
				
			}
			else {
				System.out.println("s1");
				req.setAttribute("lmsg", "inavlid "+m.get(emp_ID)+" attempts");
				System.out.println("s2");
			}
			System.out.println("s3");
			req.getRequestDispatcher("./loginPage").forward(req, resp);
			
			
			System.out.println(m);
			
		}
	}//doPOst()
}//loginjsp
