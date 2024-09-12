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

			ps.setString(1, p.getProjectname());
			ps.setString(2, p.getProjectdescription());
			ps.setInt(3, p.getFkcustomerid());
			ps.setInt(4, p.getProjectduration());
			ps.setString(5, p.getProjectstartdate());
			ps.setString(6, p.getProjectenddate());
			ps.setInt(7, p.getProjectcost());
			ps.setString(8, p.getProjectremarks());
			ps.setString(9, p.getProjectstatus());
			ps.setInt(10, p.getFkregid());
			ps.setString(11, p.getCustomerreview());						
			ps.setString(12, p.getCreateddatetime());
			ps.setString(13, p.getCreatedbyip());
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

			ps.setString(1, p.getProjectname());
			ps.setString(2, p.getProjectdescription());
			ps.setInt(3, p.getFkcustomerid());
			ps.setInt(4, p.getProjectduration());
			ps.setString(5, p.getProjectstartdate());
			ps.setString(6, p.getProjectenddate());
			ps.setInt(7, p.getProjectcost());
			ps.setString(8, p.getProjectremarks());
			ps.setString(9, p.getProjectstatus());
			ps.setInt(10, p.getFkregid());
			ps.setString(11, p.getCustomerreview());						
			ps.setString(12, p.getCreateddatetime());
			ps.setString(13, p.getCreatedbyip());
			ps.setInt(14, p.getPkprojectid());

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
			ps.setInt(1, p.getPkprojectid());
			status = ps.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

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
				p.setPkprojectid(rs.getInt("pkprojectid"));
				p.setProjectname(rs.getString("projectname"));
				p.setProjectdescription(rs.getString("projectdescription"));
				p.setFkcustomerid(rs.getInt("fkcustomerid"));
				p.setProjectduration(rs.getInt("projectduration"));
				p.setProjectstartdate(rs.getString("projectstartdate"));
				p.setProjectenddate(rs.getString("projectenddate"));
				p.setProjectcost(rs.getInt("projectcost"));
				p.setProjectremarks(rs.getString("projectremarks"));
				p.setProjectstatus(rs.getString("projectstatus"));
				p.setFkregid(rs.getInt("fkregid"));
				p.setCustomerreview(rs.getString("customerreview"));
				p.setCreateddatetime(rs.getString("createddatetime"));
				p.setCreatedbyip(rs.getString("createdbyip"));				
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

				p.setPkprojectid(rs.getInt("pkprojectid"));
				p.setProjectname(rs.getString("projectname"));
				p.setProjectdescription(rs.getString("projectdescription"));
				p.setFkcustomerid(rs.getInt("fkcustomerid"));
				p.setProjectduration(rs.getInt("projectduration"));
				p.setProjectstartdate(rs.getString("projectstartdate"));
				p.setProjectenddate(rs.getString("projectenddate"));
				p.setProjectcost(rs.getInt("projectcost"));
				p.setProjectremarks(rs.getString("projectremarks"));
				p.setProjectstatus(rs.getString("projectstatus"));
				p.setFkregid(rs.getInt("fkregid"));
				p.setCustomerreview(rs.getString("customerreview"));
				p.setCreateddatetime(rs.getString("createddatetime"));
				p.setCreatedbyip(rs.getString("createdbyip"));								
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return p;
	}
	
}
