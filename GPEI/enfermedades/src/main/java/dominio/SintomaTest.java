package dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SintomaTest {

	@Test
	public void testSintoma() {
		Sintoma s = new Sintoma(1,"Tos","Tos seca, duradera");
		//throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testGetId() {
		Sintoma s = new Sintoma(1,"Tos","Tos seca, duradera");
		assertEquals(1,s.getId());
		//throw new RuntimeException("not yet implemented");
	}
	
		
	@Test
	public void testGetNombre() {
		Sintoma s = new Sintoma(1,"Tos","Tos seca, duradera");
		assertEquals("Tos",s.getNombre());
		//throw new RuntimeException("not yet implemented");
	}

	
	
	@Test
	public void testGetDescripcion() {
		Sintoma s = new Sintoma(1,"Tos","Tos seca, duradera");
		assertEquals("Tos seca, duradera",s.getDescripcion());
		//throw new RuntimeException("not yet implemented");
	}

}
