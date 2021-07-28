package ar.edu.unlam.practica;

import ar.edu.unlam.practica.interfaces.Acuatico;

public class Submarino extends Vehiculo implements Acuatico {

	private String nombre;
	private Double profundidad = 0.0;
	
	public Submarino(Integer nroVehiculo, String nombre) {
		super(nroVehiculo);
		this.nombre = nombre;
	}

	
	public Double getProfundidad() {
		return this.profundidad;
	}
	public String getTipo() {
		return "Acuatico";
	}

}
