package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.CustomerModel;
import com.util.DBUtil;

public class CustomerDao {
	
	Connection cn=null;
	public int customerRegistration(CustomerModel rmodel)
	{
		int x=0;
		try {
			cn=new DBUtil().getConnectionData();
			PreparedStatement st=cn.prepareStatement("insert into customer (firstname,lastname,mobno,address,city,email,password,status) values (?,?,?,?,?,?,?,?)");
			st.setString(1, rmodel.getFirstname());
			st.setString(2, rmodel.getLastname());
			st.setString(3, rmodel.getMobno());
			st.setString(4, rmodel.getAddress());
			st.setString(5, rmodel.getCity());
			st.setString(6, rmodel.getEmail());
			st.setString(7, rmodel.getPassword());
			st.setString(8, rmodel.getStatus());
			
			x=st.executeUpdate();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public CustomerModel customerLogin(CustomerModel, lmodel)
	{
		CustomerModel model=null;
		try {
			cn=new DBUtil().getConnectionData();
			String qry="select * from customer where email=? and password=? and status='Active'" ;
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1,lmodel.getEmail());
			st.setString(2,lmodel.getPassword());
			ResultSert rs=st.executeQuery();
			
			if (rs.next())
			{
				model=new CustomerModel();
				model.setCustomerid(rs.getInt(1));
				model.setFirstname(rs.getString(2));
				model.setLastname(rs.getString(3));
				model.setMobno(rs.getString(4));
				model.setAddress(rs.getString(5));
				model.setCity(rs.getString(6));
				model.setEmail(rs.getString(7));
				model.setPassword(rs.getString(8));
			}
			cn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return model;
	}
}
