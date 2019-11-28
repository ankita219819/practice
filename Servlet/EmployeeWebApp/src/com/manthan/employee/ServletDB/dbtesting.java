package com.manthan.employee.ServletDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class dbtesting {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		Statement st=null;
		int n;
		boolean isAdd=false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root");
			String sql="insert into employee_info values(101,'Ankita', 'se', 2000000000,'qwerty');";
			st=con.createStatement();
			n=st.executeUpdate(sql);
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
		System.out.println(isAdd+" ------------------------");
		
	}

}



