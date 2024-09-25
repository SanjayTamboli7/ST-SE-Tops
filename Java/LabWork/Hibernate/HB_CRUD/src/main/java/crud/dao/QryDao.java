package crud.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import crud.model.QueryModel;
import crud.util.HButil;


public class QryDao {

	Session session=null;
	static Transaction tx=null;

	public String queryRegistration(QueryModel rmodel)
	{
		String msg="";
		try {
			session=new HButil().getSessionData();
			tx=session.beginTransaction();
			session.save(rmodel);
			tx.commit();
			session.close();
			msg="Ok";						
		} catch (Exception e)
		{
			msg="Fail";
			e.printStackTrace();
		}
		return msg;
	}

	public int updateQuery(QueryModel hmodel)
	{
		int x=0;
		try {
			session=new HButil().getSessionData();
			tx=session.beginTransaction();		
			Query q=session.createQuery("update QueryModel u set u.CustomerEmailID=?0,u.Description=?1,u.Suggestion=?2 where u.pkQueryID=?3");
			q.setString(0, hmodel.getCustomeremailid());
			q.setString(1, hmodel.getDescription());
			q.setString(2, hmodel.getSuggestion());
			q.setInteger(3, hmodel.getPkqueryid());
			x=q.executeUpdate();
			tx.commit();
			session.close();
		} catch(Exception e) {
			x=0;
			e.printStackTrace();
		}
		return x;
	}
	
	public int deleteQuery(int QueryID)
	{
		int x=0;
		try {
			session=new HButil().getSessionData();
			tx=session.beginTransaction();
			Query q=session.createQuery("delete from QueryModel u where u.pkQueryID=?0");
			q.setInteger(0, QueryID);
			x=q.executeUpdate();
			tx.commit();
			session.close();
		} catch(Exception e) {
			x=0;
			e.printStackTrace();
		}
		return x;		
	}	

	public static List<QueryModel> getAllQueries() {
		int x=0;
		List<QueryModel> listRegistration = new ArrayList<QueryModel>();
		try {
			Session session = null;
			session=new HButil().getSessionData();
			tx=session.beginTransaction();
			/* Query q=session.createQuery("select from QueryModel u"); */			
			Query q=session.createQuery("from QueryModel");			
			x=q.executeUpdate();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listRegistration;
	}
	
}
