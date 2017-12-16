package com.rambert.assignment.dao.util;

import java.util.Collection;

import com.rambert.assignment.model.GenericModel;

public interface DbConnection
{
	
	Long insert(GenericModel newInstance);

	GenericModel get(String model, Long id);
	
	<T extends GenericModel> Collection<T> getAllByModel(Class<T> type);

	void update(GenericModel transientObject);

	void delete(GenericModel persistentObject);

}
