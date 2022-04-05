package com.marin.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.marin.aplicacion.Coordinador;
import com.marin.aplicacion.JPAUtil;
import com.marin.entidades.Nacimiento;


public class NacimientoDao {
	
	private Coordinador miCoordinador;
	
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String registrarNacimiento(Nacimiento miNacimiento) {
		
		System.out.println(miNacimiento);
		
		entityManager.getTransaction().begin();
		entityManager.persist(miNacimiento);
		entityManager.getTransaction().commit();
		
		String resp = "Nacimiento registrado";
		
		return resp;
	}
	
	public Nacimiento consultarNacimiento(Long idNacimiento) {
		
		Nacimiento miNacimiento = entityManager.find(Nacimiento.class, idNacimiento);
		
		if (miNacimiento != null) {
			return miNacimiento;
		}
		else {
			return null;
		}
	}
	
	public List<Nacimiento> consultarListaNacimiento() {
		
		List<Nacimiento> listaNacimiento = new ArrayList<Nacimiento>();
		
		Query query=entityManager.createQuery("SELECT p FROM Nacimiento p");
		listaNacimiento=query.getResultList();
		
		return listaNacimiento;
	}
	
	public String actualizarNacimiento(Nacimiento miNacimiento) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(miNacimiento);
		entityManager.getTransaction().commit();
		
		String resp = "Nacimiento Actualizado";
		
		return resp;
	}
	
	public String eliminarNacimiento(Nacimiento miNacimiento) {
		String resp = "";
		
		try {
			
			entityManager.getTransaction().begin();
			entityManager.remove(miNacimiento);
			entityManager.getTransaction().commit();
			
			resp = "Nacimiento Eliminado";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo eliminar el Nacimiento",
					"ERROR",JOptionPane.ERROR_MESSAGE);
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
