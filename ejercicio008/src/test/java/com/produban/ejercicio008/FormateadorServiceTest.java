package com.produban.ejercicio008;

import static com.produban.ejercicio008.FormateadorService.SEPARADOR;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.produban.ejercicio008.FormateadorService;
import com.produban.ejercicio008.jpa.Sala;
import com.produban.ejercicio008.jpa.Venta;

public class FormateadorServiceTest {

	private FormateadorService formateadorService;
	private Venta venta;
	
	@Before
	public void setUp() throws Exception {
		formateadorService = new FormateadorService();
		venta = new Venta();
		
		Sala sala = new Sala();
		sala.setIdSala(1l);
		venta.setSala(sala);
		venta.setCantidad(2);
		venta.setImporte(3);
	}

	@Test
	public void testFormateaVentaSala() {
		String resultado = formateadorService.formateaVentaSala(venta);
		assertEquals("El formateo no es el esperado",  resultado, "1" + SEPARADOR + "2" + SEPARADOR + "3.0");	
	}

}
