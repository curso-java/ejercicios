package com.produban.ejercicio008.jpa;

import java.util.List;

public interface GenericDAO<TEntity, SId extends Number> {
	TEntity find(SId idSala);
	List<TEntity> list();
	SId create(TEntity sala);
	void update(TEntity sala);
	void delete(TEntity sala);
	void delete(SId idSala);
}
