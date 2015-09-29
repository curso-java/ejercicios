package com.produban.ejercicio008.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="SALA")
public class Sala {
	@Id
	@GeneratedValue
	private Long idSala;
	
	@Version
	private long version;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@JoinColumn(name="idCine")
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Cine cine;
	
	@Column(name="aforo", nullable=false)
	private long aforo;
	
	@Column(name="disponibles", nullable=false)
	private long disponibles;

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public long getAforo() {
		return aforo;
	}

	public void setAforo(long aforo) {
		this.aforo = aforo;
	}

	public long getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(long disponibles) {
		this.disponibles = disponibles;
	}
}
