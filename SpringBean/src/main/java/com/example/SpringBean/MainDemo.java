package com.example.SpringBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDemo {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/example/SpringBean/SpringDefinitions.xml");
		Performer performer = (Performer) ctx.getBean("dukeOne");
		performer.perform();
		
		Performer performeMany = (Performer) ctx.getBean("dukeMany");
		performeMany.perform();
	}

}
