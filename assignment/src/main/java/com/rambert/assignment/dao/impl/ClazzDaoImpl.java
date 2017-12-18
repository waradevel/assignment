package com.rambert.assignment.dao.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rambert.assignment.dao.ClazzDao;
import com.rambert.assignment.dao.StudentDao;
import com.rambert.assignment.exception.EntityNotFoundException;
import com.rambert.assignment.model.Clazz;
import com.rambert.assignment.model.Student;

@Repository
public class ClazzDaoImpl extends GenericDaoImpl<Clazz> implements ClazzDao
{

	@Autowired
	private StudentDao studentDao;

	public ClazzDaoImpl()
	{
		super(Clazz.class);
	}

	@Override
	public void addStudentToClazz(Long id, Long studentId) throws EntityNotFoundException
	{
		Clazz clazz = get(id);
		Student student = studentDao.get(studentId);
		Set<Student> students = clazz.getStudentsWithClasses();
		students.add(student);
		Set<Clazz> clazzes = student.getClazzesWithStudents();
		clazzes.add(clazz);
	}

}
