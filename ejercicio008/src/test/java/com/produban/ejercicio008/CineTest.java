package com.produban.ejercicio008;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.produban.ejercicio008.CineService;
import com.produban.ejercicio008.TaquillaFactory;
import com.produban.ejercicio008.TaquillaService;

public class CineTest {

	private CineService cineService;
	private TaquillaFactory taquillaFactory;
	private TaquillaService taquillaService;
	
	@Before
	public void setUp() throws Exception {
		cineService = new CineService();
		taquillaFactory = mock(TaquillaFactory.class);
		cineService.setTaquillaFactory(taquillaFactory);
		
		taquillaService = mock(TaquillaService.class);
	}

	@Test
	public void testGeneraTaquilla() {
		when(taquillaFactory.getInstance(1)).thenReturn(taquillaService);
		
		cineService.generaTaquilla(1);
		
		verify(taquillaFactory).getInstance(1);
		assertEquals("No ha establecido la taquillaService seleccionada", cineService.getTaquilla(), taquillaService);
	}

}
