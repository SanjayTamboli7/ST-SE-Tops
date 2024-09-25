package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public class companycontroller {

	@GetMapping("/cominsert")
	public int datainsertcompany() {
		int id=0;
		return id;
	}
	
	@GetMapping("/comdelete")
	public int deletecompany() {
		int id=0;
		return id;
	}
	
	@GetMapping("/comedit")
	public int editcompany() {
		int id=0;
		return id;
	}
	
	@GetMapping("/comfetch")
	public List datafetchcompany() {
		ArrayList al=null;
		return al;
	}

}
