package com.produban.ejercicio003;

import static org.junit.Assert.*;

import org.junit.Test;

public class BombillaLogicaTest {

	private BombillaLogica sut;
	
	private Bombilla bombilla;
	@Test
	public void testEncender() {
		sut = new BombillaLogica();
		bombilla = new Bombilla();
		
		sut.encender(bombilla);

		assertTrue(bombilla.isEncendido());
	}

}
