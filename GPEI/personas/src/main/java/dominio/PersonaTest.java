package dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonaTest {

	@Test
	public void testPersona() {
		Persona p = new Persona("11111111W","Fernando","Gómez","Serrano","Hombre","19-2-2000","Enfermo","Alta");
	}

	@Test
	public void testGetDni() {
		Persona p = new Persona("11111111W","Fernando","Gómez","Serrano","Hombre","19-2-2000","Enfermo","Alta");
		assertEquals("11111111W",p.getDni());
	}

	@Test
	public void testGetNombre() {
		Persona p = new Persona("11111111W","Fernando","Gómez","Serrano","Hombre","19-2-2000","Enfermo","Alta");
		assertEquals("Fernando",p.getNombre());
	}

	@Test
	public void testGetApellido1() {
		Persona p = new Persona("11111111W","Fernando","Gómez","Serrano","Hombre","19-2-2000","Enfermo","Alta");
		assertEquals("Gómez",p.getApellido1());
	}

	@Test
	public void testGetApellido2() {
		Persona p = new Persona("11111111W","Fernando","Gómez","Serrano","Hombre","19-2-2000","Enfermo","Alta");
		assertEquals("Serrano",p.getApellido2());
	}

	@Test
	public void testGetSexo() {
		Persona p = new Persona("11111111W","Fernando","Gómez","Serrano","Hombre","19-2-2000","Enfermo","Alta");
		assertEquals("Hombre",p.getSexo());
	}

	@Test
	public void testGetFechaNacimiento() {
		Persona p = new Persona("11111111W","Fernando","Gómez","Serrano","Hombre","19-2-2000","Enfermo","Alta");
		assertEquals("19-2-2000",p.getFechaNacimiento());
	}

	@Test
	public void testGetEstado() {
		Persona p = new Persona("11111111W","Fernando","Gómez","Serrano","Hombre","19-2-2000","Enfermo","Alta");
		assertEquals("Enfermo",p.getEstado());
	}

	@Test
	public void testGetVulnerabilidad() {
		Persona p = new Persona("11111111W","Fernando","Gómez","Serrano","Hombre","19-2-2000","Enfermo","Alta");
		assertEquals("Alta",p.getVulnerabilidad());
	}


}
