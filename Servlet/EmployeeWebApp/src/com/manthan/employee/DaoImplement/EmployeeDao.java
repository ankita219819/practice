package com.manthan.employee.DaoImplement;

import java.util.ArrayList;

import com.manthan.employee.ServletDB.EmployeeBean;

public interface EmployeeDao {
	public boolean AddEmployee(EmployeeBean employeeBean);
	public boolean LoginEmployee(int emp_ID, String password);
	public ArrayList<EmployeeBean> AllEmployee();
}

