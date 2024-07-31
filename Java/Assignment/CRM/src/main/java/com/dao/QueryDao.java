package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.QueryModel;
import com.util.DBUtil;

public class QueryDao {

	public static int saveQuery(QueryModel q) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement(
					"insert into TblCustomerQuery (CustomerEmailID, Description, Suggestion, Response, fkResponseID, fkRegID, ResponseDate, CreatedDateTime, CreatedByIP) values (?,?,?,?,?,?,?,?,?)");
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
}
