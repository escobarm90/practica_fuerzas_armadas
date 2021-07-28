package ar.edu.unlam.practica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unlam.practica.interfaces.Terrestre;
import ar.edu.unlam.practica.interfaces.Volador;
import ar.edu.unlam.practica.enums.TipoDeBatalla;
import ar.edu.unlam.practica.excepciones.VehiculoIncompatibleException;
import ar.edu.unlam.practica.excepciones.VehiculoInexistenteException;
import ar.edu.unlam.practica.interfaces.Acuatico;

public class FuerzasArmadasTest {
	
	@Test
	public void queSePuedaCrearUnObjetoVolador(){
		Vehiculo avion =  new Avion(1, "A-10");		
		assertEquals(0.0, ((Volador) avion).getAltura(),0.1);
	}

	@Test
	public void queSePuedaCrearUnObjetoTerrestre() {
		
		Terrestre tanque = new Tanque(5, "Renault FT");

		
		assertEquals(0.0, tanque.getVelocidad(), 0.1);
	}

	@Test
	public void queSePuedaCrearUnObjetoAcuatico() {
		Vehiculo submarino = new Submarino(8, "ARA - San Juan");
		
		assertEquals(0.0, ((Acuatico) submarino).getProfundidad(),0.1);
	}

	@Test
	public void queSePuedaCrearUnObjetoAnfibio() {
		Vehiculo var = new Anfibio(12, "LARC-5");
		

		assertEquals(0.0, ((Terrestre) var).getVelocidad(), 0.01);
		assertEquals(0.0, ((Acuatico) var).getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnHidroavion() {
		Vehiculo ag600 = new HidroAvion(12, "AG600");
		

		assertEquals(0.0, ((Volador) ag600).getAltura(), 0.01);
		assertEquals(0.0, ((Acuatico) ag600).getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaArmarElConvoy() {
		FuerzaArmada argentina = new FuerzaArmada();
		
		Vehiculo avion1 = new Avion(1, "A-10");
		Vehiculo avion2 = new Avion(2, "A-20");
		Vehiculo avion3 = new Avion(3, "A-30");
		Vehiculo tanque1= new Tanque(3, "Renault FT");
		Vehiculo tanque2= new Tanque(4, "Renault XT");
		Vehiculo submarino1 = new Submarino(4,"A-10");
		Vehiculo submarino2 = new Submarino(5,"A-20");
		
		
		argentina.agregarVehiculo(avion1);		
		argentina.agregarVehiculo(avion2);
		argentina.agregarVehiculo(avion3);	
		argentina.agregarVehiculo(tanque1);
		argentina.agregarVehiculo(tanque2);
		argentina.agregarVehiculo(submarino1);	
		argentina.agregarVehiculo(submarino2);
		
		assertEquals(5, argentina.getCapacidadDeDefensa(),0.1);
	
	}
	

	@Test
	public void queSePuedaCrearUnaBatalla() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		

		assertEquals(100.5, argentina.getBatalla("San Lorenzo").getLatitud(),0.1);
		assertEquals(20.3, argentina.getBatalla("San Lorenzo").getLongitud(),0.1);

	}

	
		

	@Test
	
	public void queSePuedaPresentarBatallaTerrestre() throws Exception {
		FuerzaArmada argentina = new FuerzaArmada();
		
		Vehiculo tanque1= new Tanque(1, "Renault FT");
		Vehiculo tanque2= new Tanque(2, "Renault XT");
		Vehiculo tanque3= new Tanque(3, "Renault RT");
		
		argentina.agregarVehiculo(tanque1);
		argentina.agregarVehiculo(tanque2);
		argentina.agregarVehiculo(tanque3);
		
		argentina.crearBatalla("San Lorenzo",TipoDeBatalla.TERRESTRE, 100.5, 20.3);


		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 1));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 2));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 3));	
		
	}

	@Test
	public void queSePuedaPresentarBatallaNaval() throws Exception {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));

		assertEquals(3, argentina.getCapacidadDeDefensa(),0.1);
		argentina.crearBatalla("Pacifico", TipoDeBatalla.NAVAL, 200.5, 45.8);

		assertTrue(argentina.enviarALaBatalla("Pacifico", 8));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 12));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 13));		
			
	}

	@Test (expected = VehiculoIncompatibleException.class)
	public void queSeNoSePuedaEnviarAUnaBatallaEnTierraUnBarco() throws Exception {
		FuerzaArmada argentina = new FuerzaArmada();

		Vehiculo tanque1= new Tanque(1, "Renault FT");
		Vehiculo tanque2= new Tanque(2, "Renault XT");
		Vehiculo submarino1 = new Submarino(3,"A-10");
		Vehiculo submarino2 = new Submarino(4,"A-20");
		
		argentina.agregarVehiculo(tanque1);
		argentina.agregarVehiculo(tanque2);
		argentina.agregarVehiculo(submarino1);
		argentina.agregarVehiculo(submarino2);

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		argentina.enviarALaBatalla("San Lorenzo", 3);

	}

	@Test (expected = VehiculoInexistenteException.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista() throws Exception {
		FuerzaArmada argentina = new FuerzaArmada();

		Vehiculo tanque1= new Tanque(1, "Renault FT");
		Vehiculo tanque2= new Tanque(2, "Renault XT");
		Vehiculo submarino1 = new Submarino(3,"A-10");
		Vehiculo submarino2 = new Submarino(4,"A-20");
		
		argentina.agregarVehiculo(tanque1);
		argentina.agregarVehiculo(tanque2);
		argentina.agregarVehiculo(submarino1);
		argentina.agregarVehiculo(submarino2);

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		argentina.enviarALaBatalla("San Lorenzo", 7);
	}

}
