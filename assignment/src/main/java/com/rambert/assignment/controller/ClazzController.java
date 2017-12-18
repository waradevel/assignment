package com.rambert.assignment.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rambert.assignment.exception.EntityNotFoundException;
import com.rambert.assignment.model.Clazz;
import com.rambert.assignment.service.ClazzService;

@RestController
@RequestMapping("/classes")
public class ClazzController
{

	@Autowired
	private ClazzService clazzService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Clazz> getAllClazzes()
	{
		return clazzService.getAllClazzes();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Clazz> getClazzById(@PathVariable("id") Long id)
	{
		try
		{
			Clazz clazz = clazzService.getClazzById(id);
			return new ResponseEntity<>(clazz, HttpStatus.OK);
		}
		catch (EntityNotFoundException e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Long createClazz(@RequestBody Clazz clazz)
	{
		return clazzService.create(clazz);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateClazz(@RequestBody Clazz clazz)
	{
		try
		{
			clazzService.update(clazz);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (EntityNotFoundException e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}}", method = RequestMethod.DELETE)
	public void deleteClazzById(@PathVariable("id") Long id)
	{
		clazzService.deleteClazzById(id);
	}

	@RequestMapping(value = "/{id}/student/{studentId}", method = RequestMethod.POST)
	public ResponseEntity<Void> addStudentToClazz(@PathVariable("id") Long id,
			@PathVariable("studentId") Long studentId)
	{
		try
		{
			clazzService.addStudentToClazz(id, studentId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (EntityNotFoundException e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
