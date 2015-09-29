package com.produban.ejercicio008.jpa;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

public class DAOTestHelper {
	public static void assertEqualsTablas(EntityManager entityManager, final String[] tablasActuales, final String expected) {
		entityManager.flush();

		Session session = entityManager.unwrap(Session.class);
		
		session.doWork(new Work() {
			
			public void execute(Connection connection) throws SQLException {
				try {
					DatabaseConnection databaseConnection = new DatabaseConnection(connection);
					IDataSet actualDataSet = databaseConnection.createDataSet(tablasActuales);
					IDataSet expectedDataSet = new XmlDataSet(getClass()
							.getResourceAsStream(expected));	
					org.dbunit.Assertion.assertEquals(expectedDataSet, actualDataSet);
				} catch (DatabaseUnitException e) {
					fail("Error en la verificación del test:" + tablasActuales);
				}	
			}
		});
	}
}