package com.rambert.assignment.dao;

import com.rambert.assignment.model.GenericModel;

public interface GenericDao<T extends GenericModel>
{

	Long create(T newInstance);

	T get(Long id);

	void update(T transientObject);

	void delete(T persistentObject);

}
