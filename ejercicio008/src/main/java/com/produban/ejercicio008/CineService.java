package com.produban.ejercicio008;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CineService {

	private final int precio = 10;
	private TaquillaService taquillaService;
	
	@Autowired
	private SalaService salaService;

	public SalaService getSalaService() {
		return salaService;
	}

	public void setSalaService(SalaService salaService) {
		this.salaService = salaService;
	}

	@Autowired
	private TaquillaFactory taquillaFactory;

	public void generaTaquilla(int tipoTaquilla) {
		taquillaService = taquillaFactory.getInstance(tipoTaquilla);
	}
	
	public int getPrecio() {
		return precio;
	}


	public TaquillaFactory getTaquillaFactory() {
		return taquillaFactory;
	}

	public void setTaquillaFactory(TaquillaFactory taquillaFactory) {
		this.taquillaFactory = taquillaFactory;
	}

	public TaquillaService getTaquilla() {
		return taquillaService;
	}

	public void setTaquilla(TaquillaService taquillaService) {
		this.taquillaService = taquillaService;
	}
}
