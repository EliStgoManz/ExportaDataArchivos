package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidad.LayoutArchivoCliente;

/*autor: Eli Santiago Manzano*/

public class ArchivoClienteDato {

	private static final String SQL_SELECT = "select ut.idcliente as salesforce," + "coalesce(pf.imagenid)as id_pf,"
			+ "coalesce(pf.imagendeclaratoria)as declaratoria_pf,"
			+ "coalesce(pf.imagencedulafiscal) as cedula_fiscal_pf," + "coalesce(pf.imagencurp) as curp_pf,"
			+ "coalesce(pm.imagenactaconstitutiva)as constitutiva_pm,"
			+ "coalesce(pm.imagencedulafiscal)as cedula_fiscal_pm," + "coalesce(pm.imagenrlid) as id_pm,"
			+ "coalesce(pm.imagenrlpodernotarial) as poder_notarial_pm,"
			+ "coalesce(pm.imagendeclaratoria) as declaratoria_pm," + "c.tipopersona as tipoP" + ""
			+ " FROM avcliente as c" + " left join avpersonafisica as pf ON pf.cliente_id=c.cliente_id"
			+ " left join avpersonamoral as pm ON pm.cliente_id=c.cliente_id"
			+ " left join varusuariotransitorio as ut on ut.idcliente=c.cliente_id";

	/*
	 * Será una exportación masiva de Archivos por lo que necesito aaceder a la
	 * data de todos los clientes,busque y encuentre sus archivos
	 * correspondientes ya sean personas fisicas o personas morales para tener
	 * acceso a todos los archivos necesitamos de un ID cliente
	 */

	/* Realizamos un método que liste a los clientes */
	public List<LayoutArchivoCliente> listarCliente() {

		Connection conn = null;
		Conexion cnn = new Conexion();
		PreparedStatement stmt = null;
		ResultSet conjuntoDatos = null;
		LayoutArchivoCliente arcli = null;

		/*
		 * tengo una lista de objeto con las propiedades de la clase
		 * LayoutCliente
		 */
		List<LayoutArchivoCliente> clientes = new ArrayList<>();

		try {
			conn = cnn.getConnection("dbpld");
			stmt = conn.prepareStatement(SQL_SELECT);
			conjuntoDatos = stmt.executeQuery();

			while (conjuntoDatos.next()) {
				/*
				 * este paso me ayudara a recorrer todos los clientes y
				 * determinar el tipo de persona para asi poder diferenciar los
				 * tipos de documentos que tiene cada persona
				 */

				String salesforce = conjuntoDatos.getString("salesforce");
				String tipoPersona = conjuntoDatos.getString("tipoP");
				String idPf = conjuntoDatos.getString("id_pf");
				String declaratoriaPf = conjuntoDatos.getString("declaratoria_pf");
				String cedulaFiscalPf = conjuntoDatos.getString("cedula_fiscal_pf");
				String curpPf = conjuntoDatos.getString("curp_pf");
				String constitutivaPm = conjuntoDatos.getString("constitutiva_pm");
				String cedulaFiscalPm = conjuntoDatos.getString("cedula_fiscal_pm");
				String idPm = conjuntoDatos.getString("id_pm");
				String poderNotarialPm = conjuntoDatos.getString("poder_notarial_pm");
				String declaratoriaPm = conjuntoDatos.getString("declaratoria_pm");

				arcli = new LayoutArchivoCliente(salesforce, tipoPersona, idPf, declaratoriaPf, cedulaFiscalPf, curpPf,
						constitutivaPm, cedulaFiscalPm, idPm, poderNotarialPm, declaratoriaPm);
				clientes.add(arcli);

			}

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);

		} finally {
			try {
				conjuntoDatos.close();
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return clientes;

	}

	public static void main(String[] args) {
		ArchivoClienteDato ac = new ArchivoClienteDato();
		ac.listarCliente();

	}

}

