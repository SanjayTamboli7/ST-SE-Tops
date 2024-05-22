package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.CustomerModel;
import com.model.ServicesModel;
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

}
