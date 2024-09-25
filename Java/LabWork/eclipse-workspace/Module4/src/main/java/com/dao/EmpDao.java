package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Emp;

public class EmpDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/module4", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static List<Emp> getAllRecords() {
		List<Emp> list = new ArrayList<Emp>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp u = new Emp();
				u.setComm(rs.getFloat("comm"));
				u.setDeptno(rs.getInt("deptno"));
				u.setEmpno(rs.getInt("empno"));
				u.setEname(rs.getString("ename"));
				u.setHiredate(rs.getDate("hiredate"));
				u.setJob(rs.getString("job"));
				u.setMgr(rs.getInt("mgr"));
				u.setSal(rs.getFloat("sal"));							
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
