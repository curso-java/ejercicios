package com.produban.ejercicio008;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.produban.ejercicio008.TaquillaDescuentoGrupoService;
import com.produban.ejercicio008.TaquillaDiaEspectadorService;
import com.produban.ejercicio008.TaquillaFactory;
import com.produban.ejercicio008.TaquillaService;

public class TaquillaFactoryTest {

	private TaquillaFactory taquillaFactory;
	private TaquillaService taquillaService;
	private TaquillaDescuentoGrupoService taquillaDescuentoGrupoService;
	private TaquillaDiaEspectadorService taquillaDiaEspectadorService;
	
	@Before
	public void setUp() throws Exception {
		taquillaFactory = new TaquillaFactory();
		
		taquillaService = mock(TaquillaService.class);
		taquillaDescuentoGrupoService = mock(TaquillaDescuentoGrupoService.class);
		taquillaDiaEspectadorService = mock(TaquillaDiaEspectadorService.class);
		
		taquillaFactory.setTaquilla(taquillaService);
		taquillaFactory.setTaquillaDescuentoGrupo(taquillaDescuentoGrupoService);
		taquillaFactory.setTaquillaDiaEspectador(taquillaDiaEspectadorService);
	}

	@Test
	public void testGetInstanceNormal() {
		TaquillaService resultado = taquillaFactory.getInstance(TaquillaService.TAQUILLA_NORMAL);
		
		assertEquals("El Objeto no es el correcto de TaquillaService", resultado, taquillaService);
	}

	@Test
	public void testGetInstanceDescuentoGrupo() {
		TaquillaService resultado = taquillaFactory.getInstance(TaquillaService.TAQUILLA_DESCUENTO_GRUPO);
		
		assertEquals("El Objeto no es el correcto de TaquillaDescuentoGrupoService", resultado, taquillaDescuentoGrupoService);
	}
	@Test
	public void testGetInstanceDiaEspectador() {
		TaquillaService resultado = taquillaFactory.getInstance(TaquillaService.TAQUILLA_DIA_ESPECTADOR);
		
		assertEquals("El Objeto no es el correcto de TaquillaDiaEspectadorService", resultado, taquillaDiaEspectadorService);
	}	
	
	@Test(expected=RuntimeException.class)
	public void testGetInstanceNoValido() {
		taquillaFactory.getInstance(17);
	}	
}
