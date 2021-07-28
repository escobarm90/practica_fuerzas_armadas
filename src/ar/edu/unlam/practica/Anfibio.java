package ar.edu.unlam.practica;

import ar.edu.unlam.practica.interfaces.Acuatico;
import ar.edu.unlam.practica.interfaces.Terrestre;

public class Anfibio extends Vehiculo implements Terrestre, Acuatico {

	private String nombre;
	private Double velocidad = 0.0;
	private Double profundidad = 0.0;
	
	
	public Anfibio(Integer nroVehiculo, String nombre) {
		super(nroVehiculo);
		// TODO Auto-generated constructor stub
	}

	
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return this.profundidad;
	}

	
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return this.velocidad;
	}
	
	public String getTipo() {
		return "Anfibio";
	}


}
