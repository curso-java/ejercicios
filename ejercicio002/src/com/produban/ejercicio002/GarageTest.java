package com.produban.ejercicio002;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GarageTest {

	private Garage sut;
	private Vehiculo veh;
	private Vehiculo veh2;
	
	@Before
	public void setUp() {
		sut = new GarageImpl();
		veh = new Coche();
		veh2 = new Moto();
	}
	
	@Test
	public void testSetVehiculo() {
		
		
		sut.estacionar(veh);
		
		assertEquals(veh, sut.extraer());
		
	}
	
	
	@Test
	public void testExtraerVehiculo() {
		
		
		sut.estacionar(veh);
		sut.estacionar(veh2);
		
		assertEquals(veh, sut.extraer());
		assertEquals(veh2, sut.extraer());
		
	}	

}
