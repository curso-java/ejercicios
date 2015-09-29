package com.produban.ejercicio008;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Ignore;

import java.io.PrintStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.produban.ejercicio008.CineService;
import com.produban.ejercicio008.ReporterService;
import com.produban.ejercicio008.TaquillaDescuentoGrupoService;
import com.produban.ejercicio008.TaquillaService;
import com.produban.ejercicio008.jpa.LiquiBaseHandler;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	TransactionalTestExecutionListener.class})
@ContextConfiguration(locations={"classpath:com/produban/ejercicio008/applicationContext.xml"})
@Transactional
public class IntegracionTest {

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
	private CineService cineService;
	
	@Autowired
	private ReporterService reporterService;
	
	@BeforeTransaction
	public void setUpTransaction() throws Exception {        
		liquiBaseHandler = new LiquiBaseHandler(DATABASECONNECTIONSTRING, DATABASE_USER, null, DATABASE_TABLES);

		iDataBaseTester = new JdbcDatabaseTester(HSQLDBDRIVER, DATABASECONNECTIONSTRING + "?user=" + DATABASE_USER);        

		IDataSet nuevoDataSet = new XmlDataSet(getClass().getResourceAsStream("/com/produban/ejercicio008/jpa/sala-general.xml"));
		
		DatabaseOperation.CLEAN_INSERT.execute(iDataBaseTester.getConnection(), nuevoDataSet);  		
	}	
	
	@AfterTransaction
	public void tearDownTransaction() throws Exception {	
		liquiBaseHandler.dropTables();
	}
	
	
	@Test
	public void testTaquillaNormal() throws Exception {
		cineService.generaTaquilla(TaquillaService.TAQUILLA_NORMAL);
		cineService.getTaquilla().guardar();
	}
	
	@Test
	public void testTaquillaDiaEspectador() throws Exception {
		cineService.generaTaquilla(TaquillaService.TAQUILLA_DIA_ESPECTADOR);
		cineService.getTaquilla().guardar();
	}	
	
	@Ignore
	@Test(expected=Exception.class)
	public void testTaquillaDescuentoGrupoFallo() throws Exception {
		cineService.generaTaquilla(TaquillaService.TAQUILLA_DESCUENTO_GRUPO);
		cineService.getTaquilla().guardar();
	}	
	
	@Test
	public void testTaquillaDescuentoGrupo() throws Exception {
		cineService.generaTaquilla(TaquillaService.TAQUILLA_DESCUENTO_GRUPO);
		TaquillaDescuentoGrupoService taquillaDescuentoGrupoService = ((TaquillaDescuentoGrupoService)cineService.getTaquilla());
		taquillaDescuentoGrupoService.setNumero(5);
		
		cineService.getTaquilla().guardar();
	}
	
	@Test
	public void testVentaTaquillaNormal() throws Exception {
		cineService.generaTaquilla(TaquillaService.TAQUILLA_NORMAL);
		cineService.getTaquilla().guardar();
		cineService.getTaquilla().ventas(true);
		
		
		int precio = cineService.getTaquilla().comprar(5, 1);
		assertEquals("El precio no es el correcto", 50, precio);
	}
	
	@Test
	public void testVentaTaquillaDiaEspectador() throws Exception {
		cineService.generaTaquilla(TaquillaService.TAQUILLA_DIA_ESPECTADOR);
		cineService.getTaquilla().guardar();
		cineService.getTaquilla().ventas(true);
		
		
		int precio = cineService.getTaquilla().comprar(5, 0);
		assertEquals("El precio no es el correcto", 40, precio);
	}	
	
	@Test
	public void testVentaTaquillaDescuentoGrupo() throws Exception {
		cineService.generaTaquilla(TaquillaService.TAQUILLA_DESCUENTO_GRUPO);
		((TaquillaDescuentoGrupoService)cineService.getTaquilla()).setNumero(4);
		cineService.getTaquilla().guardar();
		cineService.getTaquilla().ventas(true);
		
		
		int precio = cineService.getTaquilla().comprar(5, 0);
		assertEquals("El precio no es el correcto", 45, precio);
	}	
	
	@Test
	public void testBeneficiosVentasSala() throws Exception {
		cineService.generaTaquilla(TaquillaService.TAQUILLA_NORMAL);
		cineService.getTaquilla().guardar();
		cineService.getTaquilla().ventas(true);
		
		TaquillaService taquillaService = cineService.getTaquilla();
		
		taquillaService.comprar(5, 1);
		taquillaService.comprar(2, 0);
		taquillaService.comprar(14, 1);
		
		int importeTotal = reporterService.ingresosSala(1);
		
		assertEquals("El importe total de la sala no es el esperado", importeTotal, 190);
	}
	
	@Test
	public void testReporteVentasSala() throws Exception {
		cineService.generaTaquilla(TaquillaService.TAQUILLA_NORMAL);
		cineService.getTaquilla().guardar();
		cineService.getTaquilla().ventas(true);
		
		TaquillaService taquillaService = cineService.getTaquilla();
		PrintStream outPrintStream = spy(reporterService.getOut());
		reporterService.setOut(outPrintStream);
		
		taquillaService.comprar(5, 1);
		taquillaService.comprar(2, 0);
		taquillaService.comprar(14, 1);
		
		reporterService.informeSala(1);
		
		verify(outPrintStream, times(2)).println(anyString());
	}	
}
