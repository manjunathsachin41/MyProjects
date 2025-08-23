package com.example.constructor;

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

		PoeticJuggler poeticJuggler = (PoeticJuggler) ctx.getBean("poeticJuggler");
		poeticJuggler.perform();
		
		Performer saxaphonePerformer = (Performer) ctx.getBean("instrumentalistForSaxophone");
		saxaphonePerformer.perform();
		
		Performer pianoPerformer = (Performer) ctx.getBean("instrumentalistForPiano");
		pianoPerformer.perform();
		
		Performer saxaphoneAutowire = (Performer) ctx.getBean("instrumentalistForAutowire");
		saxaphoneAutowire.perform();
		
	}
}
