package ar.edu.unlam.practica;

import ar.edu.unlam.practica.interfaces.Acuatico;
import ar.edu.unlam.practica.interfaces.Volador;

public class HidroAvion extends Vehiculo implements Volador, Acuatico{

	private String nombre;
	private Double altura = 0.0;
	private Double profundidad = 0.0;
	
	
	public HidroAvion(Integer nroVehiculo, String nombre) {
		super(nroVehiculo);
		this.nombre = nombre;
	}

	@Override
	public Double getProfundidad() {
	
		return this.profundidad;
	}

	@Override
	public Double getAltura() {
		
		return this.altura;
	}

}
