package ar.edu.unlam.practica;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unlam.practica.enums.TipoDeBatalla;

public class FuerzaArmada {

	private Set<Vehiculo> convoy;
	private List<Batalla> batallas;
	
	public FuerzaArmada() {
	this.convoy = new HashSet<Vehiculo>();
	this.batallas = new ArrayList<Batalla>();
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		this.convoy.add(vehiculo);		
	}

	public Integer getCapacidadDeDefensa() {
		return this.convoy.size();
	}
	
	public Vehiculo getVehiculoPorNroDeVehiculo(Integer nroDeVehiculo) {
		Vehiculo buscado = null;
		for(Vehiculo vehiculo: convoy) {
			if(vehiculo.getnroVehiculoVehiculo() == nroDeVehiculo) {
				buscado = vehiculo;
			}
		}return buscado;
	}
	
	public Batalla crearBatalla(String nombre, TipoDeBatalla tipoDeBatalla, Double latitud, Double longitud) {
		Batalla nueva = new Batalla(nombre,tipoDeBatalla,latitud,longitud);
		this.batallas.add(nueva);
		return nueva;
	}
	
	public Batalla getBatalla(String nombre) {
		Batalla buscada = null;
		for(Batalla batalla: batallas) {
			if(batalla.getNombre().equals(nombre)) {
				buscada = batalla;
			}
		}return buscada;
	}
		
		
}
