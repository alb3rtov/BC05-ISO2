package dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlanVacunacionTest {

	@Test
	public void testPlanVacunacionIntString() {
		PlanVacunacion v = new PlanVacunacion(7,"Gripe");
		assertEquals(7,v.getID());
	}

	@Test
	public void testPlanVacunacionString() {
		PlanVacunacion v = new PlanVacunacion(7,"Gripe");
		assertEquals("Gripe",v.getEnfermedad());

	}

	@Test
	public void testGetID() {
		PlanVacunacion v = new PlanVacunacion(1,"Covid");
		assertEquals(1,v.getID());
	}

	@Test
	public void testGetEnfermedad() {
		PlanVacunacion v = new PlanVacunacion(1,"Covid");
		assertEquals("Covid",v.getEnfermedad());
	}

}
