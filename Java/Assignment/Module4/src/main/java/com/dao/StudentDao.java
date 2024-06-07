package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.model.User;

public class StudentDao {
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

	public static int save(Student u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into student(fname, lname, email, mobile, gender, password) values(?,?,?,?,?,?)");

			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setInt(4, u.getMobile());
			ps.setString(5, u.getGender());
			ps.setString(6, u.getPassword());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int update(Student u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update student set fname=?,lname=?,email=?,mobile=?,gender=?,password=? where id=?");
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setInt(4, u.getMobile());
			ps.setString(5, u.getGender());
			ps.setString(6, u.getPassword());
			ps.setInt(7, u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static int delete(Student u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from student where id=?");
			ps.setInt(1, u.getId());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public static List<Student> getAllRecords() {
		List<Student> list = new ArrayList<Student>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student u = new Student();
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getInt("mobile"));
				u.setGender(rs.getString("gender"));
				u.setPassword(rs.getString("password"));
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static Student getRecordById(int id) {
		Student ul = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ul = new Student();
				ul.setId(id);
				ul.setId(rs.getInt("id"));
				ul.setFname(rs.getString("fname"));
				ul.setLname(rs.getString("lname"));
				ul.setEmail(rs.getString("email"));
				ul.setMobile(rs.getInt("mobile"));
				ul.setGender(rs.getString("gender"));
				ul.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ul;
	}

}
