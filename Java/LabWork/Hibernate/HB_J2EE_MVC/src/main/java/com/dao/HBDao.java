package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.UserModel;
import com.util.HButil;

public class HBDao {
	Session session=null;
	Transaction tx=null;
	
	public String userRegistration(UserModel rmodel)
	{
		String msg="";
		try {
			session=new HButil().getSessionData();
			tx=session.beginTransaction();
			session.save(rmodel);
			tx.commit();
			session.close();
			msg="Registration successfull...";
			
			
		} catch (Exception e)
		{
			msg="error";
			e.printStackTrace();
		}
		return msg;
	}
	public UserModel userLogin(UserModel lmodel) 
	{
		UserModel model=null;		
		try {
			session=new HButil().getSessionData();
			tx=session.beginTransaction();
			Query q=session.createQuery("from UserModel u where u.username=:username and u.password=:password");
			q.setParameter("username", lmodel.getUsername());
			q.setParameter("password", lmodel.getPassword());
			
			List<UserModel> umodel=q.list();
			model=umodel.get(0);
			tx.commit();
			session.close();
			
		} catch(Exception e) {
			model=null;
			e.printStackTrace();
		}
		return model;
	}
	@SuppressWarnings("deprecation")
	public UserModel verifyuserLogin(int userid) {
		UserModel model=null;		
		try {
			session=new HButil().getSessionData();
			tx=session.beginTransaction();
			
			Query q=session.createQuery("from UserModel u where u.userid=:userid");
			q.setParameter("userid", userid);
			
			List<UserModel> umodel=q.list();
			model=umodel.get(0);
			tx.commit();
			session.close();
			
		} catch(Exception e) {
			model=null;
			e.printStackTrace();
		}
		return model;
	}

	@SuppressWarnings("deprecation")
	public int updateUser(UserModel hmodel)
	{
		int x=0;
		try {
			session=new HButil().getSessionData();
			tx=session.beginTransaction();
			Query q=session.createQuery("update UserModel u set u.firstname=?0,u.lastname=?1,u.username=?2,u.password=?3 where u.userid=?4");
			q.setString(0, hmodel.getFirstname());
			q.setString(1, hmodel.getLastname());
			q.setString(2, hmodel.getUsername());
			q.setString(3, hmodel.getPassword());
			q.setInteger(4, hmodel.getUserid());
			x=q.executeUpdate();
			tx.commit();
			session.close();
		} catch(Exception e) {
			x=0;
			e.printStackTrace();
		}
		return x;
	}
	
	@SuppressWarnings("deprecation")
	public int deleteUser(int userid)
	{
		int x=0;
		try {
			session=new HButil().getSessionData();
			tx=session.beginTransaction();
			Query q=session.createQuery("delete from UserModel u where u.userid=?0");
			q.setInteger(0, userid);
			x=q.executeUpdate();
			tx.commit();
			session.close();
		} catch(Exception e) {
			x=0;
			e.printStackTrace();
		}
		return x;
		
	}
}
