package com.rambert.assignment.dao.util;

import java.util.Collection;

import com.rambert.assignment.model.GenericModel;

public interface DbConnection
{
	
	Long insert(GenericModel newInstance);

	<T extends GenericModel> T get(Class<T> type, Long id);
	
	<T extends GenericModel> Collection<T> getAllByModel(Class<T> type);

	void update(GenericModel transientObject);

	<T extends GenericModel> void delete(Class<T> type, Long id);

}
