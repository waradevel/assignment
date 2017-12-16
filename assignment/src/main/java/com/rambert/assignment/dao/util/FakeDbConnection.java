package com.rambert.assignment.dao.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
	public GenericModel get(String model, Long id)
	{
		return store.get(model).get(id);
	}

	@Override
	public <T extends GenericModel> Collection<T> getAllByModel(Class<T> type)
	{
		return (Collection<T>) store.get(type.getName()).values();
	}

	@Override
	public void update(GenericModel transientObject)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(GenericModel persistentObject)
	{
		// TODO Auto-generated method stub

	}

	private Long nextIdGenerated()
	{
		return currentId++;
	}

}
