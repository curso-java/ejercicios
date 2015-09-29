package com.produban.ejercicio008.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class VentaDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Venta venta) {
		entityManager.persist(venta);		
	}
	
	public List<Venta> findBySala(Long idSala) {
		return entityManager.createQuery("SELECT v FROM Venta v, Sala s WHERE v.sala.idSala = s.idSala AND s.idSala = ?1", Venta.class).setParameter(1, idSala).getResultList();
	}
}