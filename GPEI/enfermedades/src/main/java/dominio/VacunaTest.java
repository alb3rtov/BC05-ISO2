package dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VacunaTest {

	@Test
	public void testVacuna() {
		Vacuna v = new Vacuna(1,"Moderna","Covid",2);
	}

	@Test
	public void testGetId() {
		Vacuna v = new Vacuna(1,"Moderna","Covid",2);
		assertEquals(1,v.getId());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetNombre() {
		Vacuna v = new Vacuna(1,"Moderna","Covid",2);
		assertEquals("Moderna",v.getNombre());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetEnfermedad() {
		Vacuna v = new Vacuna(1,"Moderna","Covid",2);
		assertEquals("Covid",v.getEnfermedad());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetNumDosis() {
		Vacuna v = new Vacuna(1,"Moderna","Covid",2);
		assertEquals(2,v.getNumDosis());
		//throw new RuntimeException("not yet implemented");
	}

}
