package com.produban.ejercicio008;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.produban.ejercicio008.CineService;
import com.produban.ejercicio008.ReporterService;
import com.produban.ejercicio008.SalaService;
import com.produban.ejercicio008.TaquillaDescuentoGrupoService;
import com.produban.ejercicio008.jpa.SalaDAO;
import com.produban.ejercicio008.jpa.SalaDAOImpl;
import com.produban.ejercicio008.jpa.VentaDAO;


public class TaquillaDescuentoGrupo_CompraTest {

	private TaquillaDescuentoGrupoService taquilla;
	private CineService cineService;
	private SalaService salaService;
	private SalaDAO salaDAO;
	private VentaDAO ventaDAO;
	
	@Before
	public void setUp() throws Exception {
		taquilla = new TaquillaDescuentoGrupoService();

		taquilla.setNumero(2);
		
		taquilla.guardar();
	
		taquilla.ventas(true);
		
		cineService = mock(CineService.class);
		taquilla.setCineService(cineService);
		
		salaService = mock(SalaService.class);
		taquilla.setSalaService(salaService);
	
		salaDAO = mock(SalaDAOImpl.class);
		taquilla.setSalaDAO(salaDAO);
		
		ventaDAO = mock(VentaDAO.class);
		taquilla.setVentaDAO(ventaDAO);	
	}

	@Test
	public void testComprarDescuentoGrupo() throws Exception {
		when(cineService.getPrecio()).thenReturn(10);

		
		int precioCobrado = taquilla.comprar(3, 0);
		
		assertEquals("El precio no es el esperado", 27, precioCobrado);
		verify(salaService).decrementaDisponibles(3, 0);
	}	
	
	@Test
	public void testComprarDescuentoGrupoLimite() throws Exception {
		when(cineService.getPrecio()).thenReturn(10);
		
		int precioCobrado = taquilla.comprar(2, 0);
		
		assertEquals("El precio no es el esperado", 18, precioCobrado);
		verify(salaService).decrementaDisponibles(2, 0);
	}	
	
	@Test
	public void testComprarSinDescuentoGrupo() throws Exception {
		when(cineService.getPrecio()).thenReturn(10);
		
		int precioCobrado = taquilla.comprar(1, 0);
		
		assertEquals("El precio no es el esperado", 10, precioCobrado);
		verify(salaService).decrementaDisponibles(1, 0);
	}	
}
