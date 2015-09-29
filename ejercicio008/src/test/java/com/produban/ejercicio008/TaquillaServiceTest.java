package com.produban.ejercicio008;

import static com.produban.ejercicio008.TaquillaService.TAQUILLA_NORMAL;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.produban.ejercicio008.TaquillaService;

public class TaquillaServiceTest {

	private TaquillaService taquillaService;
	
	@Before
	public void setUp() throws Exception {
		taquillaService = new TaquillaService();
		taquillaService.guardar();
	}

	@Test
	public void testVentasComenzando() throws Exception {
		taquillaService.ventas(true);
		assertTrue("No puedo vender", taquillaService.getPuedeVender());
	}
}
