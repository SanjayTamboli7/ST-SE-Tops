package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.MsgUserModel;
import com.util.DBUtil;

public class MsgHomeDao {

	Connection cn=null;
	public MsgUserModel userVerifyLogin(String useremail)
	{
		MsgUserModel model=null;
		
		try {
			cn=new DBUtil().getConnectionData();
			String qry = "select * from user where email=?";
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, useremail);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				model = new MsgUserModel();
				model.setUserid(rs.getInt(1));
				model.setFname("fname");
				model.setLname("lname");				
				model.setEmail("email");
				model.setMobile("mobile");
			}
			cn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return model;
	}

}
