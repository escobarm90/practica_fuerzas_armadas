package ar.edu.unlam.practica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.edu.unlam.practica.interfaces.Terrestre;
import ar.edu.unlam.practica.interfaces.Volador;
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
		Vehiculo avion2 = new Avion(2, "A-10");
		Avion avion3 = new Avion(3, "A-10");
		Tanque tanque1= new Tanque(3, "Renault FT");
		Vehiculo submarino1 = new Submarino(5,"A-10");
		
		
		
		argentina.agregarVehiculo(avion1);		
		argentina.agregarVehiculo(avion2);
		argentina.agregarVehiculo(avion3);	
		argentina.agregarVehiculo(tanque1);
		argentina.agregarVehiculo(submarino1);		

		assertEquals(4, argentina.getCapacidadDeDefensa(),0.1);
		
	}/*

	@Test
	public void queSePuedaCrearUnaBatalla() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3)
		

		assertEquals(100.5, argentina.getBatalla("San Lorenzo").getLatitud());
		assertEquals(20.3, argentina.getBatalla("San Lorenzo").getLongitud());

	}

		assertEquals(100.5, argentina.getBatalla("San Lorenzo").getLatitud(),0.01);
		assertEquals(20.3, argentina.getBatalla("San Lorenzo").getLongitud(),0.01);
	}	/*

	@Test
	public void queSePuedaPlanearLaBatallaSobreElOceano() {
	public void queSePuedaPresentarBatallaTerrestre() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion("0001", "A-10"));
		argentina.agregarVehiculo(new Avion("0002", "A-10"));
		argentina.agregarVehiculo(new Avion("0003", "F-102"));
		argentina.agregarVehiculo(new Avion("0004", "F-15"));
		argentina.agregarVehiculo(new Tanque("0005", "Renault FT"));
		argentina.agregarVehiculo(new Camion("0006", "T-72"));
		argentina.agregarVehiculo(new Camion("0007", "T-72"));
		argentina.agregarVehiculo(new Submarino("0008", "A-10"));
		argentina.agregarVehiculo(new Portaviones("0009", "A-10"));
		argentina.agregarVehiculo(new Destructor("0010", "A-10"));
		argentina.agregarVehiculo(new Destructor("0011", "A-10"));
		argentina.agregarVehiculo(new Hidroavion("0012", "A-10"));
		argentina.agregarVehiculo(new Anfibio("0012", "A-10"));

		argentina.crearBatalla("Terrestre", 100.5, 20.3, "San Lorenzo")

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));

		argentina.presentarBatalla()
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 5));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 6));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 7));		
	}

	@Test
	public void queSePuedaPresentarBatallaNaval() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));

		assertEquals(12, argentina.getCapacidadDeDefensa());
		argentina.crearBatalla("Pacifico", TipoDeBatalla.NAVAL, 200.5, 45.8);

		assertTrue(argentina.enviarALaBatalla("Pacifico", 8));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 9));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 10));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 11));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 12));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 13));		
	}

	@Test (expected = VehiculoIncompatible.class)
	public void queSeNoSePuedaEnviarAUnaBatallaEnTierraUnBarco() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 11));

	}

	@Test (expected = VehiculoInexistente.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 4));
	}*/

}
