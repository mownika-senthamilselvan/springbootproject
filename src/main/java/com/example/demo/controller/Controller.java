package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	//@RequestMapping(value="/",method=RequestMethod.GET)
	@GetMapping("/")
	public String helloController(){
		return "Welcome to the magical wrold ";
	}

}


