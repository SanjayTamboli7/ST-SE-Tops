package com.konst;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {
		try {
			
		Resource resource=new ClassPathResource("applicationContext.xml"); // This is interface. Interface has reference but does not have constructor 
		BeanFactory factory=new XmlBeanFactory(resource); 
		
		Emp e=(Emp) factory.getBean("e");		
		e.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
