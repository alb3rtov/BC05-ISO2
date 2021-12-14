package dominio;

public class Medicina {
	private int id;
	private String nombre;
	private String organismo;
	private String enfermedad;
	
	public Medicina(int id, String nombre, String organismo, String enfermedad) {
		this.id = id;
		this.nombre = nombre;
		this.organismo = organismo;
		this.enfermedad = enfermedad;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getOrganismo() {
		return this.organismo;
	}
	
	public String getEnfermedad() {
		return this.enfermedad;
	}
	

}
