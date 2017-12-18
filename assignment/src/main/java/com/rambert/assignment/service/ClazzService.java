package com.rambert.assignment.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rambert.assignment.dao.ClazzDao;
import com.rambert.assignment.model.Clazz;

@Service
public class ClazzService
{
	@Autowired
	private ClazzDao clazzDao;

	public Collection<Clazz> getAllClazzes()
	{
		return clazzDao.getAllClazzes();
	}

	public Long create(Clazz clazz)
	{
		return clazzDao.create(clazz);
	}

	public Clazz getClazzById(Long id)
	{
		return clazzDao.get(id);
	}

	public void update(Clazz clazz)
	{
		clazzDao.update(clazz);
	}

	public void deleteClazzById(Long id)
	{
		clazzDao.delete(id);
		
	}

	public void addStudentToClazz(Long id, Long studentId)
	{
		clazzDao.addStudentToClazz(id, studentId);
	}

}
