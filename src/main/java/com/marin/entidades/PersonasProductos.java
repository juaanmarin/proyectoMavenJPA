package com.marin.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "personas_productos")
public class PersonasProductos implements Serializable{

	private static final long serialVersionUID = 1l;
	
	@Id
	@Column(name = "persona_id")
	private Long personaId;
	
	@Id
	@Column(name = "producto_id")
	private Long productoId;
	
	public PersonasProductos() {
		
	}

	public PersonasProductos(Long personaId, Long productoId) {
		super();
		this.personaId = personaId;
		this.productoId = productoId;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	@Override
	public String toString() {
		return "PersonasProductos \nPersonaId: " + personaId + "\nProductoId: " + productoId;
	}
	
	
	
}
