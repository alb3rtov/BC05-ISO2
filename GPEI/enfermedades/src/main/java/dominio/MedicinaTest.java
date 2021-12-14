package dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MedicinaTest {

	@Test
	public void testMedicina() {
		Medicina m = new Medicina(1,"Paracetamol","cabeza","Cefalea");

	}

	@Test
	public void testGetId() {
		Medicina m = new Medicina(1,"Paracetamol","cabeza","Cefalea");
		assertEquals(1,m.getId());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetNombre() {
		Medicina m = new Medicina(1,"Paracetamol","cabeza","Cefalea");
		assertEquals("Paracetamol",m.getNombre());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetOrganismo() {
		Medicina m = new Medicina(1,"Paracetamol","cabeza","Cefalea");
		assertEquals("cabeza",m.getOrganismo());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetEnfermedad() {
		Medicina m = new Medicina(1,"Paracetamol","cabeza","Cefalea");
		assertEquals("Cefalea",m.getEnfermedad());
		//throw new RuntimeException("not yet implemented");
	}

}
