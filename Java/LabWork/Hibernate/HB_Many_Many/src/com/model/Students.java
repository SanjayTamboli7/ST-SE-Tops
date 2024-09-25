package com.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="Students")
public class Students 
{
	private int sid;
	private String sname,city;
	Collection<Subjects> subjects;
	@Id
	@GenericGenerator(name = "increment",strategy = "increment")
	@GeneratedValue(generator = "increment")
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@ManyToMany
	@JoinTable(
			name="stud_sub",
			joinColumns = @JoinColumn(name="sid"),
			inverseJoinColumns = @JoinColumn(name="subid"))
	public Collection<Subjects> getSubjects() {
		return subjects;
	}
	public void setSubjects(Collection<Subjects> subjects) {
		this.subjects = subjects;
	}
	
}
