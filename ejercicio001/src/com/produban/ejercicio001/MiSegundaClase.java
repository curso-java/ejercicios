package com.produban.ejercicio001;

public class MiSegundaClase extends Object implements Saludo {
	/* (non-Javadoc)
	 * @see com.produban.ejercicio001.Saludo#hola()
	 */
	@Override
	public int hola() {
		MiPrimeraClase miPrimeraInstancia = new MiPrimeraClase();
		int d = miPrimeraInstancia.miPrimeraOperacion(2, 3);
		System.out.println(d);
		return d;
	}
	
	public void terminar() {
		
	}
}
