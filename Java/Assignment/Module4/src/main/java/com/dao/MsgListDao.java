package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.MsgList;

public class MsgListDao {

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

	public static List<MsgList> getAllRecords() {
		List<MsgList> list = new ArrayList<MsgList>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from usermessage");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MsgList u = new MsgList();
				u.setMsgId(rs.getInt("MsgId"));
				u.setFromUser(rs.getString("FromUser"));
				u.setToUser(rs.getString("ToUser"));
				u.setMsgDetail(rs.getString("MsgDetail"));			
				list.add(u);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
}
