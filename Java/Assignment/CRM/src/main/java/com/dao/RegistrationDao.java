package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

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
	
	public static int updateRegistration(RegistrationModel rmodel) {
		int status = 0;
		try {
			
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement st = cn.prepareStatement("update TblRegistration set UserName=?,EmailId=?,pwd=?,RegistrationType=?,ActiveFlag=?,CreatedDateTime=?,CreatedByIP=? where pkRegID=?");			
			st.setString(1, rmodel.getUsername());
			st.setString(2, rmodel.getEmailid());
			st.setString(3, rmodel.getPwd());
			st.setString(4, rmodel.getRegistrationtype());
			st.setString(5, rmodel.getActiveflag());
			st.setString(6, rmodel.getCreateddatetime());
			st.setString(7, rmodel.getCreatedbyip());		
			// st.setInt(8, 1);
			st.setInt(8, rmodel.getPkregid()); // set pkRegId here to update the specific row.
			status = st.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteRegistration(RegistrationModel rmodel) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("delete from TblRegistration where pkRegID=?");
			// ps.setInt(1, 2);
			ps.setInt(1, rmodel.getPkregid()); // set pkRegId here to update the specific row.
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<RegistrationModel> getAllRegistrations() {
		List<RegistrationModel> listRegistration = new ArrayList<RegistrationModel>();
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from TblRegistration");
			// where ContactUsEmailID = (select EmailId from TblRegistration where
			// username=<login jsp>)
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RegistrationModel rmodel = new RegistrationModel();
				rmodel.setPkregid(rs.getInt("pkregid"));
				rmodel.setUsername(rs.getString("username"));
				rmodel.setEmailid(rs.getString("emailid"));
				rmodel.setPwd(rs.getString("pwd"));
				rmodel.setRegistrationtype(rs.getString("registrationtype"));
				rmodel.setActiveflag(rs.getString("activeflag"));
				rmodel.setCreateddatetime(rs.getString("createddatetime"));
				rmodel.setCreatedbyip(rs.getString("createdbyip"));								
				listRegistration.add(rmodel);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listRegistration;
	}

	public static RegistrationModel getRegistrationByID(int RegID) {

		RegistrationModel rmodel = null;
		try {
			System.out.println("Reg ID : " + RegID);
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from TblRegistration where pkRegID=?");
			ps.setInt(1, RegID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rmodel = new RegistrationModel();				
				rmodel.setPkregid(rs.getInt("pkregid"));
				rmodel.setUsername(rs.getString("username"));
				rmodel.setEmailid(rs.getString("emailid"));
				rmodel.setPwd(rs.getString("pwd"));
				rmodel.setRegistrationtype(rs.getString("registrationtype"));
				rmodel.setActiveflag(rs.getString("activeflag"));
				rmodel.setCreateddatetime(rs.getString("createddatetime"));
				rmodel.setCreatedbyip(rs.getString("createdbyip"));								
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return rmodel;
	}
	
}
