package com.produban.ejercicio008;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.produban.ejercicio008.jpa.Sala;
import com.produban.ejercicio008.jpa.SalaDAO;

@Scope(BeanDefinition.SCOPE_SINGLETON)
@Service
public class SalaService {
	
	@Autowired
	private SalaDAO salaDAO;

	@Transactional
	public void decrementaDisponibles(long numeroDeEntradas, long idSala) {
		Sala sala = salaDAO.find(idSala);
		
		long disponibles = sala.getDisponibles();

		if (disponibles < numeroDeEntradas) {
			throw new RuntimeException ("Me solictas " + numeroDeEntradas + " y dispongo de " + disponibles);
		}
		
		sala.setDisponibles(disponibles - numeroDeEntradas);	
	}
}
