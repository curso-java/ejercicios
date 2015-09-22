package com.produban.ejercicio002;

import java.util.ArrayList;
import java.util.List;

public class GarageImpl implements Garage {
	private List<Vehiculo> vehiculos;
	
	public GarageImpl() {
		this.vehiculos = new ArrayList<Vehiculo>();
	}
	
	/* (non-Javadoc)
	 * @see com.produban.ejercicio002.Garage#estacionar(com.produban.ejercicio002.Vehiculo)
	 */
	@Override
	public void estacionar(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}
	
	/* (non-Javadoc)
	 * @see com.produban.ejercicio002.Garage#extraer()
	 */
	@Override
	public Vehiculo extraer() {
		return vehiculos.remove(0);
	}
}
