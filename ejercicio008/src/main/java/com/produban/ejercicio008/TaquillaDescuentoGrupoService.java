package com.produban.ejercicio008;

import org.springframework.stereotype.Service;

@Service
public class TaquillaDescuentoGrupoService extends TaquillaService {

	private static final int NO_ESTABLECIDO = -200;
	private int descuento;
	private int numero;
	
	public TaquillaDescuentoGrupoService() {
		super();
		descuento = 10;
		numero = NO_ESTABLECIDO;
	}
	
	@Override
	public void guardar() throws Exception {
		if (numero == NO_ESTABLECIDO) {
			throw new Exception("TaquillaService no configurada con el limite de descuento");
		}
		super.guardar();
	}
	
//	@Override
//	public int comprar(int numeroDeEntradas, int sala) throws Exception {
//		puedoProcederALaVenta(numeroDeEntradas, sala);
//		
//		int precioFinal = numeroDeEntradas * getCine().getPrecio();
//		if (numeroDeEntradas >= numero) {
//			precioFinal = (precioFinal * (100 - descuento)) / 100 ;
//		}
//		return precioFinal;
//	}	
	
	@Override
	protected int calculaPrecio(int numeroDeEntradas) {
		int precioFinal = numeroDeEntradas * getCineService().getPrecio();
		if (numeroDeEntradas >= numero) {
			precioFinal = (precioFinal * (100 - descuento)) / 100 ;
		}
		return precioFinal;		
	}
	
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
