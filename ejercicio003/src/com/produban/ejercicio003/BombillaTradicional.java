package com.produban.ejercicio003;

public class BombillaTradicional {
	private boolean encendido;

	public void encender() {
		encendido = true;
	}
	
	public void apagar() {
		encendido = false;
	}	
	
	public boolean isEncendido() {
		return encendido;
	}

	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
	
	
}
