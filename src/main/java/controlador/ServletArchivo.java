package controlador;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/*Me esta dando problemas con las librer�as*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.*;

import datos.ArchivoDato;
import entidad.LayoutArchivos;

/*@Elaboro: @Eli Santiago Manzano*/

@WebServlet("/servletArchivos")
public class ServletArchivo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<LayoutArchivos> archivos = new ArchivoDato().listar();

		response.setContentType("application/xls");
		response.setHeader("Content-Disposition", "filename=exportacion_archivess.xls");

		HSSFWorkbook libro = new HSSFWorkbook();
		HSSFSheet hoja = libro.createSheet("archivos");

		// estilos para celdas
		// Negritascomo res
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
		cellDetailDecimal.setDataFormat(formatDecimal.getFormat("###,###,###,##0.00"));

		// Detalle Importe
		HSSFDataFormat formatImporte = libro.createDataFormat();
		HSSFCellStyle cellDetailImporte = libro.createCellStyle();
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
		col.setCellValue(new HSSFRichTextString("Informacion  de archivos"));
		col.setCellStyle(cellBold);

		int cellnum = 0;

		// creaci�n de las columnas en el documento de excel
		row = hoja.createRow(5);
		col = row.createCell(0);
		col.setCellValue(new HSSFRichTextString("ID persona"));
		col.setCellStyle(cellHeader);

		col = row.createCell(1);
		col.setCellValue(new HSSFRichTextString("tipo de persona"));
		col.setCellStyle(cellHeader);

		col = row.createCell(2);
		col.setCellValue(new HSSFRichTextString("clave del documento"));
		col.setCellStyle(cellHeader);

		col = row.createCell(3);
		col.setCellValue(new HSSFRichTextString("nombre de documento"));
		col.setCellStyle(cellHeader);

		col = row.createCell(4);
		col.setCellValue(new HSSFRichTextString("nombre de archivos"));
		col.setCellStyle(cellHeader);

		int nrow = 6;
		int contador = 0;

		for (int i = 0; i < archivos.size(); i++) {
			row = hoja.createRow(nrow++);
			String DNI = "DNI_FRONT";
			String cedula = "CEDULA_FISCAL";

			if (archivos.get(i).getTipoP().equals("M")) {
				row = hoja.createRow(nrow++);
				col = row.createCell(0);
				col.setCellValue(archivos.get(i).getIdPersona());
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(1);
				col.setCellValue(archivos.get(i).getTipoPersona());

				col = row.createCell(2);
				col.setCellValue("ACTA_CONSTITUTIVA");

				col = row.createCell(3);
				col.setCellValue("Acta Constitutiva");

				col = row.createCell(4);
				col.setCellValue(archivos.get(i).getActaConst());

			}

			if (archivos.get(i).getTipoP().equals("M")) {
				row = hoja.createRow(nrow++);
				col = row.createCell(0);
				col.setCellValue(archivos.get(i).getIdPersona());
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(1);
				col.setCellValue(archivos.get(i).getTipoPersona());

				col = row.createCell(2);
				col.setCellValue("CEDULA_FISCAL");

				col = row.createCell(3);
				col.setCellValue("Cedula Fiscal");

				col = row.createCell(4);
				col.setCellValue(archivos.get(i).getCedulaFisMor());

			}

			if (archivos.get(i).getTipoP().equals("M")) {
				row = hoja.createRow(nrow++);
				col = row.createCell(0);
				col.setCellValue(archivos.get(i).getIdPersona());
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(1);
				col.setCellValue(archivos.get(i).getTipoPersona());

				col = row.createCell(2);
				col.setCellValue("DNI_FRONT");

				col = row.createCell(3);
				col.setCellValue("Identificaci�n Oficial del Rep Legal Frontal");

				col = row.createCell(4);
				col.setCellValue(archivos.get(i).getDniMor());

			}

			if (archivos.get(i).getTipoP().equals("M")) {
				row = hoja.createRow(nrow++);

				col = row.createCell(0);
				col.setCellValue(archivos.get(i).getIdPersona());
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(1);
				col.setCellValue(archivos.get(i).getTipoPersona());

				col = row.createCell(2);
				col.setCellValue("PODER_NOTARIAL");

				col = row.createCell(3);
				col.setCellValue("Poder notarial del RL o apoderado Legal");

				col = row.createCell(4);
				col.setCellValue(archivos.get(i).getPoderNotarial());

			}

			if (archivos.get(i).getTipoP().equals("F")) {
				col = row.createCell(0);
				col.setCellValue(archivos.get(i).getIdPersona());
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(1);
				col.setCellValue(archivos.get(i).getTipoPersona());

				col = row.createCell(2);
				col.setCellValue("DNI_FRONT");

				col = row.createCell(3);
				col.setCellValue("Identificaci�n oficial Frontal");

				col = row.createCell(4);
				col.setCellValue(archivos.get(i).getDniFisi());

			}

			if (archivos.get(i).getTipoP().equals("F")) {

				row = hoja.createRow(nrow++);

				col = row.createCell(0);
				col.setCellValue(archivos.get(i).getIdPersona());
				col.setCellStyle(cellDetailCentrado);

				col = row.createCell(1);
				col.setCellValue(archivos.get(i).getTipoPersona());

				col = row.createCell(2);
				col.setCellValue("CEDULA_FISCAL");

				col = row.createCell(3);
				col.setCellValue("Cedula Fiscal");

				col = row.createCell(4);
				col.setCellValue(archivos.get(i).getCedulaFiscalFis());

				// System.out.println("cedula fiscal: " +
				// archivos.get(i).getCedulaFiscalFis());

				System.out.println("documento para generar en excel" + "_" + archivos.get(i).getIdPersona() + "_"
						+ "DOC" + "_" + archivos.get(i).getTipoPersona());

			}

			hoja.autoSizeColumn(0);
			hoja.autoSizeColumn(1);
			hoja.autoSizeColumn(2);
			hoja.autoSizeColumn(3);
			hoja.autoSizeColumn(4);

		}

		try {
			OutputStream out = response.getOutputStream();
			libro.write(out);
			out.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();

		}

		System.out.println("archivos de exportaci�n= " + archivos);
		System.out.println(archivos.size());
		request.setAttribute("archivos ", archivos);
		request.getRequestDispatcher("ClienteLayout.jsp").forward(request, response);

	}

}
