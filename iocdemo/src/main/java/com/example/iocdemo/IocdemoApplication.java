package com.example.iocdemo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.iocdemo.controller.TestController;
import com.example.iocdemo.service.TestService;

//Java express - springboot How to create application context 

@SpringBootApplication
public class IocdemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(IocdemoApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(IocdemoApplication.class, args);
	
        TestController tc=context.getBean(TestController.class);
        TestService ts= context.getBean(TestService.class);
		
		 System.out.println(tc.hello());
		 System.out.println(ts.getHello());
	}

}
