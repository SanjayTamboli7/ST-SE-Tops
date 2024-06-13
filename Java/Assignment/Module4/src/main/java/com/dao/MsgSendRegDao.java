package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.MsgSendModel;
import com.util.DBUtil;

public class MsgSendRegDao {

	Connection cn = null;
	int x = 0;

	public int msgRegistration(MsgSendModel rmodel)
	{
		try {
			Connection cn=new DBUtil().getConnectionData();
			PreparedStatement st=cn.prepareStatement("insert into usermessage(FromUser, ToUser, MsgDetail) values(?, ?, ?)");
			st.setString(1, rmodel.getFromUser());
			st.setString(2, rmodel.getToUser());
			st.setString(3, rmodel.getMsgDetail());			
			x=st.executeUpdate();
			cn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}
