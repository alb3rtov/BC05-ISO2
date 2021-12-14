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
	
	public static int eliminarEnfermedad(int id) throws Exception{
		int eliminado = Enfermedad.deleteEnfermedad(id);
		return eliminado;
	}
	
	public static int modificarEnfermedad(int id, String nombre, String descripcion, String temporalidad) throws Exception{
		Integer uTemporalidad = Integer.parseInt(temporalidad);
		int modificado = Enfermedad.updateEnfermedad(id, nombre, descripcion, uTemporalidad);
		return modificado;
	}
	
	public static ArrayList<Vacuna> buscarVacuna(String nombre) throws Exception{
		ArrayList<Vacuna> vacunasEncontradas = Enfermedad.readVacunas(nombre);
		return vacunasEncontradas;
	}
	
	public static ArrayList<Medicina> buscarMedicina(String nombre) throws Exception {
		ArrayList<Medicina> medicinasEncontradas = Enfermedad.readMedicinas(nombre);
		return medicinasEncontradas;
	}
	
	public static ArrayList<Sintoma> buscarSintoma(String nombre) throws Exception {
		ArrayList<Sintoma> sintomasEncontradas = Enfermedad.readSintomas(nombre);
		return sintomasEncontradas;
	}
	
}
