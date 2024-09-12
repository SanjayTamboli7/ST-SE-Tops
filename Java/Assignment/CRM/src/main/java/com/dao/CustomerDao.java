package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.model.CustomerModel;
import com.util.DBUtil;

public class CustomerDao {

	public int saveCustomer(CustomerModel c) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("insert into TblCustomer (Customername,CustomerEmailID,CustomerContactNo,CustomerAddress,CustomerCity,CustomerState,CustomerCountry,fkRegID,CreatedDateTime,CreatedByIP) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, c.getCustomername());
			ps.setString(2, c.getCustomeremailid());
			ps.setString(3, c.getCustomercontactno());
			ps.setString(4, c.getCustomeraddress());
			ps.setString(5, c.getCustomercity());
			ps.setString(6, c.getCustomerstate());
			ps.setString(7, c.getCustomercountry());
			ps.setInt(8, 9);					
			ps.setString(9, c.getCreateddatetime());
			ps.setString(10, c.getCreatedbyip());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;		
	}	
	
	public static int updateCustomer(CustomerModel c) {
		int status = 0;
		try {
			
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("update TblCustomer set Customername=?,CustomerEmailID=?,CustomerContactNo=?,CustomerAddress=?,CustomerCity=?,CustomerState=?,CustomerCountry=?,fkRegID=?,CreatedDateTime=?,CreatedByIP=? where pkCustomerID=?");			
			ps.setString(1, c.getCustomername());
			ps.setString(2, c.getCustomeremailid());
			ps.setString(3, c.getCustomercontactno());
			ps.setString(4, c.getCustomeraddress());
			ps.setString(5, c.getCustomercity());
			ps.setString(6, c.getCustomerstate());
			ps.setString(7, c.getCustomercountry());
			ps.setInt(8, 9);					
			ps.setString(9, c.getCreateddatetime());
			ps.setString(10, c.getCreatedbyip());			
			ps.setInt(11, c.getPkcustomerid());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteCustomer(CustomerModel c) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("delete from TblCustomer where pkCustomerID=?");
			ps.setInt(1, c.getPkcustomerid()); // Customer ID becomes zero here and hence delete fails.
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<CustomerModel> getAllCustomers() {
		List<CustomerModel> listCustomer = new ArrayList<CustomerModel>();
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from TblCustomer");
			// where CustomerEmailID = (select EmailId from TblRegistration where
			// username=<login jsp>)
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				CustomerModel c = new CustomerModel();				
				c.setPkcustomerid(rs.getInt("pkcustomerid"));
				c.setCustomername(rs.getString("customername"));
				c.setCustomeremailid(rs.getString("customeremailid"));
				c.setCustomercontactno(rs.getString("customercontactno"));
				c.setCustomeraddress(rs.getString("customeraddress"));
				c.setCustomercity(rs.getString("customercity"));
				c.setCustomerstate(rs.getString("customerstate"));
				c.setCustomercountry(rs.getString("customercountry"));
				c.setFkregid(rs.getInt("fkregid"));
				c.setCreateddatetime(rs.getString("createddatetime"));
				c.setCreatedbyip(rs.getString("createdbyip"));				
				listCustomer.add(c);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listCustomer;
	}

	public static CustomerModel getCustomerByID(int Customerid) {

		CustomerModel c = null;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from TblCustomer where pkCustomerID=?");
			ps.setInt(1, Customerid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c = new CustomerModel();							
				c.setPkcustomerid(rs.getInt("pkcustomerid"));
				c.setCustomername(rs.getString("customername"));
				c.setCustomeremailid(rs.getString("customeremailid"));
				c.setCustomercontactno(rs.getString("customercontactno"));
				c.setCustomeraddress(rs.getString("customeraddress"));
				c.setCustomercity(rs.getString("customercity"));
				c.setCustomerstate(rs.getString("customerstate"));
				c.setCustomercountry(rs.getString("CustomerCountry"));
				c.setFkregid(rs.getInt("fkregid"));
				c.setCreateddatetime(rs.getString("createddatetime"));
				c.setCreatedbyip(rs.getString("createdbyip"));				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return c;
	}
	
}
