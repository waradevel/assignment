package com.rambert.assignment.dao;

import java.util.Collection;

import com.rambert.assignment.model.Clazz;

public interface ClazzDao extends GenericDao<Clazz>
{

	Collection<Clazz> getAllClazzes();
	
	Clazz get(Long id);
	
	void delete(Long id);

	void addStudentToClazz(Long id, Long studentId);

}
