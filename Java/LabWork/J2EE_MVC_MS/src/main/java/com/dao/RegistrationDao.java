package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.model.UserModel;
import com.util.DBUtil;

public class RegistrationDao {
	Connection cn=null;
	int x=0;
	public int userRegistration(UserModel rmodel)
	{
		try {
			Connection cn=new DBUtil().getConnectionData();
			PreparedStatement st=cn.prepareStatement("insert into user(firstname, lastname, username, password) values(?, ?, ?, ?)");
			st.setString(1, rmodel.getFirstname());
			st.setString(2, rmodel.getLastname());
			st.setString(3, rmodel.getUsername());
			st.setString(4, rmodel.getPassword());
			
			x=st.executeUpdate();
			cn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
}
