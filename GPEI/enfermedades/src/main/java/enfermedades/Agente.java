package enfermedades;
import java.sql.*;

public class Agente implements ConstantesDB {
	private static Agente myAgent = null;
	private Connection dbConnection = null;
	//Class.forName("com.mysql.cj.jdbc.Driver");
	
	Agente() throws SQLException {
		dbConnection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
	}
	
	public static Agente getAgente() throws SQLException { // Patron Singleton
		if (myAgent == null)
			myAgent = new Agente();
		return myAgent;
	}
	
	public int create(String sentencia) throws SQLException {
		Statement stmt = dbConnection.createStatement();
		int res = stmt.executeUpdate(sentencia);
		stmt.close();
		return res;
	}
	
	public int insert(String sentencia) throws SQLException {
		Statement stmt = dbConnection.createStatement();
		int res = stmt.executeUpdate(sentencia);
		stmt.close();
		return res;
	}
	
	public int delete(String sentencia) throws SQLException {
		Statement stmt = dbConnection.createStatement();
		int res = stmt.executeUpdate(sentencia);
		stmt.close();
		return res;
	}
	
	public int update(String sentencia) throws SQLException {
		Statement stmt = dbConnection.createStatement();
		int res = stmt.executeUpdate(sentencia);
		stmt.close();
		return res;
	}
	
	public int ejecutar(String sentencia) throws SQLException {
		Statement stmt = dbConnection.createStatement();
		int res = stmt.executeUpdate(sentencia);
		stmt.close();
		return res;
	}
	
	public ResultSet select(String instruccion) throws SQLException {
		Statement stmt = dbConnection.createStatement();
		ResultSet set = stmt.executeQuery(instruccion);
		return set;
	}

}
