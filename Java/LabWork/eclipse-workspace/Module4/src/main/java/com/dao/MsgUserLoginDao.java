package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.MsgUserModel;
import com.util.DBUtil;

public class MsgUserLoginDao {
	Connection cn = null;

	public MsgUserModel MsgUserLogin(MsgUserModel lmodel) {
		MsgUserModel model = null;
		try {
			cn = new DBUtil().getConnectionData();
			String qry = "select * from user where fname=? and lname=?";
			PreparedStatement st = cn.prepareStatement(qry);
			st.setString(1, lmodel.getFname());
			st.setString(2, lmodel.getLname());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				model = new MsgUserModel();
				model.setUserid(rs.getInt(1));
				model.setFname(rs.getString("fname"));
				model.setLname(rs.getString("lname"));
				model.setEmail(rs.getString("email"));
				model.setMobile(rs.getString("mobile"));
			}
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;
	}
}
