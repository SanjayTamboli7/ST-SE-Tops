package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.RegistrationModel;
import com.util.DBUtil;

public class LoginDao {

	Connection cn = null;

	public RegistrationModel userLogin(RegistrationModel lmodel) {
		RegistrationModel model = null;
		try {
			cn = new DBUtil().getConnectionData();
			String qry = "select * from tblregistration where UserName=? and pwd=?";
			PreparedStatement st = cn.prepareStatement(qry);
			st.setString(1, lmodel.getUsername());
			st.setString(2, lmodel.getPwd());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				model=new RegistrationModel();
				model.setUsername(rs.getString("username"));
				model.setEmailid(rs.getString("emailid"));
				model.setPwd(rs.getString("password"));
				model.setRegistrationtype(rs.getString("activeflag"));
				model.setActiveflag(rs.getString("activeflag"));
				model.setCreateddatetime(rs.getString("createddatetime"));
				model.setCreatedbyip(rs.getString("createdbyip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
}
