package com.produban.ejercicio008;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.produban.ejercicio008.TaquillaDescuentoGrupoService;

public class TaquillaDescuentoGrupoServiceTest {

	public TaquillaDescuentoGrupoService taquillaDescuentoGrupoService;
	
	
	@Before
	public void setUp() throws Exception {
		taquillaDescuentoGrupoService = new TaquillaDescuentoGrupoService();
	}

	@Test
	public void testGuardarCorrecto() throws Exception {
		taquillaDescuentoGrupoService.setNumero(10);
		taquillaDescuentoGrupoService.guardar();
	}
	

	@Test(expected=Exception.class)
	public void testGuardarIncorrecto() throws Exception {
		taquillaDescuentoGrupoService.guardar();
	}	
	
	@Test
	public void testVentasComenzando() throws Exception {
		taquillaDescuentoGrupoService.setNumero(3);
		taquillaDescuentoGrupoService.guardar();
		
		taquillaDescuentoGrupoService.ventas(true);
		assertTrue("No puedo vender", taquillaDescuentoGrupoService.getPuedeVender());
	}		

}
