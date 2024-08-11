package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.model.ProjectModel;
import com.util.DBUtil;

public class ProjectDao {

	public int saveProject(ProjectModel p) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement(
					"insert into TblProject (ProjectName,ProjectDescription,fkCustomerID,ProjectDuration,ProjectStartDate,ProjectEndDate,ProjectCost,ProjectRemarks,ProjectStatus,fkRegID,CustomerReview,CreatedDateTime,CreatedByIP) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//                               ProjectName,ProjectDescription,fkCustomerID,ProjectDuration,ProjectStartDate,ProjectEndDate,ProjectCost,ProjectRemarks,ProjectStatus,fkRegID,CustomerReview,CreatedDateTime,CreatedByIP

			ps.setString(1, p.getProjectName());
			ps.setString(2, p.getProjectDescription());
			ps.setInt(3, p.getFkCustomerID());
			ps.setInt(4, p.getProjectDuration());
			ps.setString(5, p.getProjectStartDate());
			ps.setString(6, p.getProjectEndDate());
			ps.setInt(7, p.getProjectCost());
			ps.setString(8, p.getProjectRemarks());
			ps.setString(9, p.getProjectStatus());
			ps.setInt(10, p.getFkRegID());
			ps.setString(11, p.getCustomerReview());						
			ps.setString(12, p.getCreatedDateTime());
			ps.setString(13, p.getCreatedByIP());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;		
	}	
	
	public static int updateProject(ProjectModel p) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("update TblProject set ProjectName=?,ProjectDescription=?,fkCustomerID=?,ProjectDuration=?,ProjectStartDate=?,ProjectEndDate=?,ProjectCost=?,ProjectRemarks=?,ProjectStatus=?,fkRegID=?,CustomerReview=?,CreatedDateTime=?,CreatedByIP=? where pkProjectID=?");			
			ps.setString(1, p.getProjectName());
			ps.setString(2, p.getProjectDescription());
			ps.setInt(3, p.getFkCustomerID());
			ps.setInt(4, p.getProjectDuration());
			ps.setString(5, p.getProjectStartDate());
			ps.setString(6, p.getProjectEndDate());
			ps.setInt(7, p.getProjectCost());
			ps.setString(8, p.getProjectRemarks());
			ps.setString(9, p.getProjectStatus());
			ps.setInt(10, p.getFkRegID());
			ps.setString(11, p.getCustomerReview());						
			ps.setString(12, p.getCreatedDateTime());
			ps.setString(13, p.getCreatedByIP());
			ps.setInt(14, p.getPkProjectID());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteProject(ProjectModel p) {
		int status = 0;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("delete from TblProject where pkProjectID=?");
			ps.setInt(1, p.getPkProjectID());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
//	Start from here
	public static List<ProjectModel> getAllProjects() {
		List<ProjectModel> listProject = new ArrayList<ProjectModel>();
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from TblProject");
			// where CustomerEmailID = (select EmailId from TblRegistration where
			// username=<login jsp>)
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProjectModel p = new ProjectModel();
				p.setPkProjectID(rs.getInt("pkProjectID"));
				p.setProjectName(rs.getString("ProjectName"));
				p.setProjectDescription(rs.getString("ProjectDescription"));
				p.setFkCustomerID(rs.getInt("fkCustomerID"));
				p.setProjectDuration(rs.getInt("ProjectDuration"));
				p.setProjectStartDate(rs.getString("ProjectStartDate"));
				p.setProjectEndDate(rs.getString("ProjectEndDate"));
				p.setProjectCost(rs.getInt("ProjectCost"));
				p.setProjectRemarks(rs.getString("ProjectRemarks"));
				p.setProjectStatus(rs.getString("ProjectStatus"));
				p.setFkRegID(rs.getInt("fkRegID"));
				p.setCustomerReview(rs.getString("CustomerReview"));
				p.setCreatedDateTime(rs.getString("CreatedDateTime"));
				p.setCreatedByIP(rs.getString("CreatedByIP"));				
				listProject.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listProject;
	}

	public static ProjectModel getProjectByID(int Projectkid) {

		ProjectModel p = null;
		try {
			Connection cn = null;
			cn = new DBUtil().getConnectionData();
			PreparedStatement ps = cn.prepareStatement("select * from TblProject where pkProjectID=?");
			ps.setInt(1, Projectkid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new ProjectModel();				
				p.setPkProjectID(rs.getInt("pkProjectID"));
				p.setProjectName(rs.getString("ProjectName"));
				p.setProjectDescription(rs.getString("ProjectDescription"));
				p.setFkCustomerID(rs.getInt("fkCustomerID"));
				p.setProjectDuration(rs.getInt("ProjectDuration"));
				p.setProjectStartDate(rs.getString("ProjectStartDate"));
				p.setProjectEndDate(rs.getString("ProjectEndDate"));
				p.setProjectCost(rs.getInt("ProjectCost"));
				p.setProjectRemarks(rs.getString("ProjectRemarks"));
				p.setProjectStatus(rs.getString("ProjectStatus"));
				p.setFkRegID(rs.getInt("fkRegID"));
				p.setCustomerReview(rs.getString("CustomerReview"));
				p.setCreatedDateTime(rs.getString("CreatedDateTime"));
				p.setCreatedByIP(rs.getString("CreatedByIP"));				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return p;
	}
	
}
