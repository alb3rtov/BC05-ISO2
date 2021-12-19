package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.Agente;

public class Campania {
	
	int id;
	String fechaInicio;
	String fechaFin;
	int coste;
	float efectividad;
	String enfermedad;
	
	public Campania(int id, String fechaInicio, String fechaFin, int coste, float efectividad, String enfermedad) {
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.coste = coste;
		this.efectividad = efectividad;
		this.enfermedad = enfermedad;
	}	
	
	public Campania(String fechaInicio, String fechaFin, int coste, float efectividad, String enfermedad) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.coste = coste;
		this.efectividad = efectividad;
		this.enfermedad = enfermedad;
	}	
	
	public int getId() {
		return this.id;
	}
	
	public String getFechaInicio() {
		return this.fechaInicio;
	}
	
	public String getFechaFin() {
		return this.fechaFin;
	}
	
	public float getCoste() {
		return this.coste;
	}
	
	public float getEfectividad() {
		return this.efectividad;
	}
	
	public String getEnfermedad() {
		return this.enfermedad;
	}
	
	public int insert() throws Exception {
		int salida = 0;
		
		salida = Agente.getAgente().insert("insert into CAMPANIAS (FECHA_INICIO, FECHA_FIN, COSTE, EFECTIVIDAD, ID_ENFERMEDAD) values('"+this.fechaInicio+"','"+this.fechaFin+"',"+this.coste+","+this.efectividad+",(SELECT ID_ENFERMEDAD FROM ENFERMEDADES where NOMBRE='"+this.enfermedad+"'))");
		System.out.println(salida);
		return salida;
	}
	
	public static ArrayList<Campania> readCampanias() {
		ArrayList<String> list = new ArrayList<String>();
		ResultSet resultSet;
		ArrayList<Campania> campaniasEncontradas = new ArrayList<Campania>();
		
		int id;
		String fechaInicio;
		String fechaFin;
		int coste;
		float efectividad;
		String enfermedad;
		
		try {
			int i = 0;
			int size = 0;
			Campania campania;
			resultSet = Agente.getAgente().select("select c.ID_CAMPANIA, c.FECHA_INICIO, c.FECHA_FIN, c.COSTE, c.EFECTIVIDAD, e.NOMBRE from CAMPANIAS c join ENFERMEDADES e on c.ID_ENFERMEDAD=e.ID_ENFERMEDAD");
			
			while (resultSet.next()) {
				list.add(resultSet.getString("c.ID_CAMPANIA"));
				list.add(resultSet.getString("c.FECHA_INICIO"));
				list.add(resultSet.getString("c.FECHA_FIN"));
				list.add(resultSet.getString("c.COSTE"));
				list.add(resultSet.getString("c.EFECTIVIDAD"));
				list.add(resultSet.getString("e.NOMBRE"));
			}
			
			while (list.size()/6 > i) {
		
				id = Integer.parseInt(list.get(0+size));
				fechaInicio = list.get(1+size);
				fechaFin = list.get(2+size);
				coste = Integer.parseInt(list.get(3+size));
				efectividad = Float.parseFloat(list.get(4+size));
				enfermedad = list.get(5+size);
				 
				i++;
				size +=6;

				campania = new Campania(id, fechaInicio, fechaFin, coste, efectividad, enfermedad);
				campaniasEncontradas.add(campania);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return campaniasEncontradas;
	}
}
