package com.example.SpringAutowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Developer {

	// Field Injection
	//@Autowired
	Computer computer;

	// Construction Injection
	//@Autowired
	//  Developer(Computer computer) { 
	  //	this.computer = computer; 
	  //}
	  
	 

	
	  //  Setter Injection
	  @Autowired
	  @Qualifier("laptop")
	  public void setComputer(Computer computer) { 
		  this.computer = computer; 
	  }
	 

	public void callDev() {
		computer.compile();
	}

}
