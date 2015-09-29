package com.produban.ejercicio008.jpa;

import java.sql.Connection;
import java.sql.SQLException;

import org.hsqldb.jdbc.JDBCDataSource;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import liquibase.resource.ClassLoaderResourceAccessor;

public class LiquiBaseHandler {
	private Liquibase liquibase;

	public LiquiBaseHandler(String dataBaseConnectionString, String user, String password, String dataBaseTables) throws DatabaseException, SQLException, LiquibaseException {
		createTables(dataBaseConnectionString, user, password, dataBaseTables);
	}
	
	public LiquiBaseHandler(Connection connection, String dataBaseTables) throws DatabaseException, SQLException, LiquibaseException {
		createTables(connection, dataBaseTables);
	}
	
	
	
	private void createTables(String dataBaseConnectionString, String user, String password, String dataBaseTables) throws DatabaseException, SQLException,
			LiquibaseException {
		JDBCDataSource dataSource = new JDBCDataSource();
		dataSource.setDatabase(dataBaseConnectionString);
		dataSource.setUser(user);
		if (password != null) {
			dataSource.setPassword(password);
		}
		createTables(dataSource.getConnection(), dataBaseTables);
	}
	
	private void createTables(Connection connection, String dataBaseTables) throws DatabaseException, SQLException,
	LiquibaseException {
		Database database = DatabaseFactory.getInstance()
				.findCorrectDatabaseImplementation(
						new JdbcConnection(connection));

		liquibase = new Liquibase(
				dataBaseTables,
				new ClassLoaderResourceAccessor(), database);

		liquibase.update(null);		
	}
	
	public void dropTables() throws DatabaseException, LockException {
		liquibase.dropAll();
	}	
}