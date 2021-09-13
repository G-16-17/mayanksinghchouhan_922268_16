package com.cognizant.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/Hello")
	public String getData() {
		return "Hello World !";
	}
}
