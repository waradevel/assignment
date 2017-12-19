package com.rambert.assignment.dao.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.rambert.assignment.exception.EntityNotFoundException;
import com.rambert.assignment.model.GenericModel;

public class FakeDbConnection implements DbConnection
{
	private static Long currentId = 0L;

	private static Map<String, Map<Long, GenericModel>> store = new HashMap<>();

	@Override
	public Long insert(GenericModel newInstance)
	{
		String clazzName = newInstance.getClass().getName();
		Map<Long, GenericModel> modelStore = store.get(clazzName);

		if (modelStore == null)
		{
			modelStore = new HashMap<>();
			store.put(clazzName, modelStore);
		}

		Long nextId = nextIdGenerated();
		newInstance.setId(nextId);
		modelStore.put(nextId, newInstance);

		return nextId;
	}

	@Override
	public <T extends GenericModel> T get(Class<T> type, Long id) throws EntityNotFoundException
	{
		Map<Long, GenericModel> map = store.get(type.getName());
		if (map != null)
		{
			return (T) map.get(id);
		}
		throw new EntityNotFoundException("Entity not found, id:" + id);
	}

	@Override
	public <T extends GenericModel> Collection<T> getAllByModel(Class<T> type)
	{
		Collection<T> allEntities = new ArrayList<>();
		Map<Long, GenericModel> entities = store.get(type.getName());
		if (entities != null)
		{
			allEntities = (Collection<T>) entities.values();
		}
		return allEntities;
	}

	@Override
	public void update(GenericModel transientObject)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends GenericModel> void delete(Class<T> type, Long id)
	{
		store.get(type.getName()).remove(id);
	}

	private Long nextIdGenerated()
	{
		return currentId++;
	}

}
