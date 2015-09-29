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
import com.produban.ejercicio008.TaquillaService;
import com.produban.ejercicio008.jpa.SalaDAO;
import com.produban.ejercicio008.jpa.SalaDAOImpl;
import com.produban.ejercicio008.jpa.Venta;
import com.produban.ejercicio008.jpa.VentaDAO;


public class Taquilla_CompraTest {

	private TaquillaService taquillaService;
	private CineService cineService;
	private SalaService salaService;
	private SalaDAO salaDAO;
	private VentaDAO ventaDAO;
	
	@Before
	public void setUp() throws Exception {
		taquillaService = new TaquillaService();
		taquillaService.guardar();
		taquillaService.ventas(true);
		
		cineService = mock(CineService.class);
		taquillaService.setCineService(cineService);
		
		salaService = mock(SalaService.class);
		taquillaService.setSalaService(salaService);
	
		salaDAO = mock(SalaDAOImpl.class);
		taquillaService.setSalaDAO(salaDAO);
		
		ventaDAO = mock(VentaDAO.class);
		taquillaService.setVentaDAO(ventaDAO);
	}

	@Test
	public void testComprar() throws Exception {
		when(cineService.getPrecio()).thenReturn(10);
		
		int precioCobrado = taquillaService.comprar(3, 1);
		
		assertEquals("El precio no es el esperado", 30, precioCobrado);
		verify(salaService).decrementaDisponibles(3, 1);
		verify(ventaDAO).save(any(Venta.class));
	}
	
	@Test(expected=RuntimeException.class)
	public void testComprarNoPuedoVender() throws Exception {
		taquillaService.ventas(false);
		
		when(cineService.getPrecio()).thenReturn(10);
		doThrow(new RuntimeException()).when(salaService).decrementaDisponibles(3, 1);
		taquillaService.comprar(3, 1);		
	}
	
	
	@Test(expected=Exception.class)
	public void testComprarSalaNoCorrecta() throws Exception {
		when(cineService.getPrecio()).thenReturn(10);
		doThrow(new RuntimeException()).when(salaService).decrementaDisponibles(3, -1);
		
		taquillaService.comprar(3, -1);		
	}	
	
	@Test(expected=Exception.class)
	public void testComprarNumeroDeEntradasNegativo() throws Exception {
		when(cineService.getPrecio()).thenReturn(10);
		doThrow(new RuntimeException()).when(salaService).decrementaDisponibles(-3, 1);
		
		taquillaService.comprar(-3, 1);		
	}	
	
	@Test(expected=Exception.class)
	public void testComprarNumeroDeEntradasNoDisponibles() throws Exception {
		when(cineService.getPrecio()).thenReturn(10);
		doThrow(new RuntimeException()).when(salaService).decrementaDisponibles(101, 1);
		
		taquillaService.comprar(101, 1);		
	}		
}
