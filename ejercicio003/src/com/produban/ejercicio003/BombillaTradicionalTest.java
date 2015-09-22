package com.produban.ejercicio003;

import static org.junit.Assert.*;

import org.junit.Test;

public class BombillaTradicionalTest {

	private BombillaTradicional sut;
	
	@Test
	public void testEncender() {
		sut = new BombillaTradicional();
		
		sut.encender();
		
		assertTrue(sut.isEncendido());
	}

}
