package com.rambert.assignment.dao.impl;


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
	public T get(Long id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T transientObject)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T persistentObject)
	{
		// TODO Auto-generated method stub

	}

}
