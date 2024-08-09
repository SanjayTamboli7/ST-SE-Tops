package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.model.QueryModel;
import com.util.DBUtil;

public class QueryDao {

	public int saveQuery(QueryModel q) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement(
					"insert into TblCustomerQuery (CustomerEmailID,Description,Suggestion,Response,fkResponseID,fkRegID,ResponseDate,CreatedDateTime,CreatedByIP) values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, q.getCustomerEmailID());
			ps.setString(2, q.getDescription());
			ps.setString(3, q.getSuggestion());
			ps.setString(4, q.getResponse());
			ps.setInt(5,    q.getFkResponseID());
			ps.setInt(6,    q.getFkRegID());
			ps.setString(7, q.getResponseDate());
			ps.setString(8, q.getCreatedDateTime());
			ps.setString(9, q.getCreatedByIP());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;		
	}	
	
	public static int updateQuery(QueryModel q) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("update TblCustomerQuery set CustomerEmailID=?,Description=?,Suggestion=?,Response=?,fkResponseID=?,fkRegID=?,ResponseDate=?,CreatedDateTime=?,CreatedByIP=? where pkQueryID=?");			
			ps.setString(1, q.getCustomerEmailID());
			ps.setString(2, q.getDescription());
			ps.setString(3, q.getSuggestion());
			ps.setString(4, q.getResponse());
			ps.setInt(5,    q.getFkResponseID());
			ps.setInt(6,    q.getFkRegID());
			ps.setString(7, q.getResponseDate());
			ps.setString(8, q.getCreatedDateTime());
			ps.setString(9, q.getCreatedByIP());
			ps.setInt(10, q.getPkQueryID());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteQuery(QueryModel q) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("delete from TblCustomerQuery where pkQueryID=?");
			ps.setInt(1, q.getPkQueryID());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<QueryModel> getAllQueries() {
		List<QueryModel> listQuery = new ArrayList<QueryModel>();
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from tblcustomerQuery");
			// where CustomerEmailID = (select EmailId from TblRegistration where
			// username=<login jsp>)
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				QueryModel q = new QueryModel();
				q.setPkQueryID(rs.getInt("pkqueryid"));
				q.setCustomerEmailID(rs.getString("customeremailid"));
				q.setDescription(rs.getString("description"));								
				q.setSuggestion(rs.getString("suggestion"));
				q.setResponse(rs.getString("response"));
				q.setFkResponseID(rs.getInt("fkresponseid"));				
				q.setFkRegID(rs.getInt("fkregid"));				
				q.setCreatedDateTime(rs.getString("createddatetime"));
				q.setCreatedByIP(rs.getString("createdbyip"));
				listQuery.add(q);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listQuery;
	}

	public static QueryModel getQueryByID(int querykid) {

		QueryModel q = null;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from TblCustomerQuery where pkQueryID=?");
			ps.setInt(1, querykid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				q = new QueryModel();				
				q.setPkQueryID(rs.getInt("pkqueryid"));
				q.setCustomerEmailID(rs.getString("customeremailid"));
				q.setDescription(rs.getString("description"));								
				q.setSuggestion(rs.getString("suggestion"));
				q.setResponse(rs.getString("response"));
				q.setFkResponseID(rs.getInt("fkresponseid"));				
				q.setFkRegID(rs.getInt("fkregid"));				
				q.setCreatedDateTime(rs.getString("createddatetime"));
				q.setCreatedByIP(rs.getString("createdbyip"));				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return q;
	}
	
}
