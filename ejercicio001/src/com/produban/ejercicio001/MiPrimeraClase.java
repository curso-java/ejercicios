package com.produban.ejercicio001;
/*
// import java.util.ArrayList;
*/
import java.awt.PageAttributes;


public class MiPrimeraClase {
	
	public MiPrimeraClase() {
		java.util.ArrayList a = new java.util.ArrayList<>();
		
	}
	
	
	public int miPrimeraOperacion(int a, int b) {
		int c = a + b;
		return c;
		
	}
	
	
	
	private int miPrimeraOperacion2(int a, int b) {
		int c = a + b;
		return c;
		
	}
	

	public static void main(String[] args) {
		System.out.println("Hola mundo");

		MiPrimeraClase miPrimeraInstancia = new MiPrimeraClase();
		
		Saludo miS = new MiSegundaClase();
		miS.hola();
		int c = miPrimeraInstancia.miPrimeraOperacion2(3, 4);
		
		
	}

}
