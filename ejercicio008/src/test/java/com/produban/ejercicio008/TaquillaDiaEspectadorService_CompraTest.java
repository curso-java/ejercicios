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
import com.produban.ejercicio008.TaquillaDiaEspectadorService;
import com.produban.ejercicio008.TaquillaService;
import com.produban.ejercicio008.jpa.SalaDAO;
import com.produban.ejercicio008.jpa.SalaDAOImpl;
import com.produban.ejercicio008.jpa.VentaDAO;


public class TaquillaDiaEspectadorService_CompraTest {

	private TaquillaService taquillaService;
	private CineService cineService;
	private SalaService salaService;
	private List<SalaService> salaServices;
	private SalaDAO salaDAO;
	private VentaDAO ventaDAO;
	
	@Before
	public void setUp() throws Exception {
		taquillaService = new TaquillaDiaEspectadorService();
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
		
		int precioCobrado = taquillaService.comprar(3, 0);
		
		assertEquals("El precio no es el esperado", 24, precioCobrado);
		verify(salaService).decrementaDisponibles(3, 0);
	}		
}
