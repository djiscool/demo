package com.dj.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FRestController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello World!";
	}
}
