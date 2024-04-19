package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		HashMap hm = new HashMap() ;
		System.out.println("Default size = " + hm.size());
		System.out.println("Default value = " + hm);
		hm.put(1,  "Rahul") ;
		hm.put(45.65f,  "float") ;
		hm.put("double",  456456.65) ;
		hm.put("Rahul", 4321) ;
		System.out.println("New Default size = " + hm.size());
		System.out.println("New Default value = " + hm);
		hm.put(1,  "Sanjay") ;
		hm.put("Rahul", 4321) ;
		System.out.println("New Default size = " + hm.size());
		System.out.println("New Default value = " + hm);
		hm.remove("Rahul") ;
		System.out.println("New Default size = " + hm.size());
		System.out.println("New Default value = " + hm);
		@SuppressWarnings("rawtypes")
		Set set = hm.entrySet();
		Iterator i1=(Iterator) set.spliterator();
		while (i1.hasNext()) {
			
//			Map.entry me = (Map.Entry)i1.hasNext();
//			System.out.println("Key = " + me.getKey()) ;
//			System.out.println("Value = " + me.getVallue());
//			System.out.println();
			
			String str = i1.next().toString();
			String[] s = str.split("=");
			System.out.println("Key = " + s[0]);
			System.out.println("Value = " + s[1]);
			System.out.println();
		}				
	}
}
