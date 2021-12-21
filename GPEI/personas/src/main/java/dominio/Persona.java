package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.Agente;

public class Persona {
	
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String sexo;
	private String fechaNacimiento;
	private String estado;
	private String vulnerabilidad;

	public Persona(String dni, String nombre, String apellido1, String apellido2, String sexo, String fechaNacimiento, String estado, String vulnerabilidad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
		this.vulnerabilidad = vulnerabilidad;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido1() {
		return this.apellido1;
	}
	
	public String getApellido2() {
		return this.apellido2;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	
	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public String getVulnerabilidad() {
		return this.vulnerabilidad;
	}
	
	public int insert() throws Exception {
		int salida = 0;
		salida = Agente.getAgente().insert("insert into PERSONAS (DNI, NOMBRE, APELLIDO1, APELLIDO2, F_NACIMIENTO, SEXO, ESTADO, VULNERABILIDAD) values('"+this.dni+"','"+this.nombre+"','"+this.apellido1+"','"+this.apellido2+"','"+this.fechaNacimiento+"','"+this.sexo+"','"+ this.estado +"','"+this.vulnerabilidad+"')");
		return salida;
	}
	
	public static int updatePersona(String dni, String nombre, String apellido1, String apellido2, String sexo, String estado, String vulnerabilidad) {
		int result = -1;
		
		try {
			result = Agente.getAgente().update("update PERSONAS set NOMBRE = '"+nombre+"', APELLIDO1 = '"+apellido1+"', APELLIDO2 = '"+apellido2+"', SEXO = '"+sexo+"', ESTADO = '"+estado+"', VULNERABILIDAD = '"+vulnerabilidad+"' where DNI = '"+dni+"';");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static ArrayList<Persona> readPersonas() {
		ArrayList<String> list = new ArrayList<String>();
		ResultSet resultSet;
		ArrayList<Persona> personasEncontradas = new ArrayList<Persona>();
		
		String dni;
		String nombre;
		String apellido1;
		String apellido2;
		String sexo;
		String fechaNacimiento;
		String estado;
		String vulnerabilidad;

		try {
			int i = 0;
			int size = 0;
			Persona persona;
			resultSet = Agente.getAgente().select("select DNI, NOMBRE, APELLIDO1, APELLIDO2, F_NACIMIENTO, SEXO, ESTADO, VULNERABILIDAD from PERSONAS");
			
			while (resultSet.next()) {
				list.add(resultSet.getString("DNI"));
				list.add(resultSet.getString("NOMBRE"));
				list.add(resultSet.getString("APELLIDO1"));
				list.add(resultSet.getString("APELLIDO2"));
				list.add(resultSet.getString("F_NACIMIENTO"));
				list.add(resultSet.getString("SEXO"));
				list.add(resultSet.getString("ESTADO"));
				list.add(resultSet.getString("VULNERABILIDAD"));
			}
			
			while (list.size()/8 > i) {
				dni = list.get(0+size);
				nombre = list.get(1+size);
				apellido1 = list.get(2+size);
				apellido2 = list.get(3+size);
				sexo = list.get(4+size);
				fechaNacimiento = list.get(5+size);
				estado = list.get(6+size);
				vulnerabilidad = list.get(7+size);

				i++;
				size +=8;

				persona = new Persona(dni, nombre, apellido1, apellido2, sexo, fechaNacimiento, estado, vulnerabilidad); 
				personasEncontradas.add(persona);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personasEncontradas;
	}
}
