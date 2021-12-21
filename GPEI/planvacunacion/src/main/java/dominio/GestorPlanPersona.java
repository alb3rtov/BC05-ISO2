package dominio;

import java.util.ArrayList;

public class GestorPlanPersona {

	public static ArrayList<PlanVacunacion> buscarPlanesVacunacion() throws Exception{
		ArrayList<PlanVacunacion> planesEncontrados = new ArrayList<PlanVacunacion>();
		planesEncontrados = PlanVacunacion.readPlanes();
		return planesEncontrados;
	}
	
	public static ArrayList<String> buscasrEnfermedadesVacunas() throws Exception {
		ArrayList<String> enfermedades = new ArrayList<String>();
		enfermedades = PlanVacunacion.readEnfermedadesVacunas();
		return enfermedades;
	}
	
	public static boolean registrarPlan(String enfermedad) throws Exception{
		boolean registrado = false;
		
		PlanVacunacion plan = new PlanVacunacion(enfermedad);

		if (plan.insert() == 1) {
			registrado = true;
		}
		
		return registrado;
	}
}
