package com.rambert.assignment.dao;

import java.util.Collection;

import com.rambert.assignment.exception.EntityNotFoundException;
import com.rambert.assignment.model.GenericModel;

public interface GenericDao<T extends GenericModel>
{

	Long create(T newInstance);

	T get(Long id) throws EntityNotFoundException;
	
	Collection<T> getAll();

	void update(T transientObject) throws EntityNotFoundException;

	void delete(Long id);

}
