package com.rambert.assignment.dao;

import com.rambert.assignment.exception.EntityNotFoundException;
import com.rambert.assignment.model.Clazz;

public interface ClazzDao extends GenericDao<Clazz>
{

	void addStudentToClazz(Long id, Long studentId) throws EntityNotFoundException;

}
