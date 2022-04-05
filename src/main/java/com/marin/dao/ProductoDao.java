package com.marin.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.marin.aplicacion.Coordinador;
import com.marin.aplicacion.JPAUtil;
import com.marin.entidades.PersonasProductos;
import com.marin.entidades.Producto;

public class ProductoDao {

	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	private Coordinador miCoordinador;
	
	public String registrarProducto(Producto miProducto) {
		
		String resp="";
		
		try {

			entityManager.getTransaction().begin();
			entityManager.persist(miProducto);
			entityManager.getTransaction().commit();
			
			resp = "ok";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo registrar el producto",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return resp;
	}
	
	public Producto consultarProducto(Long idProducto) {
		
		Producto miProducto=entityManager.find(Producto.class, idProducto);
		
		if (miProducto != null) {
			return miProducto;
		}
		else {
			return null;
		}
	}
	
	public List<Producto> ConsultarListaProductos() {
		System.out.println("Entro al dao");
		List<Producto> listaProductos = new ArrayList<Producto>();
		Query query = entityManager.createQuery("SELECT m FROM Producto m");
		System.out.println("despues");
		listaProductos=query.getResultList();
		
		return listaProductos;
	}
	
	public String actualizarProducto(Producto miProducto, Long idProducto) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(miProducto);
		entityManager.getTransaction().commit();
		
		String resp="ok";
		
		return resp;
	}
	
	public String eliminarProducto(Producto miProducto, Long id) {
		
		entityManager.getTransaction().begin();
		entityManager.remove(miProducto);
		entityManager.getTransaction().commit();
		
		String resp = "ok";
		
		return resp;
	}
	
	
	public String registrarCompra(PersonasProductos producto) {
		String resp="";
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(producto);
			entityManager.getTransaction().commit();
			
			resp = "ok";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede registrar"
					+ "la compra del producto","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		return resp;
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
