package com.test;

import com.dao.HBDao;
import com.model.Department;
import com.model.Employee;

public class Test 
{
	public static void main(String[] args) 
	{
		HBDao dao=new HBDao();
		
		Department d1=new Department();
		d1.setDname("Computer");
		d1.setDesg("Sr.Dev");
		
		dao.addDepartment(d1);
		
		Employee e1=new Employee();
		e1.setEname("Sanjay");
		e1.setCity("Daman");
		e1.setDept(d1);
		
		dao.addEmployee(e1);
		
		Employee e2=new Employee();
		e2.setEname("Prince");
		e2.setCity("ahmedabad");
		e2.setDept(d1);
		
		dao.addEmployee(e2);
	}
}
