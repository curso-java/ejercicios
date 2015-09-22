package com.produban.ejercicio002;

public class GarageImpl implements Garage {
	private Vehiculo vehiculo;

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	/* (non-Javadoc)
	 * @see com.produban.ejercicio002.Garage#estacionar(com.produban.ejercicio002.Vehiculo)
	 */
	@Override
	public void estacionar(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	/* (non-Javadoc)
	 * @see com.produban.ejercicio002.Garage#extraer()
	 */
	@Override
	public Vehiculo extraer() {
		Vehiculo ret = vehiculo;
		this.vehiculo = null;
		return ret;
	}
}
