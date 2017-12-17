package com.rambert.assignment.dao;

import java.util.Collection;

import com.rambert.assignment.model.GenericModel;

public interface GenericDao<T extends GenericModel>
{

	Long create(T newInstance);

	T get(Class<T> type, Long id);
	
	Collection<T> getAll(Class<T> type);

	void update(T transientObject);

	void delete(Class<T> type, Long id);

}
