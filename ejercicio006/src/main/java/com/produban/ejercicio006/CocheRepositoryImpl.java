package com.produban.ejercicio006;

import java.util.List;

public class CocheRepositoryImpl implements CocheRepository {

	@Override
	public Coche create(Coche coche) {
		return coche;
	}

	@Override
	public List<Coche> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coche get(Long id) {
		// TODO Auto-generated method stub
		return new Coche();
	}

	@Override
	public Coche update(Coche coche) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
