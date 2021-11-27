package enfermedades;
import java.sql.*;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Agente: "+Agente.getAgente()+"\n");
		String query = "select * from PERSONAS;";
		Agente myAgent = new Agente();
		ResultSet result = null;
		try {
			result = myAgent.select(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Print query results
		while(result.next()) {
    		String dni = result.getString("DNI");
    		String nombre = result.getString("NOMBRE");
    		String apellido1 = result.getString("APELLIDO1");
    		String apellido2 = result.getString("APELLIDO2");
    		Date aprobador = result.getDate("F_NACIMIENTO");
    		System.out.println(nombre+" "+aprobador);
    	}
		
	}	

}
