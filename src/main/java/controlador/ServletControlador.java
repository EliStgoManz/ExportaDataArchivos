package controlador;

import java.io.IOException;
import java.io.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import datos.ClienteDato;
import entidad.LayoutCliente;
import org.apache.poi.hssf.usermodel.*;

/*@Elaboro: @Eli Santiago Manzano**/

@WebServlet("/ServeletControlador")
public class ServletControlador extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<LayoutCliente> clientes = new ClienteDato().listar();

		response.setContentType("application/vnd.ms-excel");

		response.setHeader("Content-Disposition", "attachment;filename=listado-clientes.xls");

		HSSFWorkbook libro = new HSSFWorkbook();

		HSSFSheet hoja = libro.createSheet("clientes");

		// estilos para celdas
		// Negritas
		HSSFFont fontBold = libro.createFont();

		HSSFCellStyle cellBold = libro.createCellStyle();
		cellBold.setFont(fontBold);

		// Alineado derecha
		HSSFCellStyle cellRight = libro.createCellStyle();

		// Alineado derecha negrita
		HSSFCellStyle cellRightBold = libro.createCellStyle();

		cellRightBold.setFont(fontBold);

		// Encabezado Firma
		HSSFCellStyle cellEncabezadoFirma = libro.createCellStyle();

		// Firma
		HSSFCellStyle cellFirma = libro.createCellStyle();

		// Encabezado
		HSSFCellStyle cellHeader = libro.createCellStyle();

		// Detalle
		HSSFCellStyle cellDetail = libro.createCellStyle();

		// Detalle Centrado
		HSSFCellStyle cellDetailCentrado = libro.createCellStyle();

		// Detalle Entero
		HSSFCellStyle cellDetailEntero = libro.createCellStyle();

		// Detalle Decimal
		HSSFDataFormat formatDecimal = libro.createDataFormat();
		HSSFCellStyle cellDetailDecimal = libro.createCellStyle();
		// cellDetailDecimal.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellDetailDecimal.setDataFormat(formatDecimal.getFormat("###,###,###,##0.00"));

		// Detalle Importe
		HSSFDataFormat formatImporte = libro.createDataFormat();
		HSSFCellStyle cellDetailImporte = libro.createCellStyle();
		// cellDetailImporte.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellDetailImporte.setDataFormat(formatImporte.getFormat("$###,###,###,##0.00"));

		// Total
		HSSFCellStyle cellTotal = libro.createCellStyle();

		cellTotal.setDataFormat(formatImporte.getFormat("$###,###,###,##0.00"));
		cellTotal.setFont(fontBold);

		// row y col de maniobra
		HSSFRow row = null;
		HSSFCell col = null;

		// Nombre reporte
		row = hoja.createRow(3);
		col = row.createCell(2);
		col.setCellValue(new HSSFRichTextString("Informacion obtenida sobre cliente."));
		col.setCellStyle(cellBold);

		int cellnum = 0;

		// Encabezado

		// Creacion de las columnas en el documento de excel

		row = hoja.createRow(5);
		col = row.createCell(0);
		col.setCellValue(new HSSFRichTextString("ID empresa"));
		col.setCellStyle(cellHeader);

		col = row.createCell(1);
		col.setCellValue(new HSSFRichTextString("ID persona"));
		col.setCellStyle(cellHeader);

		col = row.createCell(2);
		col.setCellValue(new HSSFRichTextString("tipo persona"));
		col.setCellStyle(cellHeader);

		col = row.createCell(3);
		col.setCellValue(new HSSFRichTextString("CVE_Rol"));
		col.setCellStyle(cellHeader);


		col = row.createCell(4);
		col.setCellValue(new HSSFRichTextString("id cliente"));
		col.setCellStyle(cellHeader);

		col = row.createCell(5);
		col.setCellValue(new HSSFRichTextString("cliente_padre"));
		col.setCellStyle(cellHeader);

		col = row.createCell(6);
		col.setCellValue(new HSSFRichTextString("Estatus cliente"));
		col.setCellStyle(cellHeader);

		col = row.createCell(7);
		col.setCellValue(new HSSFRichTextString("nombre persona"));
		col.setCellStyle(cellHeader);

		col = row.createCell(8);
		col.setCellValue(new HSSFRichTextString("apellido paterno"));
		col.setCellStyle(cellHeader);

		col = row.createCell(9);
		col.setCellValue(new HSSFRichTextString("apellido materno"));
		col.setCellStyle(cellHeader);

		col = row.createCell(10);
		col.setCellValue(new HSSFRichTextString("razon social"));
		col.setCellStyle(cellHeader);

		col = row.createCell(11);
		col.setCellValue(new HSSFRichTextString("nacionalidad"));
		col.setCellStyle(cellHeader);

		col = row.createCell(12);
		col.setCellValue(new HSSFRichTextString("calidad migratoria"));
		col.setCellStyle(cellHeader);

		col = row.createCell(13);
		col.setCellValue(new HSSFRichTextString("cve sucursal"));
		col.setCellStyle(cellHeader);

		col = row.createCell(14);
		col.setCellValue(new HSSFRichTextString("id agente"));
		col.setCellStyle(cellHeader);

		col = row.createCell(15);
		col.setCellValue(new HSSFRichTextString("calle"));
		col.setCellStyle(cellHeader);

		col = row.createCell(16);
		col.setCellValue(new HSSFRichTextString("numero exterior"));
		col.setCellStyle(cellHeader);

		col = row.createCell(17);
		col.setCellValue(new HSSFRichTextString("numero interior"));
		col.setCellStyle(cellHeader);

		col = row.createCell(18);
		col.setCellValue(new HSSFRichTextString("cve_pais"));
		col.setCellStyle(cellHeader);

		col = row.createCell(19);
		col.setCellValue(new HSSFRichTextString("cve estado"));
		col.setCellStyle(cellHeader);

		col = row.createCell(20);
		col.setCellValue(new HSSFRichTextString("cve colonia"));
		col.setCellStyle(cellHeader);

		col = row.createCell(21);
		col.setCellValue(new HSSFRichTextString("cve municipio"));
		col.setCellStyle(cellHeader);

		col = row.createCell(22);
		col.setCellValue(new HSSFRichTextString("codigo postal"));
		col.setCellStyle(cellHeader);

		col = row.createCell(23);
		col.setCellValue(new HSSFRichTextString("cve localidad"));
		col.setCellStyle(cellHeader);

		col = row.createCell(24);
		col.setCellValue(new HSSFRichTextString("telefono casa"));
		col.setCellStyle(cellHeader);

		col = row.createCell(25);
		col.setCellValue(new HSSFRichTextString("num tel. celular"));
		col.setCellStyle(cellHeader);

		col = row.createCell(26);
		col.setCellValue(new HSSFRichTextString("email"));
		col.setCellStyle(cellHeader);

		col = row.createCell(27);
		col.setCellValue(new HSSFRichTextString("fecha nacimiento"));
		col.setCellStyle(cellHeader);

		col = row.createCell(28);
		col.setCellValue(new HSSFRichTextString("fecha constitucion"));
		col.setCellStyle(cellHeader);

		col = row.createCell(29);
		col.setCellValue(new HSSFRichTextString("cve pais nac./constitucion"));
		col.setCellStyle(cellHeader);

		col = row.createCell(30);
		col.setCellValue(new HSSFRichTextString("curp"));
		col.setCellStyle(cellHeader);

		col = row.createCell(31);
		col.setCellValue(new HSSFRichTextString("rfc cliente"));
		col.setCellStyle(cellHeader);

		col = row.createCell(32);
		col.setCellValue(new HSSFRichTextString("actividad economica"));
		col.setCellStyle(cellHeader);

		col = row.createCell(33);
		col.setCellValue(new HSSFRichTextString("cve_fuente_ingresos"));
		col.setCellStyle(cellHeader);

		col = row.createCell(34);
		col.setCellValue(new HSSFRichTextString("ingreso mensual"));// agregar
																	// celda
																	// vacia
		col.setCellStyle(cellHeader);

		col = row.createCell(35);
		col.setCellValue(new HSSFRichTextString("cve_ocupacion"));// agregar
																	// celda
																	// vacia
		col.setCellStyle(cellHeader);

		col = row.createCell(36);
		col.setCellValue(new HSSFRichTextString("cve_giro"));// agregar celda
																// vacia
		col.setCellStyle(cellHeader);

		col = row.createCell(37);
		col.setCellValue(new HSSFRichTextString("sw_cotiza bolsa"));// agregar
																	// celda
																	// vacia
		col.setCellStyle(cellHeader);

		col = row.createCell(38);
		col.setCellValue(new HSSFRichTextString("ds_nombre bolsa"));// agregar
																	// vacio
		col.setCellStyle(cellHeader);

		col = row.createCell(39);
		col.setCellValue(new HSSFRichTextString("ds_identificacion"));
		col.setCellStyle(cellHeader);

		col = row.createCell(40);
		col.setCellValue(new HSSFRichTextString("cve_emisor_identificacion"));// agregar
																				// vacia-checar
																				// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(41);
		col.setCellValue(new HSSFRichTextString("cve_tipo_identificacion"));// agregar
																			// vacio
		col.setCellStyle(cellHeader);

		col = row.createCell(42);
		col.setCellValue(new HSSFRichTextString("fec_vigencia_identificacion"));// agregar
																				// vacio
		col.setCellStyle(cellHeader);

		col = row.createCell(43);
		col.setCellValue(new HSSFRichTextString("ds_identificacion2"));// agregar
																		// vacio_checar
																		// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(44);
		col.setCellValue(new HSSFRichTextString("cve_emisor_identificacion2"));// agregar
																				// vacio_checar
																				// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(45);
		col.setCellValue(new HSSFRichTextString("cve_tipo_identificacion2"));// agregar
																				// vacio_checar
																				// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(46);
		col.setCellValue(new HSSFRichTextString("fec_vigencia_identificacion"));// agregar
																				// vacio_checar
																				// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(47);
		col.setCellValue(new HSSFRichTextString("fotograf�a"));// agregar
																// vacio_checar
																// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(48);
		col.setCellValue(new HSSFRichTextString("cve_genero"));// agregar
																// vacio_checar
																// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(49);
		col.setCellValue(new HSSFRichTextString("cve_estado_nacimiento"));// agregar
																			// vacio_checar
																			// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(50);
		col.setCellValue(new HSSFRichTextString("no. transacciones_med_dep"));// agregar
																				// vacio_checar
																				// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(51);
		col.setCellValue(new HSSFRichTextString("monto trx mes_dep"));// agregar
																		// vacio_checar
																		// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(52);
		col.setCellValue(new HSSFRichTextString("origen recursos"));// agregar
																	// vacio_checar
																	// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(53);
		col.setCellValue(new HSSFRichTextString("destino recursos"));// agregar
																		// vacio_checar
																		// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(54);
		col.setCellValue(new HSSFRichTextString("rango num operaciones"));// agregar
																			// vacio_checar
																			// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(55);
		col.setCellValue(new HSSFRichTextString("rango monto op."));// agregar
																	// vacio_checar
																	// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(56);
		col.setCellValue(new HSSFRichTextString("rango aportaciones."));// agregar
																		// vacio_checar
																		// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(57);
		col.setCellValue(new HSSFRichTextString("rango monto aportaciones."));// agregar
																				// vacio_checar
																				// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(58);
		col.setCellValue(new HSSFRichTextString("rango retiros"));// agregar
																	// vacio_checar
																	// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(59);
		col.setCellValue(new HSSFRichTextString("rango monto retiros."));// agregar
																			// vacio_checar
																			// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(60);
		col.setCellValue(new HSSFRichTextString("cve_nivel_riesgo."));// agregar
																		// vacio_checar
																		// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(61);
		col.setCellValue(new HSSFRichTextString("id declarativa prop"));// agregar
																		// vacio_checar
																		// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(62);
		col.setCellValue(new HSSFRichTextString("id declarativa pep."));// agregar
																		// vacio_checar
																		// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(63);
		col.setCellValue(new HSSFRichTextString("tipo pep."));// agregar
																// vacio_checar
																// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(64);
		col.setCellValue(new HSSFRichTextString("ds pep_relacionado."));// agregar
																		// vacio_checar
																		// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(65);
		col.setCellValue(new HSSFRichTextString("ds_geolocalizacion."));// agregar
																		// vacio_checar
																		// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(66);
		col.setCellValue(new HSSFRichTextString("refexdig"));// agregar
																// vacio_checar
																// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(67);
		col.setCellValue(new HSSFRichTextString("ds poderes"));// agregar
																// vacio_checar
																// consulta
		col.setCellStyle(cellHeader);

		col = row.createCell(68);
		col.setCellValue(new HSSFRichTextString("porcentaje participacion."));
		col.setCellStyle(cellHeader);

		col = row.createCell(69);
		col.setCellValue(new HSSFRichTextString("num act"));
		col.setCellStyle(cellHeader);

		col = row.createCell(70);
		col.setCellValue(new HSSFRichTextString("num folio"));
		col.setCellStyle(cellHeader);

		col = row.createCell(71);
		col.setCellValue(new HSSFRichTextString("certificado fiel"));
		col.setCellStyle(cellHeader);

		col = row.createCell(72);
		col.setCellValue(new HSSFRichTextString("fec protocolizaci�n"));
		col.setCellStyle(cellHeader);

		col = row.createCell(73);
		col.setCellValue(new HSSFRichTextString("cve_riesgo_credito"));
		col.setCellStyle(cellHeader);

		col = row.createCell(74);
		col.setCellValue(new HSSFRichTextString("cve_medio vinculacion"));
		col.setCellStyle(cellHeader);

		col = row.createCell(75);
		col.setCellValue(new HSSFRichTextString("cve_perioridad"));
		col.setCellStyle(cellHeader);

		col = row.createCell(76);
		col.setCellValue(new HSSFRichTextString("biometria"));
		col.setCellStyle(cellHeader);

		col = row.createCell(77);
		col.setCellValue(new HSSFRichTextString("prueba vida"));
		col.setCellStyle(cellHeader);

		col = row.createCell(78);
		col.setCellValue(new HSSFRichTextString("ide anv. rev."));
		col.setCellStyle(cellHeader);

		col = row.createCell(79);
		col.setCellValue(new HSSFRichTextString("ide audio"));
		col.setCellStyle(cellHeader);

		col = row.createCell(80);
		col.setCellValue(new HSSFRichTextString("ide disp elect."));
		col.setCellStyle(cellHeader);

		col = row.createCell(81);
		col.setCellValue(new HSSFRichTextString("Notaria"));
		col.setCellStyle(cellHeader);

		int nrow = 6;
		int contador = 0;

		for (int i = 0; i < clientes.size(); i++) {

			row = hoja.createRow(nrow++);
			String id_empresa = "1";
			String estatus = "1";
			contador++;

			col = row.createCell(0);
			col.setCellValue(id_empresa);
			col.setCellStyle(cellDetailCentrado);

			col = row.createCell(1);
			col.setCellValue(clientes.get(i).getSalesForce());

			col = row.createCell(2);
			col.setCellValue(clientes.get(i).getTipoPersona());
			col.setCellStyle(cellDetailCentrado);

			col = row.createCell(3);
			col.setCellValue(clientes.get(i).getTipoP());
			col.setCellStyle(cellDetailCentrado);

			col = row.createCell(4);
			col.setCellValue(contador);
			col.setCellStyle(cellDetailCentrado);

			col = row.createCell(5);
			col.setCellValue(clientes.get(i).getClientePadre());
			col.setCellStyle(cellDetailCentrado);

			col = row.createCell(6);
			col.setCellValue(estatus);
			col.setCellStyle(cellDetailCentrado);

			col = row.createCell(7);
			col.setCellValue(clientes.get(i).getNombre());

			col = row.createCell(8);
			col.setCellValue(clientes.get(i).getApellidoPaterno());

			col = row.createCell(9);
			col.setCellValue(clientes.get(i).getApellidoMaterno());

			col = row.createCell(10);
			col.setCellValue(clientes.get(i).getRazonsocial());

			col = row.createCell(11);
			col.setCellValue(clientes.get(i).getPaisnacim());

			col = row.createCell(15);
			col.setCellValue(clientes.get(i).getCalle());

			col = row.createCell(16);
			col.setCellValue(clientes.get(i).getNumExterior());

			col = row.createCell(17);
			col.setCellValue(clientes.get(i).getNumInterior());

			col = row.createCell(22);
			col.setCellValue(clientes.get(i).getCodPostal());

			col = row.createCell(24);
			col.setCellValue(clientes.get(i).getTelefono());

			col = row.createCell(26);
			col.setCellValue(clientes.get(i).getEmail());

			col = row.createCell(27);
			col.setCellValue(clientes.get(i).getFechaNacimiento());

			col = row.createCell(28);
			col.setCellValue(clientes.get(i).getFechaConstitucion());

			col = row.createCell(30);
			col.setCellValue(clientes.get(i).getCurp());

			col = row.createCell(31);
			col.setCellValue(clientes.get(i).getRfc());

			col = row.createCell(32);
			col.setCellValue(clientes.get(i).getActividadId());

			col = row.createCell(69);
			col.setCellValue(clientes.get(i).getNumeroEscritura());

			col = row.createCell(72);
			col.setCellValue(clientes.get(i).getFechaEscritura());

			col = row.createCell(81);
			col.setCellValue(clientes.get(i).getNotaria());

			System.out.println("actividad economica: " + clientes.get(i).getActividadId());

			col = row.createCell(39);
			col.setCellValue(clientes.get(i).getIdentificaId());

			if (clientes.get(i).getTipoPerson().equals("M")) {
				contador++;
				row = hoja.createRow(nrow++);
				String tipoPersonal = "1";

				col = row.createCell(0);
				col.setCellValue(id_empresa);
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(2);
				col.setCellValue(tipoPersonal);
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(3);
				col.setCellValue(clientes.get(i).getTipoRl());
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(4);
				col.setCellValue(contador);
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(5);
				col.setCellValue(clientes.get(i).getClientePadre());
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(6);
				col.setCellValue(new HSSFRichTextString(estatus));
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(7);
				col.setCellValue(clientes.get(i).getNombreMoral());

				col = row.createCell(8);
				col.setCellValue(clientes.get(i).getApellidoPMoral());

				col = row.createCell(9);
				col.setCellValue(clientes.get(i).getApellidoMMoral());

				col = row.createCell(27);
				col.setCellValue(clientes.get(i).getFechaNacimientoRl());

				col = row.createCell(31);
				col.setCellValue(clientes.get(i).getRfcM());

			}

			hoja.autoSizeColumn(0);
			hoja.autoSizeColumn(1);
			hoja.autoSizeColumn(2);
			hoja.autoSizeColumn(3);
			hoja.autoSizeColumn(4);
			hoja.autoSizeColumn(5);
			hoja.autoSizeColumn(6);
			hoja.autoSizeColumn(7);
			hoja.autoSizeColumn(8);
			hoja.autoSizeColumn(9);
			hoja.autoSizeColumn(10);
			hoja.autoSizeColumn(11);
			hoja.autoSizeColumn(12);
			hoja.autoSizeColumn(13);
			hoja.autoSizeColumn(14);
			hoja.autoSizeColumn(15);
			hoja.autoSizeColumn(16);
			hoja.autoSizeColumn(17);
			hoja.autoSizeColumn(18);
			hoja.autoSizeColumn(19);
			hoja.autoSizeColumn(20);
			hoja.autoSizeColumn(21);
			hoja.autoSizeColumn(22);
			hoja.autoSizeColumn(23);
			hoja.autoSizeColumn(24);
			hoja.autoSizeColumn(25);
			hoja.autoSizeColumn(26);
			hoja.autoSizeColumn(27);
			hoja.autoSizeColumn(28);
			hoja.autoSizeColumn(29);
			hoja.autoSizeColumn(30);
			hoja.autoSizeColumn(31);
			hoja.autoSizeColumn(32);
			hoja.autoSizeColumn(33);
			hoja.autoSizeColumn(34);
			hoja.autoSizeColumn(35);
			hoja.autoSizeColumn(36);
			hoja.autoSizeColumn(37);
			hoja.autoSizeColumn(38);
			hoja.autoSizeColumn(39);
			hoja.autoSizeColumn(40);
			hoja.autoSizeColumn(41);
			hoja.autoSizeColumn(42);
			hoja.autoSizeColumn(43);
			hoja.autoSizeColumn(44);
			hoja.autoSizeColumn(45);
			hoja.autoSizeColumn(46);
			hoja.autoSizeColumn(47);
			hoja.autoSizeColumn(48);
			hoja.autoSizeColumn(49);
			hoja.autoSizeColumn(50);
			hoja.autoSizeColumn(51);
			hoja.autoSizeColumn(52);
			hoja.autoSizeColumn(53);
			hoja.autoSizeColumn(54);
			hoja.autoSizeColumn(55);
			hoja.autoSizeColumn(56);
			hoja.autoSizeColumn(57);
			hoja.autoSizeColumn(58);
			hoja.autoSizeColumn(59);
			hoja.autoSizeColumn(60);
			hoja.autoSizeColumn(61);
			hoja.autoSizeColumn(62);
			hoja.autoSizeColumn(63);
			hoja.autoSizeColumn(64);
			hoja.autoSizeColumn(65);
			hoja.autoSizeColumn(66);
			hoja.autoSizeColumn(67);
			hoja.autoSizeColumn(68);
			hoja.autoSizeColumn(69);
			hoja.autoSizeColumn(70);
			hoja.autoSizeColumn(71);
			hoja.autoSizeColumn(72);
			hoja.autoSizeColumn(73);
			hoja.autoSizeColumn(74);
			hoja.autoSizeColumn(75);
			hoja.autoSizeColumn(76);
			hoja.autoSizeColumn(77);
			hoja.autoSizeColumn(78);
			hoja.autoSizeColumn(79);
			hoja.autoSizeColumn(80);
			hoja.autoSizeColumn(81);

			System.out.println(contador);
			System.out.println("tama�o de array clientes= " + clientes.size());
			System.out.println("tipo cliente = " + clientes.get(i).getTipoP().equalsIgnoreCase("CL"));
			System.out.println("tipo f= " + clientes.get(i).getTipoP().equals("CL"));
			System.out.println("determinar tipo person= " + clientes.get(i).getTipoPerson().equals("M"));
		

		}

		try {

			OutputStream out = response.getOutputStream();
			libro.write(out);
			out.close();
			
			
			
			System.out.println("exportaci�n datos clienteeeeeeeess..");
			System.out.println("consulta de los datos= " + clientes);
			response.sendRedirect("ClienteLayout.jsp");

		

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
