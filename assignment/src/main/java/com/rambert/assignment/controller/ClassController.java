package com.rambert.assignment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController
{

	@RequestMapping("/")
	public String helloClass()
	{
		return "Hello class";
	}
}
