package com.testproject.app.intro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class intro {
	
	@RequestMapping("/intro")	
	public String introduce() {
		return "Hello Guys, This is Manish";
	}
}
