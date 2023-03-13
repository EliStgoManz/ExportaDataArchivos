package datos;

import java.sql.*;
import java.util.*;
import entidad.LayoutArchivos;

public class ArchivoDato {

	private static final String SQL_SELECT = "select coalesce(pf.cliente_id,pm.cliente_id) as idPersona,"
			+ "case when c.tipopersona='F' then 'FISICA' when c.tipopersona='M' then 'MORAL' end as tipoDePersona,"
			+ "c.tipopersona as tipoP," + "coalesce(pf.imagenid) as dni_fisica,"
			+ "coalesce(pf.imagencedulafiscal) cedulaFiscal_fisica," + "coalesce(pm.imagenrlid) as dni_moral,"
			+ "coalesce(pm.imagencedulafiscal) as cedula_fiscal_moral,"
			+ "coalesce(pm.imagenrlpodernotarial) as poder_notarial,"
			+ "coalesce(pm.imagenactaconstitutiva)as  acta_constitutiva_moral" + "" + " FROM avcliente as c"
			+ " left join avpersonafisica as pf ON pf.cliente_id=c.cliente_id "
			+ " left join avpersonamoral as pm ON pm.cliente_id=c.cliente_id ";
	// + " left join avdomicilioext as domic ON domic.cliente_id=c.cliente_id";

	public List<LayoutArchivos> listar() {
		Connection conn = null;
		Conexion cnn = new Conexion();
		PreparedStatement stmt = null;
		ResultSet conjuntoResultados = null;
		LayoutArchivos archivo = null;
		List<LayoutArchivos> archivos = new ArrayList<>();

		try {
			conn = cnn.getConnection("dbpld");

			stmt = conn.prepareStatement(SQL_SELECT);
			conjuntoResultados = stmt.executeQuery();

			while (conjuntoResultados.next()) {
				String idPersona = conjuntoResultados.getString("idPersona");
				String tipoPersona = conjuntoResultados.getString("tipoDePersona");
				String tipoPerson = conjuntoResultados.getString("tipoP");
				String dniFisica = conjuntoResultados.getString("dni_fisica");
				String cedulaFiscalF = conjuntoResultados.getString("cedulaFiscal_fisica");
				String dnimoral = conjuntoResultados.getString("dni_moral");
				String cedulaFiscalM = conjuntoResultados.getString("cedula_fiscal_moral");
				String poderNotarial = conjuntoResultados.getString("poder_notarial");
				String actaConstitutiva = conjuntoResultados.getString("acta_constitutiva_moral");

				archivo = new LayoutArchivos(idPersona, tipoPersona, tipoPerson, dniFisica, cedulaFiscalF, dnimoral,
						cedulaFiscalM, poderNotarial, actaConstitutiva);

				archivos.add(archivo);

			}

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				conjuntoResultados.close();
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return archivos;

	}

	public static void main(String[] args) {
		ArchivoDato ad = new ArchivoDato();
		System.out.println(ad.listar());
		System.out.println(ad.toString());
	}

}


