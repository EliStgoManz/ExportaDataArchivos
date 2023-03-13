package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.poi.util.SystemOutLogger;

import entidad.LayoutRutaArchivo;

public class RutaArchivoDato {

	private static final String SQL_SELECT = "select ra.id_archivo as idArchivo," + "ra.nombre_archivo as nombreArchivo"
			+ "" + " FROM rutarchivos as ra";
	
    
	
	

	public List<LayoutRutaArchivo> listarRuta() {
		Connection conn = null;
		Conexion cnn = new Conexion();
		PreparedStatement stmt = null;
		ResultSet conjuntoDatos = null;
		LayoutRutaArchivo rutaArchi = null;

		List<LayoutRutaArchivo> rutas = new ArrayList<>();

		try {
			conn = cnn.getConnection("dbpld");
			stmt = conn.prepareStatement(SQL_SELECT);
			conjuntoDatos = stmt.executeQuery();

			while (conjuntoDatos.next()) {
				int idArchivo = conjuntoDatos.getInt("idArchivo");
				String nombreArchivo = conjuntoDatos.getString("nombreArchivo");
				
				
				System.out.println("id de archivo: "+ idArchivo);
				System.out.println("nombre de archivo: "+nombreArchivo);

				rutaArchi = new LayoutRutaArchivo(idArchivo, nombreArchivo);
				rutas.add(rutaArchi);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conjuntoDatos.close();
				conn.close();
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rutas;

	}
	
	public static void main(String[]args){
		RutaArchivoDato rad=new RutaArchivoDato();
		rad.listarRuta();
	}

}

