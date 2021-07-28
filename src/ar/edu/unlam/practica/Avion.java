package ar.edu.unlam.practica;

import ar.edu.unlam.practica.interfaces.Volador;

public class Avion extends Vehiculo implements Volador {

	private Double altura = 0.0;
	private String nombre;
	
	public Avion(Integer nroVehiculo, String nombre) {
		super(nroVehiculo);
		this.nombre = nombre;
	}
	

	public Double getAltura() {		
		return this.altura;
	}
	
	

}
