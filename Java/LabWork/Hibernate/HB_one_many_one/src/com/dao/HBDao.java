package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Department;
import com.model.Employee;
import com.util.HButil;

public class HBDao 
{
	Session session=null;
	Transaction tx=null;
	public void addEmployee(Employee e1)
	{
		session=new HButil().getSessionData();
		tx=session.beginTransaction();
		session.save(e1);
		tx.commit();
		session.close();
		System.out.println("Employee Record inserted...");
	}
	public void addDepartment(Department d1)
	{
		session=new HButil().getSessionData();
		tx=session.beginTransaction();
		session.save(d1);
		tx.commit();
		session.close();
		System.out.println("Department REcord inserted...");
	}
}
