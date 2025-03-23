package com.example.doc.hms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Doctormas {
	
	protected Doctormas() {
		
	}

	@Id
	@GeneratedValue
	private Integer doctor_id;
	
	private String doctor_name;
	
	private String doctor_speciality;

	public Doctormas(Integer doctor_id, String doctor_name, String doctor_speciality) {
		super();
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.doctor_speciality = doctor_speciality;
	}

	public Integer getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDoctor_speciality() {
		return doctor_speciality;
	}

	public void setDoctor_speciality(String doctor_speciality) {
		this.doctor_speciality = doctor_speciality;
	}

	@Override
	public String toString() {
		return "Doctormas [doctor_id=" + doctor_id + ", doctor_name=" + doctor_name + ", doctor_speciality="
				+ doctor_speciality + "]";
	}
	
	
}
