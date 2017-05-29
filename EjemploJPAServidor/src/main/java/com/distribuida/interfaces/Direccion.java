package com.distribuida.interfaces;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Entity
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String calleprimaria;

	private String callesecundaria;

	private Integer numero;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="direccion")
	private List<Persona> personas;

	public Direccion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalleprimaria() {
		return this.calleprimaria;
	}

	public void setCalleprimaria(String calleprimaria) {
		this.calleprimaria = calleprimaria;
	}

	public String getCallesecundaria() {
		return this.callesecundaria;
	}

	public void setCallesecundaria(String callesecundaria) {
		this.callesecundaria = callesecundaria;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setDireccion(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setDireccion(null);

		return persona;
	}

}