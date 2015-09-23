package com.produban.ejercicio005;

public class CocheServiceImpl implements CocheService {

	private CalculadoraService calculadora;
	@Override
	public double calcularConsumo(long kilometros) {
		return getCalculadora().multiplicar(kilometros/100.0, CONSUMO_A_LOS_100);
	}
	
	
	public CalculadoraService getCalculadora() {
		return calculadora;
	}
	public void setCalculadora(CalculadoraService calculadora) {
		this.calculadora = calculadora;
	}

}
