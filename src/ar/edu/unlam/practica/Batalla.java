package ar.edu.unlam.practica;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ar.edu.unlam.practica.enums.TipoDeBatalla;
import ar.edu.unlam.practica.excepciones.VehiculoIncompatibleException;
import ar.edu.unlam.practica.excepciones.VehiculoInexistenteException;
import ar.edu.unlam.practica.interfaces.Acuatico;
import ar.edu.unlam.practica.interfaces.Terrestre;
import ar.edu.unlam.practica.interfaces.Volador;

public class Batalla {
	
	private String nombre;
	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipoDeBatalla;
	private Set<Vehiculo> convoy = new HashSet<Vehiculo>();
	
	public Batalla(String nombre, TipoDeBatalla tipoDeBatalla,Double latitud, Double longitud) {
		this.nombre = nombre;	
		this.tipoDeBatalla = tipoDeBatalla;		
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	
	public Double getLatitud() {	
		return latitud;			
	}
	
	public Double getLongitud() {	
		return longitud;			
	}
	
	public Boolean agregarAlConvoy(Vehiculo vehiculo)throws Exception {		
		if(this.tipoDeBatalla == TipoDeBatalla.TERRESTRE && vehiculo instanceof Terrestre) {
			return convoy.add(vehiculo);
		}
		if(this.tipoDeBatalla.equals(TipoDeBatalla.NAVAL) && vehiculo instanceof Acuatico) {
			return convoy.add(vehiculo);
		}
		if(this.tipoDeBatalla.equals(TipoDeBatalla.AEREA) && vehiculo instanceof Volador) {
			return convoy.add(vehiculo);
		}throw new VehiculoIncompatibleException("Vehiculo incompatible exception");
		
	}
	
	
}
