package com.produban.ejercicio002;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GarageTest {

	private Garage sut;
	private Vehiculo veh;
	
	@Before
	public void setUp() {
		sut = new Garage();
		veh = new Coche();
	}
	
	@Test
	public void testSetVehiculo() {
		
		
		sut.setVehiculo(veh);
		
		assertEquals(veh, sut.getVehiculo());
		
	}

}
