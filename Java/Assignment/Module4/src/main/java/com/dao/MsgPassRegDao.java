package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.MsgUserModel;
import com.util.DBUtil;

public class MsgPassRegDao {
	Connection cn = null;
	int x = 0;

	public int userRegistration(MsgUserModel rmodel)
	{
		try {
			Connection cn=new DBUtil().getConnectionData();
			PreparedStatement st=cn.prepareStatement("insert into user(fname, lname, email, mobile) values(?, ?, ?, ?)");
			st.setString(1, rmodel.getFname());
			st.setString(2, rmodel.getLname());
			st.setString(3, rmodel.getEmail());
			st.setString(4, rmodel.getMobile());
			
			x=st.executeUpdate();
			cn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}
