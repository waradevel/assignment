package com.rambert.assignment.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.rambert.assignment.dao.StudentDao;
import com.rambert.assignment.model.Student;

@Repository
public class StudentDaoImpl extends GenericDaoImpl<Student> implements StudentDao
{

	@Override
	public Collection<Student> getAllStudents()
	{
		return super.getAll(Student.class);
	}

	@Override
	public Student get(Long id)
	{
		return super.get(Student.class, id);
	}

	@Override
	public void delete(Long id)
	{
		super.delete(Student.class, id);
	}

}
