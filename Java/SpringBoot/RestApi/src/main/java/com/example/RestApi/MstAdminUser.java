package com.example.RestApi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "mstadmin_user")
public class MstAdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auser_id;

    @NotEmpty(message = "Name is required")
    private String auser_name;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    private String auser_email_id;

    @NotEmpty(message = "Contact number is required")
    private String auser_contact_no;

    @NotEmpty(message = "Password is required")
    private String auser_password;

    private int auser_status = 1;

    private String last_edit_date_time;

	public Long getAuser_id() {
		return auser_id;
	}

	public void setAuser_id(Long auser_id) {
		this.auser_id = auser_id;
	}

	public String getAuser_name() {
		return auser_name;
	}

	public void setAuser_name(String auser_name) {
		this.auser_name = auser_name;
	}

	public String getAuser_email_id() {
		return auser_email_id;
	}

	public void setAuser_email_id(String auser_email_id) {
		this.auser_email_id = auser_email_id;
	}

	public String getAuser_contact_no() {
		return auser_contact_no;
	}

	public void setAuser_contact_no(String auser_contact_no) {
		this.auser_contact_no = auser_contact_no;
	}

	public String getAuser_password() {
		return auser_password;
	}

	public void setAuser_password(String auser_password) {
		this.auser_password = auser_password;
	}

	public int getAuser_status() {
		return auser_status;
	}

	public void setAuser_status(int auser_status) {
		this.auser_status = auser_status;
	}

	public String getLast_edit_date_time() {
		return last_edit_date_time;
	}

	public void setLast_edit_date_time(String last_edit_date_time) {
		this.last_edit_date_time = last_edit_date_time;
	}
    
}
