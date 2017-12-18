package com.rambert.assignment.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rambert.assignment.dao.StudentDao;
import com.rambert.assignment.exception.EntityNotFoundException;
import com.rambert.assignment.model.Student;

@Service
public class StudentService
{
	@Autowired
	private StudentDao studentDao;

	public Collection<Student> getAllStudents()
	{
		return studentDao.getAll();
	}

	public Long create(Student student)
	{
		return studentDao.create(student);
	}

	public Student getStudentById(Long id) throws EntityNotFoundException
	{
		return studentDao.get(id);
	}

	public void update(Student student) throws EntityNotFoundException
	{
		studentDao.update(student);
	}

	public void deleteStudentById(Long id)
	{
		studentDao.delete(id);
		
	}
}
