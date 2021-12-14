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
	
	public static ArrayList<Medicina> readMedicinas(String nombreEnfermedad) {
		String str = new String(nombreEnfermedad);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Medicina> medicinasEncontradas = new ArrayList<Medicina>();
		
		int id;
		String enfermedad = nombreEnfermedad;
		String nombre;
		String organismo;
		
		try {
			int i = 0;
			int size = 0;
			Medicina medicina;
			
			//ResultSet resultSet = Agente.getAgente().select("select * from VACUNAS where ID_ENFERMEDAD = (SELECT ID_ENFERMEDAD FROM ENFERMEDADES WHERE NOMBRE='" + str + "')");
			ResultSet resultSet = Agente.getAgente().select("select m.ID_MEDICINA, m.NOMBRE, o.NOMBRE FROM MEDICINAS m join ENFERMEDAD_MEDICINA em on m.ID_MEDICINA=em.ID_MEDICINA join ORGANISMOS o on m.O_APROBADOR=o.ID_ORGANISMO join ENFERMEDADES e on em.ID_ENFERMEDAD=e.ID_ENFERMEDAD WHERE e.NOMBRE='"+str+"'");
			
			while (resultSet.next()) {
				list.add(resultSet.getString("m.ID_MEDICINA"));
				list.add(resultSet.getString("m.NOMBRE"));
				list.add(resultSet.getString("o.NOMBRE"));
			}
			
			while (list.size()/3 > i) {
				
				id = Integer.parseInt(list.get(0+size));
				nombre = list.get(1+size);
				organismo = list.get(2+size);
				i++;
				size +=3;
				
				medicina = new Medicina(id, nombre, organismo, enfermedad);
				medicinasEncontradas.add(medicina);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return medicinasEncontradas;
	}
	
	public static ArrayList<Sintoma> readSintomas(String nombreEnfermedad) {
		String str = new String(nombreEnfermedad);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Sintoma> sintomasEncontradas = new ArrayList<Sintoma>();
		
		int id;
		String nombre;
		String descripcion_s;
		
		try {
			int i = 0;
			int size = 0;
			Sintoma sintoma;
			
			//ResultSet resultSet = Agente.getAgente().select("select * from VACUNAS where ID_ENFERMEDAD = (SELECT ID_ENFERMEDAD FROM ENFERMEDADES WHERE NOMBRE='" + str + "')");
			ResultSet resultSet = Agente.getAgente().select("select s.ID_SINTOMA, s.NOMBRE, s.DESCRIPCION FROM SINTOMAS s join ENFERMEDAD_SINTOMAS es on s.ID_SINTOMA=es.ID_SINTOMA join ENFERMEDADES e on es.ID_ENFERMEDAD=e.ID_ENFERMEDAD where e.NOMBRE='"+str+"'");
			
			while (resultSet.next()) {
				list.add(resultSet.getString("s.ID_SINTOMA"));
				list.add(resultSet.getString("s.NOMBRE"));
				list.add(resultSet.getString("s.DESCRIPCION"));
			}
			
			while (list.size()/3 > i) {
				
				id = Integer.parseInt(list.get(0+size));
				nombre = list.get(1+size);
				descripcion_s = list.get(2+size);
				i++;
				size +=3;
				
				sintoma = new Sintoma(id, nombre, descripcion_s);
				sintomasEncontradas.add(sintoma);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sintomasEncontradas;
	}
	
	public static int deleteEnfermedad(int idEnfermedad) {
		int result = -1;
		
		try {
			result = Agente.getAgente().delete("delete from ENFERMEDADES where ID_ENFERMEDAD = '"+idEnfermedad+"';");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int updateEnfermedad(int idEnfermedad, String nombre, String descripcion, int temporalidad) {
		int result = -1;
		
		try {
			result = Agente.getAgente().update("update ENFERMEDADES set NOMBRE = '"+nombre+"', DESCRIPCION = '"+descripcion+"', TEMPORALIDAD = "+temporalidad+" where ID_ENFERMEDAD = '"+idEnfermedad+"';");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int updateEnfermedad(int idEnfermedad, String campo, int nuevoValor) {
		int result = -1;
		
		try {
			result = Agente.getAgente().update("update ENFERMEDADES set "+campo+" = '"+nuevoValor+"' where ID_ENFERMEDAD = '"+idEnfermedad+"';");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
}
