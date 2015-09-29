package com.produban.ejercicio008.jpa;

import java.util.List;

public interface SalaDAO extends GenericDAO<Sala, Long> {

/*
	Sala find(Long idSala);
	List<Sala> list();
	Long create(Sala sala);
	void update(Sala sala);
	void delete(Sala sala);
	void delete(Long idSala); */
	void listaConSesiones();
}