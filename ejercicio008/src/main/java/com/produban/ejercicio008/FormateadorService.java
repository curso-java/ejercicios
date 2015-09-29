package com.produban.ejercicio008;

import org.springframework.stereotype.Service;

import com.produban.ejercicio008.jpa.Venta;

@Service
public class FormateadorService {
	public static final String SEPARADOR = " - ";

	public String formateaVentaSala(Venta ventaSala) {
		StringBuilder sb = new StringBuilder();
		sb.append(ventaSala.getSala().getIdSala());
		sb.append(SEPARADOR);
		sb.append(ventaSala.getCantidad());
		sb.append(SEPARADOR);
		sb.append(ventaSala.getImporte());
		return sb.toString();
	}
}
