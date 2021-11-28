package dominio;

import java.util.ArrayList;

public class GestorEnfermedades {
	
	public static ArrayList<Enfermedad> buscarEnfermedad(String nombre) throws Exception{
		ArrayList<Enfermedad> enfermedadesEncontradas = new ArrayList<Enfermedad>();
		enfermedadesEncontradas = Enfermedad.readEnfermedad(nombre);
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
	
	public static ArrayList<Vacuna> buscarVacuna(String nombre) throws Exception{
		ArrayList<Vacuna> vacunasEncontradas = Enfermedad.readVacunas(nombre);
		return vacunasEncontradas;
	}
	
	public static ArrayList<Medicina> buscarMedicina(String nombre) throws Exception {
		ArrayList<Medicina> medicinasEncontradas = Enfermedad.readMedicinas(nombre);
		return medicinasEncontradas;
	}
}
