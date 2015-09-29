package com.produban.ejercicio008;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.produban.ejercicio008.jpa.Sala;
import com.produban.ejercicio008.jpa.SalaDAO;
import com.produban.ejercicio008.jpa.Venta;
import com.produban.ejercicio008.jpa.VentaDAO;

@Service
public class TaquillaService {
	public static final int TAQUILLA_NORMAL 			= 1;
	public static final int TAQUILLA_DESCUENTO_GRUPO	= 2;
	public static final int TAQUILLA_DIA_ESPECTADOR		= 3;
	
	
	private boolean puedeVender;
	protected boolean guardado;
	
	@Autowired
	private CineService cineService;
	
	@Autowired
	private VentaDAO ventaDAO;
	
	@Autowired
	private SalaDAO salaDAO;
	
	@Autowired
	private SalaService salaService;
	
	public TaquillaService() {
		this.guardado = false;
		this.puedeVender = false;
	}

	
	public void guardar() throws Exception {
		guardado = true;
		return;
	}
	
	public boolean getPuedeVender() {
		return puedeVender;
	}

	public void ventas(boolean puedeVender) throws Exception {
		if (!guardado) {
			throw new Exception("No esta guardado, no puedo vender");
		}
		this.puedeVender= puedeVender; 
	}

	@Transactional
	public int comprar(int numeroDeEntradas, long idSala) throws Exception {
		procederALaVenta(numeroDeEntradas, idSala);
		int importe = calculaPrecio(numeroDeEntradas);
		Venta venta = generaVenta(idSala, numeroDeEntradas, importe);
		ventaDAO.save(venta);
		return importe;
	}


	private Venta generaVenta(long idSala, int numeroDeEntradas, int importe) {
		Sala sala = salaDAO.find(idSala);
		Venta venta = new Venta();
		venta.setCantidad(numeroDeEntradas);
		venta.setImporte(importe);
		venta.setSala(sala);
		return venta;
	}
	
	protected int calculaPrecio(int numeroDeEntradas) {
		return numeroDeEntradas * cineService.getPrecio();
	}
	
	protected void procederALaVenta(long numeroDeEntradas, long idSala) {
		if (!getPuedeVender()) {
			throw new RuntimeException ("La taquilla no est� abierta");
		}
		
		
		if (idSala < 0 || idSala >= 3 ) {
			throw new RuntimeException("La sala indicada no existe: " + idSala);
		}

		
		if (numeroDeEntradas <= 0) {
			throw new RuntimeException ("El numero de entradas ha de ser positivo: " + numeroDeEntradas);
		}
				
		salaService.decrementaDisponibles(numeroDeEntradas, idSala);
	}
	
	public CineService getCineService() {
		return cineService;
	}


	public void setCineService(CineService cineService) {
		this.cineService = cineService;
	}

	public SalaService getSalaService() {
		return salaService;
	}


	public void setSalaService(SalaService salaService) {
		this.salaService = salaService;
	}	

	public VentaDAO getVentaDAO() {
		return ventaDAO;
	}


	public void setVentaDAO(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}


	public SalaDAO getSalaDAO() {
		return salaDAO;
	}


	public void setSalaDAO(SalaDAO salaDAO) {
		this.salaDAO = salaDAO;
	}	
}	
