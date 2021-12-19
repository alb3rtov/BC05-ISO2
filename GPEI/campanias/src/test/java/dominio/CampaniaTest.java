package dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class CampaniaTest {

	@Test
	public void testCampaniaIntStringStringIntFloatString() {
		Campania c = new Campania(1, "20-Diciembre", "1-Enero", 500, 75, "Covid");
	}

	@Test
	public void testGetId() {
		Campania c = new Campania(1, "20-Diciembre", "1-Enero", 500, 75, "Covid");
		assertEquals(1, c.getId());
	}

	@Test
	public void testGetFechaInicio() {
		Campania c = new Campania(1, "20-Diciembre", "1-Enero", 500, 75, "Covid");
		assertEquals("20-Diciembre", c.getFechaInicio());
	}

	@Test
	public void testGetFechaFin() {
		Campania c = new Campania(1, "20-Diciembre", "1-Enero", 500, 75, "Covid");
		assertEquals("1-Enero", c.getFechaFin());
	}

	@Test
	public void testGetCoste() {
		Campania c = new Campania(1, "20-Diciembre", "1-Enero", 500, 75, "Covid");
		assertEquals(500, c.getCoste(), 5);
	}

	@Test
	public void testGetEfectividad() {
		Campania c = new Campania(1, "20-Diciembre", "1-Enero", 500, 75, "Covid");
		assertEquals(75, c.getEfectividad(), 5);
	}

	@Test
	public void testGetEnfermedad() {
		Campania c = new Campania(1, "20-Diciembre", "1-Enero", 500, 75, "Covid");
		assertEquals("Covid", c.getEnfermedad());
	}

}