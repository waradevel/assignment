package com.rambert.assignment.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.rambert.assignment.dao.ClazzDao;
import com.rambert.assignment.model.Clazz;

@Repository
public class ClazzDaoImpl extends GenericDaoImpl<Clazz> implements ClazzDao
{

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

}
