package dominio;

public class Vacuna {
	private int id;
	private String nombre;
	private String enfermedad;
	private int numDosis;
	
	public Vacuna(int id, String nombre, String enfermedad, int numDosis) {
		this.id = id;
		this.nombre = nombre;
		this.enfermedad = enfermedad;
		this.numDosis = numDosis;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getEnfermedad() {
		return this.enfermedad;
	}
	
	public int getNumDosis() {
		return this.numDosis;
	}
	
}
