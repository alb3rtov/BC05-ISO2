package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.Agente;

public class PlanVacunacion {
	private int ID;
	private String enfermedad;
	
	public PlanVacunacion(int ID, String enfermedad) {
		this.ID = ID;
		this.enfermedad = enfermedad;
	}
	
	public PlanVacunacion(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getEnfermedad() {
		return this.enfermedad;
	}
	
	public int insert() throws Exception {
		int salida = 0;
		ResultSet resultSet;
		resultSet = Agente.getAgente().select("SELECT ID_ENFERMEDAD FROM ENFERMEDADES WHERE NOMBRE ='" + this.enfermedad + "'");
		resultSet.next();
		String idEnfermedad = resultSet.getString("ID_ENFERMEDAD");
		salida = Agente.getAgente().insert("insert into CAMPANIA_VACUNACION (ID_ENFERMEDAD) values("+idEnfermedad+")");
		return salida;
	}
	
	public static ArrayList<String> readEnfermedadesVacunas() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> enfermedades = new ArrayList<String>();
		ResultSet resultSet;
		
		String enfermedad;
		try {
			int i = 0;
			int size = 0;
			resultSet = Agente.getAgente().select("SELECT e.NOMBRE from VACUNAS v join ENFERMEDADES e where v.ID_ENFERMEDAD = e.ID_ENFERMEDAD GROUP BY v.ID_ENFERMEDAD");
			
			while (resultSet.next()) {
				list.add(resultSet.getString("e.NOMBRE"));
			}
			
			while (list.size()/1 > i) {
				enfermedad = list.get(0+size);

				i++;
				size +=1;

				enfermedades.add(enfermedad);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return enfermedades;
	}
	
	public static ArrayList<PlanVacunacion> readPlanes() {
		ArrayList<String> list = new ArrayList<String>();
		ResultSet resultSet;
		ArrayList<PlanVacunacion> planesEncontrados = new ArrayList<PlanVacunacion>();
		
		int id;
		String enfermedad;
		
		try {
			int i = 0;
			int size = 0;
			PlanVacunacion planVacunacion;
			resultSet = Agente.getAgente().select("SELECT cv.ID_CAMPANIA_VACUNACION, e.NOMBRE FROM CAMPANIA_VACUNACION cv join ENFERMEDADES e WHERE cv.ID_ENFERMEDAD = e.ID_ENFERMEDAD");
			
			while (resultSet.next()) {
				list.add(resultSet.getString("cv.ID_CAMPANIA_VACUNACION"));
				list.add(resultSet.getString("e.NOMBRE"));

			}
			
			while (list.size()/2 > i) {
				id = Integer.parseInt(list.get(0+size));
				enfermedad = list.get(1+size);

				i++;
				size +=2;

				planVacunacion = new PlanVacunacion(id, enfermedad);
				planesEncontrados.add(planVacunacion);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return planesEncontrados;
	}
	
	public static boolean insertPersona(String dni, int campania, String fecha) {
		boolean inserted = false;
		int salida = -1;

		try {
			salida = Agente.getAgente().insert("insert into VACUNACION_PERSONAS (ID_PERSONA, ID_CAMPANIA_VACUNACION, FECHA) values ('"+dni+"',"+campania+",'"+fecha+"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(salida != -1) inserted = true;
		
		return inserted;
	}
}
