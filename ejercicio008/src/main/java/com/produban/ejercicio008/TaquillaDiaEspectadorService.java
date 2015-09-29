package com.produban.ejercicio008;

import org.springframework.stereotype.Service;

@Service
public class TaquillaDiaEspectadorService extends TaquillaService {

	private int descuento;
	
	public TaquillaDiaEspectadorService() {
		super();
		descuento = 20;
	}
	
//	@Override
//	public int comprar(int numeroDeEntradas, int sala) throws Exception {
//		puedoProcederALaVenta(numeroDeEntradas, sala);
//		return (numeroDeEntradas * getCine().getPrecio() * (100 - descuento)) / 100 ;
//	}
	
	@Override
	protected int calculaPrecio(int numeroDeEntradas) {
		return (numeroDeEntradas * getCineService().getPrecio() * (100 - descuento)) / 100 ;
	}
	
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
}
