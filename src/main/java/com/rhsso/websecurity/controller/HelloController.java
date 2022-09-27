package com.rhsso.websecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

	@GetMapping(path = "/")
	public String index() {
		return "homepage";
	}

	@GetMapping("/api")
	public String sayHello(@RequestParam(required = false,defaultValue = "Welcome ") String name, Principal principal) {
		return name+ principal.getName()+"!!  : You are successfully logged in";
	}

	@GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }
}
