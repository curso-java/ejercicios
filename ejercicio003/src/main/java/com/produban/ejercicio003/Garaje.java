package com.produban.ejercicio003;

public class Garaje {
	private Calculadora calculadora;

	public int calcular(int valor) {
		return calculadora.multiplica(valor);
	}	
	
	public void setCalculadora(Calculadora calculadora) {
		this.calculadora = calculadora;
	}
	
	public Calculadora getCalculadora() {
		return calculadora;
	}	
}
