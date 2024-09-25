package com.test;

import java.util.Collection;
import java.util.HashSet;

import com.dao.HBDao;
import com.model.Students;
import com.model.Subjects;

public class Test 
{
	public static void main(String[] args) 
	{
		HBDao dao=new HBDao();
		
		Collection<Subjects> subjects=new HashSet<Subjects>();
		
		Subjects ss1=new Subjects();
		ss1.setSubname("Java");
		ss1.setDuration("5 Month");
		
		dao.addSubjects(ss1);
		Subjects ss2=new Subjects();
		ss2.setSubname("Software Testing");
		ss2.setDuration("3 Month");
		
		dao.addSubjects(ss2);
		
		subjects.add(ss1);
		subjects.add(ss2);
		
		Students s1=new Students();
		s1.setSname("Sanjay");
		s1.setCity("Daman");
		s1.setSubjects(subjects);
		
		dao.addStudent(s1);
		Students s2=new Students();
		s2.setSname("Prince");
		s2.setCity("ahmedabad");
		s2.setSubjects(subjects);
		
		dao.addStudent(s2);
		
		
	}
}
