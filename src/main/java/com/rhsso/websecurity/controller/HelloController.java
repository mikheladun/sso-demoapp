package com.rhsso.websecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {
	
	@GetMapping("/api")
	public String sayHello(@RequestParam(required = false,defaultValue = "Welcome ") String name, Principal principal) {
		return name+ principal.getName()+"!!  : You are successfully logged in";
	}
}
