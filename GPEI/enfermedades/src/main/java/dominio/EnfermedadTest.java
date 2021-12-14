package dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnfermedadTest {
	@Test
	public void testGetId() {
		Enfermedad e = new Enfermedad(1,"covid","enfermedad",10);
		Enfermedad e1 = new Enfermedad("covid","enfemedad",2);
		assertEquals(1, e.getId());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetNombre() {
		Enfermedad e = new Enfermedad(3,"covid","enfermedad",5);
		assertEquals("covid", e.getNombre());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetDescripcion() {
		Enfermedad e = new Enfermedad(2,"covid","Respiratoria",3);
		assertEquals("Respiratoria", e.getDescripcion());
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetTemporalidad() {
		Enfermedad e = new Enfermedad(5,"covid","Contagiosa",10);
		assertEquals(10, e.getTemporalidad());
		//throw new RuntimeException("not yet implemented");
	}
	
	@Test
	public void insert() throws Exception {
		Enfermedad e = new Enfermedad(5,"covid","Contagiosa",10);
		int salida=e.insert();
		assertEquals(1, salida);
		throw new RuntimeException("not yet implemented");
	}
}
