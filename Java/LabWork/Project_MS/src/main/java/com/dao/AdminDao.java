package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.CustomerModel;
import com.model.ServicesModel;
import com.model.SubServicesModel;
import com.util.DBUtil;

public class AdminDao {
	Connection cn=null;
	public int addMainServices(ServicesModel sm)
	{
		int x=0;
		try {
			cn=new DBUtil().getConnectionData();			
			PreparedStatement st=cn.prepareStatement("insert into services (servicename, image) values (?,?)");
			st.setString(1, sm.getServicename());
			st.setString(2, sm.getImage());
			
			x=st.executeUpdate();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	public int addSubServices(SubServicesModel ssm)
	{
		int x=0;
		try {
			cn=new DBUtil().getConnectionData();			
			PreparedStatement st=cn.prepareStatement("insert into subservices (serviceid, subname, features, price) values (?,?,?,?)");
			st.setInt(1, ssm.getServiceid());
			st.setString(2, ssm.getSubname());
			st.setString(3, ssm.getFeatures());
			st.setString(4, ssm.getPrice());
			
			x=st.executeUpdate();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}
