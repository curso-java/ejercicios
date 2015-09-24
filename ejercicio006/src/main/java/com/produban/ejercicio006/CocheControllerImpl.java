package com.produban.ejercicio006;

import java.util.List;

public class CocheControllerImpl implements CocheController {

	private CocheService service;

	@Override
	public Coche create(Coche coche) {
		return service.create(coche);
	}

	@Override
	public List<Coche> list() {
		return service.list();
	}

	@Override
	public Coche get(Long id) {
		return service.get(id);
	}

	@Override
	public Coche update(Coche coche) {
		return service.update(coche);
	}

	@Override
	public void delete(Long id) {
		service.delete(id);
	}

	/**
	 * @return the service
	 */
	public CocheService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(CocheService service) {
		this.service = service;
	}

}
