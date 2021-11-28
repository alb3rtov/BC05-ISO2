package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.Agente;

public class Enfermedad {
	private int id;
	private String nombre;
	private String descripcion;
	private int temporalidad;
	
	public Enfermedad(int id, String nombre, String descripcion, int temporalidad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.temporalidad = temporalidad;
	}
	
	public Enfermedad(String nombre, String descripcion, int temporalidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.temporalidad = temporalidad;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public int getTemporalidad() {
		return this.temporalidad;
	}
	
	public int insert() throws Exception {
		int salida = 0;
		
		salida = Agente.getAgente().insert("insert into ENFERMEDADES (NOMBRE, DESCRIPCION, TEMPORALIDAD) values('"+this.nombre+"','"+this.descripcion+"',"+this.temporalidad+")");
		System.out.println(salida);
		return salida;
	}
	
	public static ArrayList<Enfermedad> readEnfermedad(String nombreEnfermedad) {
		ArrayList<String> list = new ArrayList<String>();
		ResultSet resultSet;
		String str = new String(nombreEnfermedad);
		ArrayList<Enfermedad> enfermedadesEncontradas = new ArrayList<Enfermedad>();
		
		int id;
		String nombre;
		String descripcion;
		int temporalidad;
	
		try {
			int i = 0;
			int size = 0;
			Enfermedad enfermedad;
			resultSet = Agente.getAgente().select("select ID_ENFERMEDAD, NOMBRE, DESCRIPCION, TEMPORALIDAD from ENFERMEDADES where lower(NOMBRE) like '%" + str.toLowerCase() + "%'");
			
			while (resultSet.next()) {
				list.add(resultSet.getString("ID_ENFERMEDAD"));
				list.add(resultSet.getString("NOMBRE"));
				list.add(resultSet.getString("DESCRIPCION"));
				list.add(resultSet.getString("TEMPORALIDAD"));
			}
			
			while (list.size()/4 > i) {
		
				id = Integer.parseInt(list.get(0+size));
				nombre = list.get(1+size);
				descripcion = list.get(2+size);
				if (list.get(3+size) == null) {
					temporalidad = -1;
				} else {
					temporalidad = Integer.parseInt(list.get(3+size));
				}
				 
				i++;
				size +=4;

				enfermedad = new Enfermedad(id, nombre, descripcion, temporalidad);
				enfermedadesEncontradas.add(enfermedad);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enfermedadesEncontradas;
	}
	
	public static ArrayList<Vacuna> readVacunas(String nombreEnfermedad) {
		String str = new String(nombreEnfermedad);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Vacuna> vacunasEncontradas = new ArrayList<Vacuna>();
		
		int id;
		String enfermedad = nombreEnfermedad;
		String nombre;
		int num_dosis;
		
		try {
			int i = 0;
			int size = 0;
			Vacuna vacuna;
			
			ResultSet resultSet = Agente.getAgente().select("select * from VACUNAS where ID_ENFERMEDAD = (SELECT ID_ENFERMEDAD FROM ENFERMEDADES WHERE NOMBRE='" + str + "')");
			
			while (resultSet.next()) {
				list.add(resultSet.getString("ID"));
				list.add(resultSet.getString("NOMBRE"));
				list.add(resultSet.getString("NUM_DOSIS"));
			}
			
			while (list.size()/3 > i) {
				
				id = Integer.parseInt(list.get(0+size));
				nombre = list.get(1+size);
				num_dosis = Integer.parseInt(list.get(2+size));
				i++;
				size +=3;
				
				vacuna = new Vacuna(id, nombre, enfermedad, num_dosis);
				vacunasEncontradas.add(vacuna);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vacunasEncontradas;
	}
}
