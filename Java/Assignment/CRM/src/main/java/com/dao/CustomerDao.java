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
			PreparedStatement ps = cn.prepareStatement("insert into TblCustomer (CustomerName,CustomerEmailID,CustomerContactNo,CustomerAddress,CustomerCity,CustomerState,CustomerCountry,fkRegID,CreatedDateTime,CreatedByIP) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerEmailID());
			ps.setString(3, c.getCustomerContactNo());
			ps.setString(4, c.getCustomerAddress());
			ps.setString(5, c.getCustomerCity());
			ps.setString(6, c.getCustomerState());
			ps.setString(7, c.getCustomerCountry());
			ps.setInt(8, c.getFkRegID());					
			ps.setString(9, c.getCreatedDateTime());
			ps.setString(10, c.getCreatedByIP());
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
			PreparedStatement ps = cn.prepareStatement("update TblCustomer set CustomerName=?,CustomerEmailID=?,CustomerContactNo=?,CustomerAddress=?,CustomerCity=?,CustomerState=?,CustomerCountry=?,fkRegID=?,CreatedDateTime=?,CreatedByIP=? where pkCustomerID=?");			
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerEmailID());
			ps.setString(3, c.getCustomerContactNo());
			ps.setString(4, c.getCustomerAddress());
			ps.setString(5, c.getCustomerCity());
			ps.setString(6, c.getCustomerState());
			ps.setString(7, c.getCustomerCountry());
			ps.setInt(8, c.getFkRegID());					
			ps.setString(9, c.getCreatedDateTime());
			ps.setString(10, c.getCreatedByIP());
			ps.setInt(11, c.getPkCustomerID());
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
			ps.setInt(1, c.getPkCustomerID()); // Customer ID becomes zero here and hence delete fails.
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
				c.setPkCustomerID(rs.getInt("pkCustomerID"));
				c.setCustomerName(rs.getString("CustomerName"));
				c.setCustomerEmailID(rs.getString("CustomerEmailID"));
				c.setCustomerContactNo(rs.getString("CustomerContactNo"));
				c.setCustomerAddress(rs.getString("CustomerAddress"));
				c.setCustomerCity(rs.getString("CustomerCity"));
				c.setCustomerState(rs.getString("CustomerState"));
				c.setCustomerCountry(rs.getString("CustomerCountry"));
				c.setFkRegID(rs.getInt("fkRegID"));
				c.setCreatedDateTime(rs.getString("CreatedDateTime"));
				c.setCreatedByIP(rs.getString("CreatedByIP"));				
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
				c.setPkCustomerID(rs.getInt("pkCustomerID"));
				c.setCustomerName(rs.getString("CustomerName"));
				c.setCustomerEmailID(rs.getString("CustomerEmailID"));
				c.setCustomerContactNo(rs.getString("CustomerContactNo"));
				c.setCustomerAddress(rs.getString("CustomerAddress"));
				c.setCustomerCity(rs.getString("CustomerCity"));
				c.setCustomerState(rs.getString("CustomerState"));
				c.setCustomerCountry(rs.getString("CustomerCountry"));
				c.setFkRegID(rs.getInt("fkRegID"));
				c.setCreatedDateTime(rs.getString("CreatedDateTime"));
				c.setCreatedByIP(rs.getString("CreatedByIP"));				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return c;
	}
	
}
