package com.marin.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_producto")
	private Long idProducto;
	
	@Column(name = "nombre_producto",nullable = false, length = 45)
	private String nombreProducto;
	
	@Column(name = "precio_producto")
	private Double precioProducto;
	
	@ManyToMany(mappedBy = "listaProductos")
	private List<Persona> listaPersonas;
	
	public Producto(){
		
	}

	public Producto(Long idProducto, String nombreProducto, Double precioProducto, List<Persona> listaPersonas) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.listaPersonas = listaPersonas;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	@Override
	public String toString() {
		return "\nProducto \nIdProducto: " + idProducto + "\nNombreProducto: " + nombreProducto + "\nPrecioProducto="
				+ precioProducto ;
	}
	
	
}
