package io.sudheer.springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CourseController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello ";
	}

}
