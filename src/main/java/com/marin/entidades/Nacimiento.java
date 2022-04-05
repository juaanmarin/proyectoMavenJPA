package com.marin.entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="nacimiento")

public class Nacimiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nacimiento")
	private Long idNacimiento;
	
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name = "ciudad_nacimiento")
	private String ciudadNacimiento;
	
	@Column(name = "departamento_nacimiento")
	private String departamentoNacimiento;
	
	@Column(name = "pais_nacimiento")
	private String paisNacimiento;
	
	//para crear una relacion Bidireccionadal
	@OneToOne(mappedBy = "nacimiento", fetch = FetchType.LAZY)
	private Persona persona;
	
	public Nacimiento() {
		
	}

	public Nacimiento(Long idNacimiento, LocalDate fechaNacimiento, String ciudadNacimiento,
			String departamentoNacimiento, String paisNacimiento) {
		super();
		this.idNacimiento = idNacimiento;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudadNacimiento = ciudadNacimiento;
		this.departamentoNacimiento = departamentoNacimiento;
		this.paisNacimiento = paisNacimiento;
	}

	public Long getIdNacimiento() {
		return idNacimiento;
	}

	public void setIdNacimiento(Long idNacimiento) {
		this.idNacimiento = idNacimiento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiudadNacimiento() {
		return ciudadNacimiento;
	}

	public void setCiudadNacimiento(String ciudadNacimiento) {
		this.ciudadNacimiento = ciudadNacimiento;
	}

	public String getDepartamentoNacimiento() {
		return departamentoNacimiento;
	}

	public void setDepartamentoNacimiento(String departamentoNacimiento) {
		this.departamentoNacimiento = departamentoNacimiento;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Nacimiento \nIdNacimiento:" + idNacimiento + "\nFechaNacimiento: " + fechaNacimiento
				+ "\nCiudadNacimiento: " + ciudadNacimiento + "\nDepartamentoNacimiento: " + departamentoNacimiento
				+ "\nPaisNacimiento: " + paisNacimiento;
		
		
	}
	
	
}
