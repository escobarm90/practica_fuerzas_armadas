package ar.edu.unlam.practica;


import java.util.HashSet;
import java.util.Set;

public class FuerzaArmada {

	private Set<Vehiculo> convoy;
	
	public FuerzaArmada() {
	convoy = new HashSet<Vehiculo>();
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		this.convoy.add(vehiculo);		
	}

	public Integer getCapacidadDeDefensa() {
		return this.convoy.size();
		
	}	
}
