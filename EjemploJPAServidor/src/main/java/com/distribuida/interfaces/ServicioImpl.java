package com.distribuida.interfaces;


import java.util.List;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

@Component("servicio")
@Transactional
public class ServicioImpl implements Servicio {
	
		
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Persona> listar() {
		
	
		
		return this.entityManager.createQuery("SELECT d FROM Persona d", Persona.class).getResultList();
		
	}

	@Override
	public void insertarPersona(Persona persona) {
		
		entityManager.persist( persona );
		
	}
	
	@Override
	public void insertarDireccion(Direccion direccion) {
		
		entityManager.persist( direccion );
		
	}

	@Override
	public void eliminarPersona(int id) {
		
		Persona obj = buscarPersona(id);
		entityManager.remove( obj );
		
	}
	
	@Override
	public void eliminarDireccion(int id) {
		
		Direccion obj = buscarDireccion(id);
		entityManager.remove( obj );
		
	}

	@Override
	public Persona buscarPersona(int id) {
		
		return entityManager.find(Persona.class, id);
		
	}
	
	@Override
	public Direccion buscarDireccion(int id) {
		
		return entityManager.find(Direccion.class, id);
		
	}
	@Override
	public int buscarDireccionNombre(String calleprimaria, String callesecundaria, int numero) {
	List<Direccion> direc;	
	direc= entityManager.createQuery("SELECT d FROM Direccion d WHERE d.calleprimaria= :calle1 and callesecundaria= :calle2 and numero= :numero",Direccion.class)
			    .setParameter("calle1", calleprimaria)
			    .setParameter("calle2", callesecundaria)
			    .setParameter("numero", numero)
			    .getResultList();
	int n=-1;
	for (Direccion pe : direc) {
		n=pe.getId();
	}
	 return n;
	}
	

	@Override
	public void actualizarPersona(Persona persona) {
		
		entityManager.merge(persona);
		
	}
	
	@Override
	public void actualizarDireccion(Direccion direccion) {
		
		entityManager.merge(direccion);
		
	}
	
	public String prueba(){
		return "hola mundo";
	}
	
}
