package dominio;

import java.util.ArrayList;

public class GestorPersona {
	
	public static ArrayList<Persona> buscarPersonas() throws Exception{
		ArrayList<Persona> personasEncontradas = new ArrayList<Persona>();
		personasEncontradas = Persona.readPersonas();
		return personasEncontradas;
	}
	
	
	public static boolean registrarPersona(String dni, String nombre, String apellido1, String apellido2, String sexo, String fechaNacimiento, String estado, String vulnerabilidad) throws Exception{
		boolean registrado = false;
		
		Persona persona = new Persona(dni, nombre, apellido1, apellido2, sexo, fechaNacimiento, estado, vulnerabilidad);
		
		if (persona.insert() == 1) {
			registrado = true;
		}
		
		return registrado;
	}
	
	public static int modificarPersona(String dni, String nombre, String apellido1, String apellido2, String sexo, String estado, String vulnerabilidad) throws Exception{
		int modificado = Persona.updatePersona(dni, nombre, apellido1, apellido2, sexo, estado, vulnerabilidad);
		return modificado;
	}
}
