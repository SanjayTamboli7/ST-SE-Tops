package com.tops;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Demo {
	public static void main(String[] args) {
		/* 
		 * boiler plate code -> code is required for the system and not required to the developer.
		 * application context file - bean tag use id
		 * xyz x=new xyz() // xyz is class and xyz() is constructor.
		 */
		try {
			
		Resource resource=new ClassPathResource("applicationContext.xml"); // This is interface. Interface has reference but does not have constructor 
		BeanFactory factory=new XmlBeanFactory(resource); 
		
		Student student=(Student) factory.getBean("studentbean");		
		student.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
