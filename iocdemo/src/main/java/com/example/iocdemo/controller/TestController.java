package com.example.iocdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iocdemo.service.TestService;

@RestController
public class TestController {
 
	
	
  // field injection
// @Autowired
 TestService ts;
	
 // TestService ts = new TestService();
   
	//tells spring to use constructor injection 
//    @Autowired
//	public TestController(TestService ts) {
//	this.ts = ts;
//	System.out.println("instantiation through constructor"+ts);
//}

 
	@GetMapping(path="/hello")
	 public String hello() {
	  
		//return "Hello!!
		
		return ts.getHello();
	 }

	public TestService getTs() {
		return ts;
	}
	
	@Autowired
	public void setTs(TestService ts) {
		this.ts = ts;
		System.out.println("instantiation through setter call "+ts);
	}
	
}
