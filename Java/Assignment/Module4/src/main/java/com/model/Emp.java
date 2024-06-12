package com.model;

import java.sql.Date;
import java.time.LocalDate;

public class Emp {

	private int Empno, Mgr, Deptno;
	private String Ename, Job;
	private LocalDate Hiredate;
	private float Sal, Comm;
	public int getEmpno() {
		return Empno;
	}
	public void setEmpno(int empno) {
		Empno = empno;
	}
	public int getMgr() {
		return Mgr;
	}
	public void setMgr(int mgr) {
		Mgr = mgr;
	}
	public int getDeptno() {
		return Deptno;
	}
	public void setDeptno(int deptno) {
		Deptno = deptno;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public LocalDate getHiredate() {
		return Hiredate;
	}
	public void setHiredate(LocalDate hiredate) {
		Hiredate = hiredate;
	}
	public float getSal() {
		return Sal;
	}
	public void setSal(float sal) {
		Sal = sal;
	}
	public float getComm() {
		return Comm;
	}
	public void setComm(float comm) {
		Comm = comm;
	}
	public void setHiredate(Date date) {
		// TODO Auto-generated method stub
		
	}

}
