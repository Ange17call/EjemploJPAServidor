package com.distribuida;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.distribuida.interfaces.Servicio;


@Configuration
@ComponentScan("com")
public class AppConfig {
	
/*	@Bean(name = "/servicioPersonas")
	public HttpInvokerServiceExporter HttpOperaciones(Servicio servicio) {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(servicio);
		exporter.setServiceInterface(Servicio.class);
		return exporter;
	}*/
	
	@Bean(name="/servicioPersonas")
	public HessianServiceExporter HessianOperaciones(Servicio servicio) {
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(servicio);
		exporter.setServiceInterface(Servicio.class);
		return exporter;
	}
	
	
	
}
