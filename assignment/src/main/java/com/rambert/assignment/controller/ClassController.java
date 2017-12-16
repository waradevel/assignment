package com.rambert.assignment.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rambert.assignment.model.Clazz;
import com.rambert.assignment.service.ClazzService;

@RestController
@RequestMapping("/classes")
public class ClassController
{

	@Autowired
	private ClazzService clazzService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Clazz> getAllClazzes()
	{
		return clazzService.getAllClazzes();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Long createClazz(@RequestBody Clazz clazz)
	{
		return clazzService.create(clazz);
	}
}
