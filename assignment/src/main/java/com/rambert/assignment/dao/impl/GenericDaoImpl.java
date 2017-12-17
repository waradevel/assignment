package com.rambert.assignment.dao.impl;

import java.util.Collection;

import com.rambert.assignment.dao.GenericDao;
import com.rambert.assignment.dao.util.DbConnectionFactory;
import com.rambert.assignment.model.GenericModel;

public class GenericDaoImpl<T extends GenericModel> implements GenericDao<T>
{

	@Override
	public Long create(T newInstance)
	{
		return DbConnectionFactory.getConnection().insert(newInstance);
	}

	@Override
	public T get(Class<T> type, Long id)
	{
		return DbConnectionFactory.getConnection().get(type, id);
	}

	@Override
	public Collection<T> getAll(Class<T> type)
	{
		return DbConnectionFactory.getConnection().getAllByModel(type);
	}

	@Override
	public void update(T transientObject)
	{
		T oldInstance = (T) DbConnectionFactory.getConnection().get(transientObject.getClass(),
				transientObject.getId());
		oldInstance.copyAttributes(transientObject);

	}

	@Override
	public void delete(Class<T> type, Long id)
	{
		DbConnectionFactory.getConnection().delete(type, id);
	}

}
