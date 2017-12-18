package com.rambert.assignment.dao.impl;

import org.springframework.stereotype.Repository;

import com.rambert.assignment.dao.StudentDao;
import com.rambert.assignment.model.Student;

@Repository
public class StudentDaoImpl extends GenericDaoImpl<Student> implements StudentDao
{

	public StudentDaoImpl()
	{
		super(Student.class);
	}

}
