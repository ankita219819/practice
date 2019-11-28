package com.manthan.employee.DaoImplement;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

import com.manthan.employee.ServletDB.EmployeeBean;

public class EmployeeDaoImplement extends HttpServlet implements EmployeeDao {

	Connection con=null;
	PreparedStatement pstmt=null;
	public boolean AddEmployee(EmployeeBean employeeBean) {
		
		int n;
		boolean isAdd=false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root");
			String sql="insert into employee_info values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, employeeBean.getEmp_ID());
			pstmt.setString(2, employeeBean.getEmp_name());
			pstmt.setString(3, employeeBean.getEmp_designation());
			pstmt.setLong(4, employeeBean.getEmp_salary());
			pstmt.setString(5, employeeBean.getEmp_password());
			n=pstmt.executeUpdate();
			if(n>0) {
				isAdd=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			/*
			 * if (rs != null) { try { rs.close(); } catch (SQLException e) {
			 * e.printStackTrace(); } }
			 */
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return isAdd;
	}

	@Override
	public boolean LoginEmployee(int emp_ID, String password) {

//		Connection con=null;
//		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int n;
		boolean islogin=false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root");
			String sql="select * from employee_info where emp_ID=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, emp_ID);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				islogin=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			 if (rs != null) { try { rs.close(); } catch (SQLException e) {
			  e.printStackTrace(); } }
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return islogin;
	}//login method
	
	public ArrayList<EmployeeBean> AllEmployee() {

		Statement st=null;
		ResultSet rs=null;
		
		ArrayList<EmployeeBean> arrayList=new ArrayList<EmployeeBean>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root");
			
			String sql="select * from employee_info";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				EmployeeBean bean=new EmployeeBean();
				bean.setEmp_ID(rs.getInt("emp_id"));
				bean.setEmp_name(rs.getString("emp_name"));
				bean.setEmp_designation(rs.getString("emp_designation"));
				bean.setEmp_salary(rs.getInt("salary"));
				arrayList.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			 if (rs != null) { try { rs.close(); } catch (SQLException e) {
			  e.printStackTrace(); } }
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return arrayList;
	}

}
