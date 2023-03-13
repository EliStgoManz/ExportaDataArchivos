package datos;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Conexion {

	public Connection getConnection(String database) {

		Connection myConn = null;
		try {
			InitialContext ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource) env.lookup("jdbc/" + database);
			myConn = ds.getConnection();
		} catch (Exception ex) {
			System.out.println(Conexion.class.getName()
					+ " Se genero un error al solicitar la conexion a la base de datos [" + database + "]. ");
		} finally {
			if (myConn == null) {
				System.out.println(
						Conexion.class.getName() + " No se logro conectar con la base de datos [" + database + "]");
			}
		}
		return myConn;
	}

	public static void main(String[] args) {
		Conexion c = new Conexion();
		System.out.println(c.getConnection("bdpld_181108"));
		System.out.println(c.toString());
	}

	public void connectDatabase() {
		try {
			// We register the PostgreSQL driver
			// Registramos el driver de PostgresSQL
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}
			Connection connection = null;
			// Database connect

			//connection = DriverManager.getConnection("jdbc:postgresql://10.250.193.56:5434/dbpld", "postgres",
					//"ver9batim");

			 connection=DriverManager.getConnection("jdbc:postgresql//10.250.193.56:5434/bdpld_181108", "postgres", "ver9batim");

			boolean valid = connection.isValid(50000);
			System.out.println(valid ? "TEST OK" : "TEST FAIL");
		} catch (java.sql.SQLException sqle) {
			System.out.println("Error: " + sqle);
		}
	}
}
