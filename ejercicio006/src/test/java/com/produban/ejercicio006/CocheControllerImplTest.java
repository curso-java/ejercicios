package com.produban.ejercicio006;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CocheControllerImplTest {

	private CocheControllerImpl cocheController;
	
	private Coche coche;
	
	@Before
	public void setUp() {
		cocheController = new CocheControllerImpl();
		
		CocheServiceImpl cocheService = new CocheServiceImpl();
		cocheController.setService(cocheService);
		
		CocheRepository cocheRepository = new CocheRepositoryImpl();
		
		cocheService.setRepository(cocheRepository);
		
		coche = new Coche();
		coche.setColor(5);
		coche.setConsumo(3.4d);
	}
	
	@Ignore
	@Test
	public void testDummy() {

	}

	@Test
	public void testCreate() {
		
		Coche cocheResultado = cocheController.create(coche);
		
		assertNotNull("El coche no debería ser nulo", cocheResultado);
	}

	

	@Test
	public void testFind() {
		
		Coche cocheResultado = cocheController.get(1l);
		
		assertNotNull("El coche no debería ser nulo", cocheResultado);
	}	
}
