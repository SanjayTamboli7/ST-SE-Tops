package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.model.ContactUsModel;
import com.util.DBUtil;

public class ContactUsDao {

	public int saveContactUs(ContactUsModel cu) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("insert into TblContactUs (YourName,YourEmailID,YourMessage,CreatedDateTime,CreatedByIP) values (?,?,?,?,?)");
			ps.setString(1, cu.getYourName());
			ps.setString(2, cu.getYourEmailID());
			ps.setString(3, cu.getYourMessage());			
			ps.setString(4, cu.getCreatedDateTime());
			ps.setString(5, cu.getCreatedByIP());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;		
	}	
	
	public static int updateContactUs(ContactUsModel cu) {
		int status = 0;
		try {
			
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("update TblContactUs set YourName=?,YourEmailID=?,YourMessage=?,CreatedDateTime=?,CreatedByIP=? where pkContactUsID=?");			
			ps.setString(1, cu.getYourName());
			ps.setString(2, cu.getYourEmailID());
			ps.setString(3, cu.getYourMessage());			
			ps.setString(4, cu.getCreatedDateTime());
			ps.setString(5, cu.getCreatedByIP());
			ps.setInt(6, cu.getPkContactUsID());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteContactUs(ContactUsModel cu) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("delete from TblContactUs where pkContactUsID=?");
			ps.setInt(1, cu.getPkContactUsID());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<ContactUsModel> getAllContactUss() {
		List<ContactUsModel> listContactUs = new ArrayList<ContactUsModel>();
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from TblContactUs");
			// where ContactUsEmailID = (select EmailId from TblRegistration where
			// username=<login jsp>)
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ContactUsModel cu = new ContactUsModel();				
				cu.setPkContactUsID(rs.getInt("pkContactUsID"));
				cu.setYourName(rs.getString("YourName"));
				cu.setYourEmailID(rs.getString("YourEmailID"));
				cu.setYourMessage(rs.getString("YourMessage"));
				cu.setCreatedDateTime(rs.getString("CreatedDateTime"));
				cu.setCreatedByIP(rs.getString("CreatedByIP"));				
				listContactUs.add(cu);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listContactUs;
	}

	public static ContactUsModel getContactUsByID(int ContactUsid) {

		ContactUsModel cu = null;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from TblContactUs where pkContactUsID=?");
			ps.setInt(1, ContactUsid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cu = new ContactUsModel();
				cu.setPkContactUsID(ContactUsid);
				cu.setYourName(rs.getString("YourName"));
				cu.setYourEmailID(rs.getString("YourEmailID"));
				cu.setYourMessage(rs.getString("YourMessage"));
				cu.setCreatedDateTime(rs.getString("CreatedDateTime"));
				cu.setCreatedByIP(rs.getString("CreatedByIP"));				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return cu;
	}


}
