package com.rambert.assignment.dao.impl;

import java.util.Collection;

import com.rambert.assignment.dao.GenericDao;
import com.rambert.assignment.dao.util.DbConnectionFactory;
import com.rambert.assignment.exception.EntityNotFoundException;
import com.rambert.assignment.model.GenericModel;

public class GenericDaoImpl<T extends GenericModel> implements GenericDao<T>
{

	private Class<T> classType;
	
	public GenericDaoImpl(Class<T> classType)
	{
		this.classType = classType;
	}
	
	@Override
	public Long create(T newInstance)
	{
		return DbConnectionFactory.getConnection().insert(newInstance);
	}

	@Override
	public T get(Long id) throws EntityNotFoundException
	{
		return DbConnectionFactory.getConnection().get(getClassType(), id);
	}

	@Override
	public Collection<T> getAll()
	{
		return DbConnectionFactory.getConnection().getAllByModel(classType);
	}

	@Override
	public void update(T transientObject) throws EntityNotFoundException
	{
		T oldInstance = (T) DbConnectionFactory.getConnection().get(transientObject.getClass(),
				transientObject.getId());
		oldInstance.copyAttributes(transientObject);

	}

	@Override
	public void delete(Long id)
	{
		DbConnectionFactory.getConnection().delete(classType, id);
	}

	private Class<T> getClassType()
	{
		return classType;
	}
}
