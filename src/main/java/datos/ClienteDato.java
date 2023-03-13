package datos;

import java.sql.*;
import java.util.*;
import entidad.LayoutCliente;

/*Elaboro: Eli Santiago Manzano*/

public class ClienteDato {

	private static final String SQL_SELECT = "select coalesce(ut.idcliente) as salesforce,"
			+ "case when c.tipopersona='F' then 1 when c.tipopersona='M' then 2 when c.tipopersona='X' then 4 when c.tipopersona='G' then 7 end as CVE_TIPO_PERSONA,"
			+ "c.tipopersona as tipoP," + "coalesce(ut.idcliente,'')as CLIENTE_PADRE,"
			+ "coalesce(nombre) as NOMBRE_PERSONA," + "coalesce(apellidopaterno) as APELLIDO_PATERNO,"
			+ "coalesce(apellidomaterno) as APELLIDO_MATERNO," + "coalesce(pm.rlnombre) as NOMBRE_MORAL,"
			+ "coalesce(pm.rlapellidopaterno)as PATERNO_MORAL," + "coalesce(pm.rlapellidomaterno)as MATERNO_MORAL,"
			+ "coalesce(pm.razonsocial,fc.razonsocial,gb.razonsocial,'') as DS_RAZON_SOCIAL,"
			+ "case when paisnacim is null then 0 when paisnacim='MX' then 1 else 2 end as CVE_NACIONALIDAD,"
			+ "domic.calle as DS_CALLE," + "domic.numexterior as NO_EXTERIOR," + "domic.numinterior as NO_INTERIOR,"
			+ "codpostal as CODIGO_POSTAL," + "telefono as NUM_TEL_CASA," + "c.email as EMAIL,"
			+ "coalesce(pf.fechanacimiento)as FECHA_NACIMIENTO," + "coalesce(pm.rlfechanacimiento)as FECHA_NAC_RL,"
			+ "coalesce(pm.fechaconstitucion,gb.fechacreacion)as FECHA_CONSTITUCION," + "coalesce(pf.curp)as CURP,"
			+ "coalesce(pf.rfc,pm.rfc,fc.rfc,gb.rfc,pm.rlrfc)as RFC_CLIENTE," + "coalesce(pm.rlrfc) as RFC_MORAL,"
			+ "coalesce(pf.actividad_id,pm.giro_id)as CVE_ACTIVIDAD_ECONOMICA,"
			+ "coalesce(pm.no_escritura) as numero_escritura," + "coalesce(pm.fecha) as fecha_escritura,"
			+ "coalesce(pm.notaria) as notaria," + "coalesce(pf.identifica_id,pm.rlidentifica_id)as DS_IDENTIFICACION"
			+ "" + " FROM avcliente as c" + " left join avpersonafisica as pf ON pf.cliente_id=c.cliente_id "
			+ " left join varusuariotransitorio as ut ON ut.idcliente=c.cliente_id"
			+ " left join avpersonamoral as pm ON pm.cliente_id=c.cliente_id "
			+ " left join avfideicomiso as fc ON fc.cliente_id=c.cliente_id "
			+ " left join avgobierno as gb ON gb.cliente_id=c.cliente_id "
			+ " left join avdomicilioext as domic ON domic.cliente_id=c.cliente_id WHERE ut.idcliente IN (select cliente_id from exportar) order by salesforce";

	public List<LayoutCliente> listar() {
		Connection conn = null;
		Conexion cnn = new Conexion();
		PreparedStatement stmt = null;
		ResultSet conjuntoResultados = null;
		LayoutCliente cliente = null;
		List<LayoutCliente> clientes = new ArrayList<>();

		try {
			/* Base prueba datos exportacion */
			// conn = cnn.getConnection("bdpld_181108");

			conn = cnn.getConnection("dbpld");
			System.out.println("conexion a base dbpld" + conn);
			stmt = conn.prepareStatement(SQL_SELECT);
			conjuntoResultados = stmt.executeQuery();

			while (conjuntoResultados.next()) {/*
												 * En bucle,posicione el cursor utilizando el metodo next y recupere
												 * datos de cada columna de la fila actual del objeto ResultSet
												 * utilizando metodos get, que representa un tipo de datos
												 */

				String salesforce = elimina2(conjuntoResultados.getString("salesforce"));
				String cveTipoPersona = conjuntoResultados.getString("cve_tipo_persona");
				String tipoP = determina(conjuntoResultados.getString("tipoP").charAt(0));
				String tipoPerson = (conjuntoResultados.getString("tipoP"));
				String tipoRl = representanteLegal(conjuntoResultados.getString("tipoP").charAt(0));
				String clientePadre = elimina2(conjuntoResultados.getString("cliente_padre"));
				String nombrePersona = conjuntoResultados.getString("nombre_persona");
				String nombre_moral = conjuntoResultados.getString("nombre_moral");
				String apellidoPaterno = conjuntoResultados.getString("apellido_paterno");
				String apellidoP_moral = conjuntoResultados.getString("paterno_moral");
				String apellidoMaterno = conjuntoResultados.getString("apellido_materno");
				String apellidom_moral = conjuntoResultados.getString("materno_moral");
				String dsRazonsocial = conjuntoResultados.getString("ds_razon_social");
				String cveNacionalidad = conjuntoResultados.getString("cve_nacionalidad");
				String dsCalle = conjuntoResultados.getString("ds_calle");
				String noExterior = conjuntoResultados.getString("no_exterior");
				String noInterior = conjuntoResultados.getString("no_interior");
				String codigoPostal = conjuntoResultados.getString("codigo_postal");
				String numTelCasa = conjuntoResultados.getString("num_tel_casa");
				String email = conjuntoResultados.getString("email");
				String fechaNacimiento = conjuntoResultados.getString("fecha_nacimiento");
				String fechaNacimientoRl = conjuntoResultados.getString("fecha_nac_rl");
				String fechaConstitucion = conjuntoResultados.getString("fecha_constitucion");
				String curp = conjuntoResultados.getString("curp");
				String rfcCliente = conjuntoResultados.getString("rfc_cliente");
				String rfcMoral = conjuntoResultados.getString("rfc_moral");
				String cveActividadEconomica = conjuntoResultados.getString("cve_actividad_economica");
				String numeroEscritura = conjuntoResultados.getString("numero_escritura");
				String fechaNotaria = conjuntoResultados.getString("fecha_escritura");
				String notaria = conjuntoResultados.getString("notaria");
				String dsIdentificacion = conjuntoResultados.getString("ds_identificacion");

				cliente = new LayoutCliente(salesforce, cveTipoPersona, tipoP, tipoRl, tipoPerson, clientePadre,
						nombrePersona, nombre_moral, apellidoPaterno, apellidoP_moral, apellidoMaterno, apellidom_moral,
						dsRazonsocial, cveNacionalidad, dsCalle, noExterior, noInterior, codigoPostal, numTelCasa,
						email, fechaNacimiento, fechaNacimientoRl, fechaConstitucion, curp, rfcCliente, rfcMoral,
						cveActividadEconomica, numeroEscritura, fechaNotaria, notaria, dsIdentificacion);

				clientes.add(cliente);

			} // fin del ciclo while

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			try {
				conjuntoResultados.close();
				conn.close();
				stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
				e.getNextException();
			}

		}
		return clientes;

	}

	/* Método para eliminar caracteres especiales */
	public String elimina(String cadena) {
		String aux = "";
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) != '-') {
				aux += cadena.charAt(i);
			}
		}
		return aux;
	}

	public String delete(String cadenita) {
		String aux = "";
		if (cadenita.length() > 0 || cadenita != null) {
			for (int i = 0; i < cadenita.length(); i++) {
				if (cadenita.charAt(i) != '-' & cadenita != null) {
					aux += cadenita.charAt(i);

				}
			}
		}
		return aux;
	}

	public String elimina2(String cadenitaa) {
		String aux = "";
		try {
			aux += cadenitaa.replaceAll("[^A-Za-z0-9]", "");
			System.out.println("remplazo de caracteres especiales!....!!");

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return aux;

	}

	/* Método para determinar si tipo de perssona es cliente */
	public String determina(char tipoCl) {
		return tipoCl == 'F' || tipoCl == 'M' || tipoCl == 'X' || tipoCl == 'G' ? "CL" : "";
	}

	public String representanteLegal(char tipoRl) {
		if (tipoRl == 'M') {
			return "RL";
		} else {
			return "";
		}
	}

	public String representanteLegalFis(char tipoRl) {
		if (tipoRl == 'F') {
			return "RL";

		} else {
			return "";
		}

	}

	public static void main(String[] args) {
		ClienteDato cl = new ClienteDato();
		System.out.println(cl.listar());
		System.out.println(cl.toString());

	}

}
