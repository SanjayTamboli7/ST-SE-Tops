package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.model.FeedbackModel;
import com.util.DBUtil;

public class FeedbackDao {

	public int saveFeedback(FeedbackModel f) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement(
					"insert into tblcustomerfeedback (CustomerEmailID,Description,Suggestion,fkRegID,CreatedDateTime,CreatedByIP) values (?,?,?,?,?,?)");
			ps.setString(1, f.getCustomeremailid());
			ps.setString(2, f.getDescription());
			ps.setString(3, f.getSuggestion());
			ps.setInt(4, f.getFkregid());
			ps.setString(5, f.getCreateddatetime());
			ps.setString(6, f.getCreatedbyip());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int updateFeedback(FeedbackModel f) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement(
					"update tblcustomerfeedback set CustomerEmailID=?,Description=?,Suggestion=?,fkRegID=?,CreatedDateTime=?,CreatedByIP=? where pkFeedbackID=?");
			ps.setString(1, f.getCustomeremailid());
			ps.setString(2, f.getDescription());
			ps.setString(3, f.getSuggestion());
			ps.setInt(4, f.getFkregid());
			ps.setString(5, f.getCreateddatetime());
			ps.setString(6, f.getCreatedbyip());
			ps.setInt(7, f.getPkfeedbackid());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteFeedback(FeedbackModel f) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("delete from tblcustomerfeedback where pkFeedbackID=?");
			ps.setInt(1, f.getPkfeedbackid());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static List<FeedbackModel> getAllFeedbacks() {
		List<FeedbackModel> listfeedback = new ArrayList<FeedbackModel>();
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from tblcustomerfeedback");
			// where CustomerEmailID = (select EmailId from TblRegistration where
			// username=<login jsp>)
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FeedbackModel f = new FeedbackModel();
				f.setPkfeedbackid(rs.getInt("pkfeedbackid"));
				f.setCustomeremailid(rs.getString("customeremailid"));
				f.setDescription(rs.getString("description"));
				f.setSuggestion(rs.getString("Suggestion"));
				f.setFkregid(rs.getInt("fkregid"));
				f.setCreateddatetime(rs.getString("createddatetime"));
				f.setCreatedbyip(rs.getString("createdbyip"));
				listfeedback.add(f);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listfeedback;
	}

	public static FeedbackModel getFeedbackByID(int feedbackid) {

		FeedbackModel f = null;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from tblcustomerfeedback where pkfeedbackid=?");
			ps.setInt(1, feedbackid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				f = new FeedbackModel();
				f.setPkfeedbackid(rs.getInt("pkfeedbackid"));
				f.setCustomeremailid(rs.getString("customeremailid"));
				f.setDescription(rs.getString("description"));
				f.setSuggestion(rs.getString("Suggestion"));
				f.setFkregid(rs.getInt("fkregid"));
				f.setCreateddatetime(rs.getString("createddatetime"));
				f.setCreatedbyip(rs.getString("createdbyip"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}

}
