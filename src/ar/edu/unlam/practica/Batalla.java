package ar.edu.unlam.practica;

import java.util.Map;
import java.util.TreeMap;

import ar.edu.unlam.practica.enums.TipoDeBatalla;

public class Batalla {
	
	private String nombre;
	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipoDeBatalla;
	private Map<Double,Double> coordenadas = new TreeMap<Double,Double>();
	
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

	
}
