package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Students;
import com.model.Subjects;
import com.util.HButil;

public class HBDao 
{
	Session session=null;
	Transaction tx=null;
	public void addStudent(Students s1)
	{
		session=new HButil().getSessionData();
		tx=session.beginTransaction();
		session.save(s1);
		tx.commit();
		session.close();
		System.out.println("Student Record inserted...");
	}
	public void addSubjects(Subjects ss1)
	{
		session=new HButil().getSessionData();
		tx=session.beginTransaction();
		session.save(ss1);
		tx.commit();
		session.close();
		System.out.println("Subjects REcord inserted...");
	}
}
