package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.Agente;

public class Estadisticas {
	
	public static ArrayList<String> estadoPersona() {
		ArrayList<String> list = new ArrayList<String>();
		ResultSet resultSetPersonas;
		
		try {
			resultSetPersonas = Agente.getAgente().select("select ESTADO, count(*) as PERSONAS from PERSONAS group by ESTADO;");
			while(resultSetPersonas.next()) {
				list.add(resultSetPersonas.getString(1));
				list.add(""+resultSetPersonas.getInt(2));
			}
			
		}
		 catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return list;
	}
	
	public static ArrayList<String> estadoEnfermedad() {
		ArrayList<String> list = new ArrayList<String>();
		ResultSet resultSetEnfermedades;
		
		try {
			
			resultSetEnfermedades = Agente.getAgente().select("select ESTADO, count(distinct ID_ENFERMEDAD) from PERSONAS join PERSONAS_ENFERMEDAD where PERSONAS.DNI = PERSONAS_ENFERMEDAD.DNI_PERSONA group by ESTADO order by ESTADO;");
			while(resultSetEnfermedades.next()) {
				list.add(resultSetEnfermedades.getString(1));
				list.add(""+resultSetEnfermedades.getInt(2));
			}
		}
		 catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return list;
	}
	
	public static int nEnfCatalogadas() {
		int nEnfermedades = 0;
		ResultSet resultSet;
		
		try {
			
			resultSet = Agente.getAgente().select("select count(*) from ENFERMEDADES;");
			if(resultSet.next()) nEnfermedades = resultSet.getInt(1);
		}
		 catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return nEnfermedades;
	}
	
	public static ArrayList<String> nCampaniasEnfermedad() {
		ArrayList<String> list = new ArrayList<String>();
		ResultSet resultSet;
		
		try {
			resultSet = Agente.getAgente().select("select (select NOMBRE from ENFERMEDADES where ID_ENFERMEDAD = CAMPANIAS.ID_ENFERMEDAD) as ENFERMEDAD, count(*) from CAMPANIAS group by ENFERMEDAD;");
			while(resultSet.next()) {
				list.add(resultSet.getString(1));
				list.add(""+resultSet.getInt(2));
			}
		}
		 catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return list;
	}
}
