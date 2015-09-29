package com.produban.ejercicio008;

import java.io.PrintStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produban.ejercicio008.jpa.Venta;
import com.produban.ejercicio008.jpa.VentaDAO;

@Service
public class ReporterService {
	@Autowired
	private FormateadorService formateadorService;
	
	@Autowired
	private PrintStream out;

	@Autowired
	private VentaDAO ventaDAO;
	
	public PrintStream getOut() {
		return out;
	}

	public void setOut(PrintStream out) {
		this.out = out;
	}
	
	public int ingresosSala(int indiceSala) {
		int ingresos = 0;
		List<Venta> ventas = ventaDAO.findBySala((long) indiceSala);
		for(Venta venta: ventas) {
			ingresos += venta.getImporte();
		}
		return ingresos;
	}
	
	public void informeSala(int indiceSala) {
		List<Venta> ventas = ventaDAO.findBySala((long) indiceSala);
		for(Venta venta: ventas) {
			out.println(formateadorService.formateaVentaSala(venta));
		}
	}

	public FormateadorService getFormateador() {
		return formateadorService;
	}

	public void setFormateador(FormateadorService formateadorService) {
		this.formateadorService = formateadorService;
	}

	public VentaDAO getVentaDAO() {
		return ventaDAO;
	}

	public void setVentaDAO(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}	
}
