package com.produban.ejercicio003;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GarajeTest {

	private Garaje sut;
	
	private Calculadora calculadora;
	
	@Before
	public void setUp() {
		sut = new Garaje();
		calculadora = mock(Calculadora.class);
		sut.setCalculadora(calculadora);
	}
	
	@Test
	public void testCalcular() {
		int inicial = 3;
		when(calculadora.multiplica(inicial)).thenReturn(6);
		
		int res = sut.calcular(inicial);
		
		assertEquals(6, res);
	}

}
