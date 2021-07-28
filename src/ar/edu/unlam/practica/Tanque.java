package ar.edu.unlam.practica;

import ar.edu.unlam.practica.interfaces.Terrestre;

public class Tanque extends Vehiculo implements Terrestre {

	private Double velocidad = 0.0;
	private String nombre;
	
	public Tanque(Integer nroVehiculo, String nombre) {
		super(nroVehiculo);
		this.nombre = nombre;
	}

	public Double getVelocidad() {
		return this.velocidad;
	}
	
	public String getTipo() {
		return "Terrestre";
	}

}
