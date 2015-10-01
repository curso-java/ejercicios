package com.produban.ejercicio011;

import static com.jayway.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.produban.ejercicio011.LoginForm;
import com.produban.ejercicio011.VentaForm;

public class AssuredTestIntegracion {

	private int puertoValido;
	
	@Before
	public void setUp() throws Exception {
		Properties pr = new Properties();
		pr.load(getClass().getResourceAsStream("jetty.properties"));
		String puerto = pr.getProperty("jetty.port");
		puertoValido = 8080;
		try {
			
			puertoValido = Integer.parseInt(puerto);
		} catch (NumberFormatException nfe) {		
		}		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPost() {
		LoginForm loginForm = new LoginForm();
		loginForm.setUser("3");
		loginForm.setPassword("0");
		VentaForm ventaForm =
			given().port(puertoValido).
				contentType("application/json").
				accept("application/json").
				body(loginForm).
			when().
				post("/ejercicio011/rest/sampleRest").
				getBody().as(VentaForm.class);
		assertEquals(3, ventaForm.getCantidad());
	}

	@Test
	public void testGetVenta() {
		VentaForm ventaForm =
			given().port(puertoValido).
				contentType("application/json").
				accept("application/json").				
			when().
				get("/ejercicio011/rest/sampleRest/venta/2").
				getBody().as(VentaForm.class);
		assertEquals(2, ventaForm.getSala());
	}	
}
