package com.produban.ejercicio008;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.produban.ejercicio008.TaquillaDiaEspectadorService;

public class TaquillaDiaEspectadorServiceTest {

	private TaquillaDiaEspectadorService taquillaDiaEspectadorService;
	
	@Before
	public void setUp() throws Exception {
		taquillaDiaEspectadorService = new TaquillaDiaEspectadorService();
	}

	@Test
	public void testGuardar() throws Exception {
		taquillaDiaEspectadorService.guardar();
	}

	@Test
	public void testVentasComenzando() throws Exception {
		taquillaDiaEspectadorService.guardar();
		
		taquillaDiaEspectadorService.ventas(true);
		assertTrue("No puedo vender", taquillaDiaEspectadorService.getPuedeVender());
	}	
}
