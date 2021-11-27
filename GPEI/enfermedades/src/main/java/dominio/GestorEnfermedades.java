package dominio;
import java.util.ArrayList;

public class GestorEnfermedades {
	
	public static ArrayList<Enfermedad> buscarEnfermedad(String nombre) throws Exception{
		ArrayList<Enfermedad> enfermedadesEncontradas = new ArrayList<Enfermedad>();
		enfermedadesEncontradas = Enfermedad.read(nombre);
		return enfermedadesEncontradas;
	}
	
	public static boolean registrarEnfermedad(String nombre, String descripcion, String temporalidad) throws Exception{
		boolean registrado = false;
		
		Integer uTemporalidad = Integer.parseInt(temporalidad);
		
		Enfermedad enfermedad = new Enfermedad(nombre, descripcion, uTemporalidad);
		
		if (enfermedad.insert() == 1) {
			registrado = true;
		}
		
		return registrado;
	}
}
