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
			ps.setString(1, q.getCustomeremailid());
			ps.setString(2, q.getDescription());
			ps.setString(3, q.getSuggestion());
			ps.setString(4, q.getResponse());
			ps.setInt(5,    q.getFkresponseid());
			ps.setInt(6,    q.getFkregid());
			ps.setString(7, q.getResponsedate());
			ps.setString(8, q.getCreateddatetime());
			ps.setString(9, q.getCreatedbyip());
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
			ps.setString(1, q.getCustomeremailid());
			ps.setString(2, q.getDescription());
			ps.setString(3, q.getSuggestion());
			ps.setString(4, q.getResponse());
			ps.setInt(5,    q.getFkresponseid());
			ps.setInt(6,    q.getFkregid());
			ps.setString(7, q.getResponsedate());
			ps.setString(8, q.getCreateddatetime());
			ps.setString(9, q.getCreatedbyip());
			ps.setInt(10, q.getPkqueryid());
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
			ps.setInt(1, q.getPkqueryid());
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
				q.setPkqueryid(rs.getInt("pkqueryid"));
				q.setCustomeremailid(rs.getString("customeremailid"));
				q.setDescription(rs.getString("description"));								
				q.setSuggestion(rs.getString("suggestion"));
				q.setResponse(rs.getString("response"));
				q.setResponsedate(rs.getString("responsedate"));
				q.setFkresponseid(rs.getInt("fkresponseid"));				
				q.setFkregid(rs.getInt("fkRegID"));				
				q.setCreateddatetime(rs.getString("CreatedDateTime"));
				q.setCreatedbyip(rs.getString("CreatedByIP"));
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
				q.setPkqueryid(rs.getInt("pkqueryid"));
				q.setCustomeremailid(rs.getString("customeremailid"));
				q.setDescription(rs.getString("description"));								
				q.setSuggestion(rs.getString("suggestion"));
				q.setResponse(rs.getString("response"));
				q.setResponsedate(rs.getString("responsedate"));
				q.setFkresponseid(rs.getInt("fkresponseid"));				
				q.setFkregid(rs.getInt("fkRegID"));				
				q.setCreateddatetime(rs.getString("CreatedDateTime"));
				q.setCreatedbyip(rs.getString("CreatedByIP"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return q;
	}
	
}
