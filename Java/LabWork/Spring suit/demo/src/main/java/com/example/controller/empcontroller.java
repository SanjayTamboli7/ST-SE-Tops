package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public class empcontroller {

	@GetMapping("/insert")
	public int datainsert() {
		int id=0;
		return id;
	}
	
	@GetMapping("/delete")
	public int delete() {
		int id=0;
		return id;
	}
	
	@GetMapping("/edit")
	public int edit() {
		int id=0;
		return id;
	}
	
	@GetMapping("/fetch")
	public List datafetch() {
		ArrayList al=null;
		return al;
	}
}
