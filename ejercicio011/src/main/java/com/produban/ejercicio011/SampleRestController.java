package com.produban.ejercicio011;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sampleRest")
public class SampleRestController {
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody 
	public VentaForm ejemplo() {
		return new VentaForm();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody 
	public VentaForm ejemplo(@RequestBody LoginForm loginForm) {
		VentaForm ventaForm = new VentaForm();
		ventaForm.setCantidad(Integer.parseInt(loginForm.getUser()));
		return ventaForm;
	}
	
	@RequestMapping(value="/venta/{salaId}" , method=RequestMethod.GET)
	@ResponseBody
	public VentaForm getVenta(@PathVariable String salaId) {
		VentaForm ventaForm = new VentaForm();
		ventaForm.setSala(Integer.parseInt(salaId));
		return ventaForm;		
	}
}
