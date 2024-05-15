package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.UserModel;
import com.util.DBUtil;

public class HomeDao {

	Connection cn=null;
	public UserModel userVerifyLogin(int userid)
	{
		UserModel model=null;
		
		try {
			cn=new DBUtil().getConnectionData();
			String qry = "select * from user where userid=?";
			PreparedStatement st=cn.prepareStatement(qry);
			st.setInt(1, userid);
			ResultSet rs = st.executeQuery();
			if (rs.next())
			{
				model = new UserModel();
				model.setUserid(rs.getInt(1));
				model.setFirstname(rs.getString("firstname"));
				model.setLastname(rs.getString(3));
				model.setUsername(rs.getString("username"));
				model.setPassword(rs.getString(5));
			}
			cn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return model;
	}
	
	public int updateUser(UserModel hmodel) {
		int x=0;
		try {
			cn=new DBUtil().getConnectionData();
			String qry = "update user set firstname=?,lastname=?,username=?,password=? where userid=?";
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, hmodel.getFirstname());
			st.setString(2, hmodel.getLastname());
			st.setString(3, hmodel.getUsername());
			st.setString(4, hmodel.getPassword());
			st.setInt(5, hmodel.getUserid());
			x=st.executeUpdate();
			cn.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return x;
	}

	public int deleteUser(int userid) {
		int x=0;
		try {
			cn=new DBUtil().getConnectionData();
			String qry = "delete from user where userid = ?";
			PreparedStatement st=cn.prepareStatement(qry);
			st.setInt(1, userid);
			x=st.executeUpdate();
			cn.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return x;
	}

}
