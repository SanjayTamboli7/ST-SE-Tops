package com.map;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Question {

	public int id;
	public String name;
	public Map<String, String> answers;

	public Question(int id, String name, Map<String, String> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}

	public void displayInfo() {
		System.out.println(id + " " + name);
		System.out.println(" answers are : ");

		Set<Entry<String, String>> set = answers.entrySet();
		Iterator<Entry<String, String>> itr = set.iterator();
		while (itr.hasNext()) {
			Entry<String, String> entry = itr.next();
			System.out.println("Answer:" + entry.getKey() + " Posted by:" + entry.getValue());
		}
	}
}
