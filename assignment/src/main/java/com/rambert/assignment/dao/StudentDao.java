package com.rambert.assignment.dao;

import java.util.Collection;

import com.rambert.assignment.model.Student;

public interface StudentDao extends GenericDao<Student>
{

	Collection<Student> getAllStudents();

	Student get(Long id);

	void delete(Long id);

}
