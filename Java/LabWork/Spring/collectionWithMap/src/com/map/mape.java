package com.map;

import java.util.HashMap;
import java.util.Map;

public class mape {
	public static void main(String[] args) {

		demo d=new demo(2, "java", "java@gmail.com");
		demo d1=new demo(3, "java1", "java1@gmail.com");
		demo d2=new demo(4, "java2", "java2@gmail.com");
		
		HashMap<Integer, demo> s=new HashMap<Integer, demo>();
		
		s.put(1, d);
		s.put(2, d1);
		s.put(3, d2);
		
		System.out.println("Display Optio 1");
		for(Map.Entry<Integer, demo> j:  s.entrySet()) {
			
			int a=j.getKey();
			demo k=j.getValue();
			
			System.out.println(a + " " + k.id1 + " " + k.name1 + " " + k.email1);
		}

		System.out.println("Display Optio 2");
		for(Map.Entry<Integer, demo> j:  s.entrySet()) {
					
			System.out.println(j.getKey() + " " + j.getValue().id1 + " " + j.getValue().name1 + " " + j.getValue().email1);
		}
	}
}
