package com.rambert.assignment.dao.impl;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rambert.assignment.dao.ClazzDao;
import com.rambert.assignment.dao.StudentDao;
import com.rambert.assignment.model.Clazz;
import com.rambert.assignment.model.Student;

@Repository
public class ClazzDaoImpl extends GenericDaoImpl<Clazz> implements ClazzDao
{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Collection<Clazz> getAllClazzes()
	{
		return super.getAll(Clazz.class);
	}

	@Override
	public Clazz get(Long id)
	{
		return super.get(Clazz.class, id);
	}

	@Override
	public void delete(Long id)
	{
		super.delete(Clazz.class, id);
	}

	@Override
	public void addStudentToClazz(Long id, Long studentId)
	{
		Clazz clazz = get(Clazz.class, id);
		Student student = studentDao.get(studentId);
		Set<Student> students = clazz.getStudents();
		students.add(student);
	}

}
