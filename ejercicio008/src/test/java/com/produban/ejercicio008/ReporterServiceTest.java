package com.produban.ejercicio008;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import com.produban.ejercicio008.FormateadorService;
import com.produban.ejercicio008.ReporterService;
import com.produban.ejercicio008.jpa.Venta;
import com.produban.ejercicio008.jpa.VentaDAO;

public class ReporterServiceTest {

	private ReporterService reporterService;
	private List<Venta> ventas;
	private FormateadorService formateadorService;
	private PrintStream out;
	
	private Venta ventaSala1 = new Venta();
	private Venta ventaSala2 = new Venta();

	private VentaDAO ventaDAO;
	
	@Before
	public void setUp() {
		reporterService = new ReporterService();
		ventas = new ArrayList<Venta>();
		formateadorService = mock(FormateadorService.class);
		out = spy(System.out);

		reporterService.setFormateador(formateadorService);
		reporterService.setOut(out);

		ventas.add(ventaSala1);
		ventas.add(ventaSala2);
		
		ventaDAO = mock(VentaDAO.class);
		reporterService.setVentaDAO(ventaDAO);

		ventaSala1.setImporte(18);
		ventaSala2.setImporte(7);

	}
	

	@Test
	public void testIngresosSala() {
		int indiceSala = 1;
				
		when(ventaDAO.findBySala(1l)).thenReturn(ventas);
		
		int importeObtenido = reporterService.ingresosSala(indiceSala);
		
		assertEquals("El importe obtenido no es correcto", 25, importeObtenido);
	}

	@Test
	public void testInformeSala() {
		when(ventaDAO.findBySala(1l)).thenReturn(ventas);
		
		when(formateadorService.formateaVentaSala(ventaSala1)).thenReturn("VENTA1");
		when(formateadorService.formateaVentaSala(ventaSala2)).thenReturn("VENTA2");

		reporterService.informeSala(1);

		InOrder inOrder = inOrder(formateadorService, out);
		inOrder.verify(formateadorService).formateaVentaSala(ventaSala1);
		inOrder.verify(out).println("VENTA1");
		
		inOrder.verify(formateadorService).formateaVentaSala(ventaSala2);
		inOrder.verify(out).println("VENTA2");	
	}
}
