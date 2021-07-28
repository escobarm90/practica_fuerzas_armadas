package ar.edu.unlam.practica;

import java.util.Objects;

public abstract class Vehiculo{


	private Integer nroVehiculo;
	
	public Vehiculo(Integer nroVehiculo) {
		this.nroVehiculo = nroVehiculo;
		
	}
	
	public Integer getnroVehiculoVehiculo() {
		return nroVehiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nroVehiculo == null) ? 0 : nroVehiculo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (nroVehiculo == null) {
			if (other.nroVehiculo != null)
				return false;
		} else if (!nroVehiculo.equals(other.nroVehiculo))
			return false;
		return true;
	}


	




	

	
}
