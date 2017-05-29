package com.distribuida;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.distribuida.interfaces.Servicio;
import com.distribuida.interfaces.ServicioImpl;
import com.distribuida.interfaces.Direccion;
import com.distribuida.interfaces.Persona;


@SpringBootApplication
public class EjemploJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(EjemploJpaApplication.class, args);
		Servicio servicio = (Servicio) ctx.getBean("servicio",ServicioImpl.class);
		
		
		List<Persona> personas = new ArrayList<>();
		personas = servicio.listar();
		for (Persona pe : personas) {
			System.out.println(pe.getId()+" "+pe.getNombre()
			+pe.getDireccion().getCalleprimaria()
			+pe.getDireccion().getCallesecundaria()
			+pe.getDireccion().getNumero()+" "+pe.getTelefono());
		}
		String calleprimaria="Cutuglagua";
		String callesecundaria= "Chile";
		int numero= 325;
		Direccion dir = new Direccion();
		int n;
		n = servicio.buscarDireccionNombre(calleprimaria, callesecundaria, numero);
		if(n==-1){
			dir.setCalleprimaria(calleprimaria);
			dir.setCallesecundaria(callesecundaria);
			dir.setNumero(numero);
			servicio.insertarDireccion(dir);
			System.out.println("la direccion se ingreso");
		}else{
			dir=servicio.buscarDireccion(3);
			System.out.println("la direccion se encontro");
		}
		
		///Direccion
	//	int idDireccion;
		
		
		/*if(idDireccion!=-1){
			dir=servicio.buscarDireccion(idDireccion);
		}else{
			dir.setCalleprimaria(calleprimaria);
			dir.setCallesecundaria(callesecundaria);
			dir.setNumero(numero);
			servicio.insertarDireccion(dir);
		}*/
		
		
		
		
		/*Direccion dir = new Direccion();
		dir.setId(3);
		dir.setCalleprimaria("La marin");
		dir.setCallesecundaria("Chile");
		dir.setNumero(325);*/
		//servicio.insertar(dir);
	/*	Direccion dir = new Direccion();
		dir=servicio.buscarDireccion(3);
		System.out.println(dir.getId()+dir.getCalleprimaria());
		
		Persona per = new Persona();
		per.setId(3);
		per.setNombre("Marco Calero");
		per.setDireccion(dir);
		per.setTelefono("444444444");*/
		
		//servicio.insertar(per);
		//servicio.eliminarPersona(1);
		/*Persona pe = new Persona();
		pe=servicio.buscarPersona(2);
		System.out.println(pe.getId()+" "+pe.getNombre()
		+pe.getDireccion().getCalleprimaria()
		+pe.getDireccion().getCallesecundaria()
		+pe.getDireccion().getNumero()+" "+pe.getTelefono());*/
		//servicio.actualizarPersona(per);
	
	}
}
