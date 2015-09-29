package com.produban.ejercicio008.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class SalaDAOImpl implements SalaDAO {
	@PersistenceContext
	private EntityManager entityManager;

	
	public Sala find(Long idSala) {
		return entityManager.find(Sala.class, idSala);
	}


	public List<Sala> list() {
		throw new RuntimeException("No implementado aun");
	}


	public Long create(Sala sala) {
		throw new RuntimeException("No implementado aun");
	}


	public void update(Sala sala) {
		throw new RuntimeException("No implementado aun");
		
	}


	public void delete(Sala sala) {
		throw new RuntimeException("No implementado aun");
		
	}


	public void delete(Long idSala) {
		throw new RuntimeException("No implementado aun");
		
	}
	
	public void listaConSesiones(){
		throw new RuntimeException("No implementado aun");
	}
}