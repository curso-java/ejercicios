package com.produban.ejercicio011;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class VentaForm {
	@Min(value=0) @Max(value=2)
	private int sala;
	@Min(value=1)
	private int cantidad;
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
