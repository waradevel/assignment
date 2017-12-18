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
import com.rambert.assignment.model.Student;
import com.rambert.assignment.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController
{

	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id)
	{
		try
		{
			Student student = studentService.getStudentById(id);
			return new ResponseEntity<>(student, HttpStatus.OK);
		}
		catch (EntityNotFoundException e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Long createStudent(@RequestBody Student student)
	{
		return studentService.create(student);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateStudent(@RequestBody Student student)
	{
		try
		{
			studentService.update(student);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (EntityNotFoundException e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteStudentById(@PathVariable("id") Long id)
	{
		studentService.deleteStudentById(id);
	}
	
}
