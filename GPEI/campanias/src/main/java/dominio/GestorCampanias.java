package dominio;

import java.util.ArrayList;

public class GestorCampanias {
	
	public static ArrayList<Campania> buscarCampanias() throws Exception{
		ArrayList<Campania> campaniasEncontradas = new ArrayList<Campania>();
		campaniasEncontradas = Campania.readCampanias();
		return campaniasEncontradas;
	}
	
	public static boolean registrarCampania(String fechaInicio, String fechaFin, String coste, String efectividad, String enfermedad) throws Exception{
		boolean registrado = false;
		
		Campania campania = new Campania(fechaInicio, fechaFin, Integer.parseInt(coste), Float.parseFloat(efectividad), enfermedad);
		
		if (campania.insert() == 1) {
			registrado = true;
		}
		
		return registrado;
	}
}
