package io.sudheer.springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CourseController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		sleep10secs();
		return "Hello!!";
	}
	
	public void sleep10secs() {
		try {
			System.out.println("Sleeping for 2 seconds");
			 Thread.sleep(2000);
			System.out.println("Sleep finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
