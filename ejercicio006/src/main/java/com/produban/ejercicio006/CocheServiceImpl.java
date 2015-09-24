package com.produban.ejercicio006;

import java.util.List;

public class CocheServiceImpl implements CocheService {

	private CocheRepository repository;
	

	@Override
	public Coche create(Coche coche) {
		return repository.create(coche);
	}

	@Override
	public List<Coche> list() {
		return repository.list();
	}

	@Override
	public Coche get(Long id) {
		return repository.get(id);
	}

	@Override
	public Coche update(Coche coche) {
		return repository.update(coche);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}
	
	/**
	 * @return the repository
	 */
	public CocheRepository getRepository() {
		return repository;
	}

	/**
	 * @param repository the repository to set
	 */
	public void setRepository(CocheRepository repository) {
		this.repository = repository;
	}

}
