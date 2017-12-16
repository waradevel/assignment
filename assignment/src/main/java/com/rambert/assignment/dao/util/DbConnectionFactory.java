package com.rambert.assignment.dao.util;

public class DbConnectionFactory
{

	private static DbConnection dbConnection;

	public static DbConnection getConnection()
	{
		if (dbConnection == null)

		{
			return new FakeDbConnection();
		}
		else
		{
			return dbConnection;
		}
	}

}
