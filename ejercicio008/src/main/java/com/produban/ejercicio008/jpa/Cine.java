package com.produban.ejercicio008.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CINE")
public class Cine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCine;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="cine")
	private List<Sala> salas;
	
	public List<Sala> getSalas() {
		return salas;
	}
	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
	public Long getIdCine() {
		return idCine;
	}
	public void setIdCine(Long idCine) {
		this.idCine = idCine;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
