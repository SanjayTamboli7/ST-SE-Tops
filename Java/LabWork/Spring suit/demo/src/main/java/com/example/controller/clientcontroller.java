package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public class clientcontroller {
	@GetMapping("/clinsert")
	public int datainsertclient() {
		int id=0;
		return id;
	}
	
	@GetMapping("/cldelete")
	public int deleteclient() {
		int id=0;
		return id;
	}
	
	@GetMapping("/cledit")
	public int editclient() {
		int id=0;
		return id;
	}
	
	@GetMapping("/clfetch")
	public List datafetchclient() {
		ArrayList al=null;
		return al;
	}
}
