package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.RegistrationModel;
import com.util.DBUtil;

public class RegistrationDao {
	Connection cn = null;
	int x = 0;

	public int userRegistration(RegistrationModel rmodel) {
		try {
			Connection cn=new DBUtil().getConnectionData();			
			PreparedStatement st=cn.prepareStatement("insert into TblRegistration (UserName,EmailId,pwd,RegistrationType,ActiveFlag,CreatedDateTime,CreatedByIP) values (?,?,?,?,?,?,?)");			
			st.setString(1, rmodel.getUsername());
			st.setString(2, rmodel.getEmailid());
			st.setString(3, rmodel.getPwd());
			st.setString(4, rmodel.getRegistrationtype());
			st.setString(5, rmodel.getActiveflag());
			st.setString(6, rmodel.getCreateddatetime());
			st.setString(7, rmodel.getCreatedbyip());
			x=st.executeUpdate();
			cn.close();										
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
}
