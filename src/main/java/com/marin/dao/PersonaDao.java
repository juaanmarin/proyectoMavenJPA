package com.marin.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;



import com.marin.aplicacion.Coordinador;
import com.marin.aplicacion.JPAUtil;
import com.marin.entidades.Persona;

public class PersonaDao {

	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	private Coordinador miCoordinador;
	
	public String registrarPersona(Persona miPersona) {
		
		System.out.println(miPersona);
		
		entityManager.getTransaction().begin();
		entityManager.persist(miPersona);
		entityManager.getTransaction().commit();
		
		String resp = "ok";
		
		return resp;
	}
	
	
	public Persona consultarPersona(Long idPersona) {
		
		Persona miPersona=entityManager.find(Persona.class, idPersona);
		
		if (miPersona != null) {
			return miPersona;
		}
		else {
			return null;
		}
	}
	
	
	public List<Persona> consultarListaPersonas() {
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		Query query=entityManager.createQuery("SELECT p FROM Persona p");
		listaPersonas=query.getResultList();
		
		return listaPersonas;
	}
	
	public String actualizarPersona(Persona miPersona) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(miPersona);
		entityManager.getTransaction().commit();
		
		String resp = "ok";
		
		return resp;
	}
	
	public String eliminarPersona(Persona miPersona) {
		String resp = "";
		try {

			entityManager.getTransaction().begin();
			entityManager.remove(miPersona);
			entityManager.getTransaction().commit();
			
			resp = "ok";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo eliminar la persona"
					+ "verifique que no tenga registros pendientes",
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
