package com.map;

import java.util.HashMap;
import java.util.Map;

public class mapdemo {
	public static void main(String[] args) {
		HashMap<Integer, String> hm=new HashMap<Integer, String>();
		hm.put(1, "java");
		hm.put(2, "PHP");
		hm.put(3, "Python");
		System.out.println("Key Value" );
		System.out.println("--- -----" );
		for(Map.Entry<Integer, String> h: hm.entrySet() ) {
			System.out.println(h.getKey() + "   " + h.getValue());
		}
		System.out.println("--- -----" );
	}
}
