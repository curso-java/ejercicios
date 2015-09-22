package com.produban.ejercicio001;

import static org.junit.Assert.*;

import org.junit.Test;

public class MiSegundaClaseTest {

	@Test
	public void testHola() {
		Saludo sut = new MiSegundaClase();
		
		int res = sut.hola();

		
		assertEquals(6,  res);
	}

}
