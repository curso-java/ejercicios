package com.produban.ejercicio008.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CineDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Cine find(Long id) {
		return entityManager.find(Cine.class, id);
	}
}
