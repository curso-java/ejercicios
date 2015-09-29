package com.produban.ejercicio008.jpa;

import static com.produban.ejercicio008.jpa.DAOTestHelper.*;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.produban.ejercicio008.jpa.Sala;
import com.produban.ejercicio008.jpa.SalaDAO;
import com.produban.ejercicio008.jpa.Venta;
import com.produban.ejercicio008.jpa.VentaDAO;

import org.springframework.test.context.ContextConfiguration;
import org.hibernate.jdbc.Work;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@ContextConfiguration(locations={"classpath:com/produban/ejercicio008/applicationContext.xml"})
@Transactional
public class VentaDAOTest {

	private static String HSQLDBDRIVER = "org.hsqldb.jdbcDriver";
	private static String DATABASECONNECTIONSTRING = "jdbc:hsqldb:mem:aname";
	private static String DATABASE_USER = "sa";
	private static String DATABASE_PASSWORD = "";    
    
	private static final String DATABASE_TABLES = "com/produban/ejercicio008/jpa/produccion.xml";
	
    private static LiquiBaseHandler liquiBaseHandler;

	@PersistenceContext
	public EntityManager entityManager;
	public IDatabaseTester iDataBaseTester;
	
	@Autowired
	public VentaDAO ventaDAO;
	
	@Autowired
	private SalaDAO salaDAO;

	@BeforeTransaction
	public void setUpTransaction() throws Exception {        
		liquiBaseHandler = new LiquiBaseHandler(DATABASECONNECTIONSTRING, DATABASE_USER, null, DATABASE_TABLES);

		iDataBaseTester = new JdbcDatabaseTester(HSQLDBDRIVER, DATABASECONNECTIONSTRING + "?user=" + DATABASE_USER);        

		IDataSet nuevoDataSet = new XmlDataSet(getClass().getResourceAsStream("venta-find.xml"));
		
		DatabaseOperation.CLEAN_INSERT.execute(iDataBaseTester.getConnection(), nuevoDataSet);  		
	}	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Transactional
	@Test
	public void testFind() {
		Venta venta = new Venta();
	
		Sala sala = salaDAO.find(2l);
		sala.setDisponibles(sala.getDisponibles() - 5);
		
		venta.setCantidad(5);
		venta.setImporte(50);
		venta.setSala(sala);
		
		ventaDAO.save(venta);
		
		assertEqualsTablas(entityManager, new String[] {"venta", "sala"}, "venta-insert.xml");
	}

	@Test
	public void testListBySalaId() {
		List<Venta> listaVentas = ventaDAO.findBySala(2l);
		
		assertEquals(1, listaVentas.size());
	}
	
	@AfterTransaction
	public void tearDownTransaction() throws Exception {
		
		liquiBaseHandler.dropTables();
	}	
	
	
}
