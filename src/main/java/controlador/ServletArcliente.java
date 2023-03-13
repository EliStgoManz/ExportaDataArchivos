package controlador;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.ArchivoClienteDato;
import datos.RutaArchivoDato;
import entidad.LayoutArchivoCliente;
import entidad.LayoutRutaArchivo;

/*Elaboro: Eli Santiago Manzano*/

@WebServlet("/ServeletArchiCliente")
public class ServletArcliente extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("***Exportacion-Cris Ennnngeeeellll!!***");

		/* Vamos a implmentar el List del objeto cliente Archivo */
		List<LayoutArchivoCliente> clientes = new ArchivoClienteDato().listarCliente();
		System.out.println("listado de archives-personas fisicas " + clientes);
		List<LayoutRutaArchivo> rutas = new RutaArchivoDato().listarRuta();
		System.out.println("id de ruta: " + rutas);								

		/*
		 * tenemos que realizar el ciclo for para que vaya recorriendo todos los
		 * datos del cliente: ya sea persona moral o fisica
		 * 
		 * 
		 */
		for (int i = 0; i < clientes.size(); i++) {
			for (int j = 0; j < rutas.size(); j++) {

				// aqui empezamos a recorrer los datos de las personas F�sicas.
				if (clientes.get(i).getTipoPersona().equals("F")) {

					// aqui necesito acceder a la carpeta ID de todos los
					// clientes
					// para
					// extraer esos archivos

					// Aqui debe de leer el atributo de id

					// Esta es la ruta donde se encuentran guardados los
					// documentos
					// ID DE PERSONA FISICA

					/*
					 * String zipFile = "C:/home/tomcat9/Carga/" +
					 * clientes.get(i).getSalesforce() + "/ID/" +
					 * clientes.get(i).getId() + "/";
					 */

					String zipFile = "/home/tomcat9/Carga/" + clientes.get(i).getSalesforce() + "/ID/"
							+ clientes.get(i).getId() + "/";

					// ruta de acceso para encontrar los archivos Cedula de
					// cliente

					/*
					 * String zipFileCedu = "C:/home/tomcat9/Carga/" +
					 * clientes.get(i).getSalesforce() + "/CEDULA/" +
					 * clientes.get(i).getCedula() + "/";
					 */

					String zipFileCedu = "/home/tomcat9/Carga/" + clientes.get(i).getSalesforce() + "/CEDULA/"
							+ clientes.get(i).getCedula() + "/";

					// ruta de acceso para encontrar los archivos de curp de
					// cliente

					/*
					 * String zipFileCurp = "C:/home/tomcat9/Carga/" +
					 * clientes.get(i).getSalesforce() + "/CURP/" +
					 * clientes.get(i).getCurp() + "/";
					 */

					String zipFileCurp = "/home/tomcat9/Carga/" + clientes.get(i).getSalesforce() + "/CURP/"
							+ clientes.get(i).getCurp() + "/";

					/*
					 * String zipFileDeclaratoria = "C:/home/tomcat9/Carga/" +
					 * clientes.get(i).getSalesforce() + "/DECLARATORIA/" +
					 * clientes.get(i).getDeclaratoria() + "/";
					 */

					String zipFileDeclaratoria = "/home/tomcat9/Carga/" + clientes.get(i).getSalesforce()
							+ "/DECLARATORIA/" + clientes.get(i).getDeclaratoria() + "/";

					System.out.println("contenido de carpeta ID : " + zipFile);
					System.out.println("contenido de carpeta cedula: " + zipFileCedu);
					System.out.println("contenido de carpeta curp: " + zipFileCurp);
					System.out.println("contenido de carpeta declaratoria: " + zipFileDeclaratoria);

					// System.out.println("que es lo que contiene zipFile2 : " +
					// zipFile2);

					// carpeta destino donde se alojaran los documentos
					/*
					 * Especificar la ruta donde se almacenaran los archivos al
					 * realizar una exportacion con java
					 */

					String extractFolder = rutas.get(j).getNombreArchivo();

					System.out.println("que esta cachando esta ruta?: " + extractFolder);

					String nombreArchivo = " ";

					try {
						int BUFFER = 2048;// definimos el tama�o del buffer
						File file = new File(zipFile);
						File fileCedu = new File(zipFileCedu);
						File fileCurp = new File(zipFileCurp);
						File fileDeclaratoria = new File(zipFileDeclaratoria);

						ZipFile zip = new ZipFile(file);
						ZipFile zipCedu = new ZipFile(fileCedu);
						ZipFile zipCurp = new ZipFile(fileCurp);
						ZipFile zipDeclaratoria = new ZipFile(fileDeclaratoria);

						System.out.println("evaluando archivos, Game Over... :) ...");

						// carpeta destino que contendra los archivos de los
						// clientes

						/* String newPath = extractFolder; */
						String newPath = extractFolder;

						System.out.println("se esta creando la carpeta destino " + newPath);
						// creamos la carpeta donde se almacenaran los archivos
						new File(newPath).mkdir();

						Enumeration zipFileEntries = zip
								.entries();/*
											 * interfaz normalizada para
											 * recorrer los elementos de una
											 * coleccion
											 */

						Enumeration zipFileEntriesCedu = zipCedu.entries();
						Enumeration zipFileEntriesCurp = zipCurp.entries();
						Enumeration zipFileEntriesDecla = zipDeclaratoria.entries();

						/*
						 * procesamos cada una de las entradas que se encuentren
						 * dentro de la carpeta ID de personas fisicas
						 */
						while (zipFileEntries.hasMoreElements()) {
							// hashMoreElements() : comprueba si ZipFile
							// contiene
							// mas elementos
							System.out.println("contiene el/los elementos:" + zipFileEntries.hasMoreElements());

							// toma la entrada de un archivo
							ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();

							/*
							 * M�todo para renombrar los archivos que han sido
							 * descomprimidos
							 */
							nombreArchivo = entry.getName();
							String fe = "";
							int k = nombreArchivo.lastIndexOf(".");
							if (k > 0) {
								fe = nombreArchivo.substring(k + 1);
							}

							System.out.println("Leyendo los archivos: " + entry);

							// obtiene el nombre de los
							String currentEntry = entry.getName();
							// destino de archivos, se almacenaran en la carpeta
							// a
							// crear
							File destFile = new File(newPath, currentEntry);

							/*
							 * getParentFile(): Esta funcion devuelve el archivo
							 * principal del objeto de archivo dado.
							 */
							File destinationParent = destFile.getParentFile();

							// se crea la direccion de la carpeta principal si
							// es
							// necesario
							destinationParent.mkdirs();

							if (!entry.isDirectory()) {

								System.out.println("se ha podido crear el archivo");

								BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));

								int currentByte;
								// se establece un buffer para escribir el
								// archivo
								byte data[] = new byte[BUFFER];
								// escribir el archivo actual en el disco

								// prueba para el nombramiento de los archivos

								FileOutputStream fos = new FileOutputStream(
										extractFolder + " " + clientes.get(i).getSalesforce() + "_" + "DOC" + "_"
												+ "ID_FRONT" + "_" + "FISICA." + fe);

								/*
								 * FileOutputStream fos = new
								 * FileOutputStream(clientes.get(i).
								 * getSalesforce() + "_" + "DOC" +"_"+
								 * "ID_FRONT" + "_" + "FISICA." + fe);
								 */

								BufferedOutputStream destino = new BufferedOutputStream(fos, BUFFER);

								// lee y escribe hasta encontrar el ultimo byte
								while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
									destino.write(data, 0, currentByte);

								}
								destino.flush();
								destino.close();
								is.close();

							}

						}

						/*
						 * procesamos cada una de las entradas de los documentos
						 * de la carpeta cedula de persona fisica
						 */
						while (zipFileEntriesCedu.hasMoreElements()) {

							// hashMoreElements() : comprueba si ZipFile
							// contiene
							// mas elementos
							System.out.println("contiene el/los elementos:" + zipFileEntriesCedu.hasMoreElements());

							// toma la entrada de un archivo
							ZipEntry entry = (ZipEntry) zipFileEntriesCedu.nextElement();

							/*
							 * Metodo para renombrar los archivos que han sido
							 * descomprimidos
							 */
							nombreArchivo = entry.getName();
							String fe = "";
							int k = nombreArchivo.lastIndexOf(".");
							if (k > 0) {
								fe = nombreArchivo.substring(k + 1);
							}

							System.out.println("Leyendo los archivos: " + entry);

							// obtiene el nombre de los
							String currentEntry = entry.getName();
							// destino de archivos, se almacenaran en la carpeta
							// a
							// crear
							File destFile = new File(newPath, currentEntry);

							/*
							 * getParentFile(): Esta funcion devuelve el archivo
							 * principal del objeto de archivo dado.
							 */
							File destinationParent = destFile.getParentFile();

							// se crea la direccopm de la carpeta principal si
							// es
							// necesario
							destinationParent.mkdirs();

							if (!entry.isDirectory()) {

								System.out.println("se ha podido crear el archivo");

								BufferedInputStream is = new BufferedInputStream(zipCedu.getInputStream(entry));

								int currentByte;
								// se establece un buffer para escribir el
								// archivo
								byte data[] = new byte[BUFFER];
								// escribir el archivo actual en el disco

								FileOutputStream fos = new FileOutputStream(
										extractFolder + " " + clientes.get(i).getSalesforce() + "_" + "DOC" + "_"
												+ "CEDULA" + "_" + "FISICA." + fe);

								BufferedOutputStream destino = new BufferedOutputStream(fos, BUFFER);

								// lee y escribe hasta encontrar el ultimo byte
								while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
									destino.write(data, 0, currentByte);

								}
								destino.flush();
								destino.close();
								is.close();

							}

						}

						/*
						 * procesamos cada una de las entradas de los documentos
						 * de la carpeta CURP de personas fisicas
						 */

						while (zipFileEntriesCurp.hasMoreElements()) {

							// hashMoreElements() : comprueba si ZipFile
							// contiene
							// mas elementos
							System.out.println("contiene el/los elementos:" + zipFileEntriesCurp.hasMoreElements());

							// toma la entrada de un archivo
							ZipEntry entry = (ZipEntry) zipFileEntriesCurp.nextElement();

							/*
							 * Metodo para renombrar los archivos que han sido
							 * descomprimidos
							 */
							nombreArchivo = entry.getName();
							String fe = "";
							int k = nombreArchivo.lastIndexOf(".");
							if (k > 0) {
								fe = nombreArchivo.substring(k + 1);
							}

							System.out.println("Leyendo los archivos: " + entry);

							// obtiene el nombre de los
							String currentEntry = entry.getName();
							// destino de archivos, se almacenaran en la carpeta
							// a
							// crear
							File destFile = new File(newPath, currentEntry);

							/*
							 * getParentFile(): Esta funcion devuelve el archivo
							 * principal del objeto de archivo dado.
							 */
							File destinationParent = destFile.getParentFile();

							// se crea la direccopm de la carpeta principal si
							// es
							// necesario
							destinationParent.mkdirs();

							if (!entry.isDirectory()) {

								System.out.println("se ha podido crear el archivo");

								BufferedInputStream is = new BufferedInputStream(zipCurp.getInputStream(entry));

								int currentByte;
								// se establece un buffer para escribir el
								// archivo
								byte data[] = new byte[BUFFER];
								// escribir el archivo actual en el disco

								FileOutputStream fos = new FileOutputStream(
										extractFolder + " " + clientes.get(i).getSalesforce() + "_" + "DOC" + "_"
												+ "CURP" + "_" + "FISICA." + fe);

								BufferedOutputStream destino = new BufferedOutputStream(fos, BUFFER);

								// lee y escribe hasta encontrar el ultimo byte
								while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
									destino.write(data, 0, currentByte);

								}
								destino.flush();
								destino.close();
								is.close();

							}

						}

						/*
						 * procesamos cada una de las entradas de los documentos
						 * de la carpeta Declaratoria de personas fisicas
						 */
						while (zipFileEntriesDecla.hasMoreElements()) {

							// hashMoreElements() : comprueba si ZipFile
							// contiene
							// mas elementos
							System.out.println("contiene el/los elementos:" + zipFileEntriesDecla.hasMoreElements());

							// toma la entrada de un archivo
							ZipEntry entry = (ZipEntry) zipFileEntriesDecla.nextElement();

							/*
							 * Metodo para renombrar los archivos que han sido
							 * descomprimidos
							 */
							nombreArchivo = entry.getName();
							String fe = "";
							int k = nombreArchivo.lastIndexOf(".");
							if (k > 0) {
								fe = nombreArchivo.substring(k + 1);
							}

							System.out.println("Leyendo los archivos: " + entry);

							// obtiene el nombre de los
							String currentEntry = entry.getName();
							// destino de archivos, se almacenaran en la carpeta
							// a
							// crear
							File destFile = new File(newPath, currentEntry);

							/*
							 * getParentFile(): Esta funcion devuelve el archivo
							 * principal del objeto de archivo dado.
							 */
							File destinationParent = destFile.getParentFile();

							// se crea la direccion de la carpeta principal si
							// es
							// necesario
							destinationParent.mkdirs();

							if (!entry.isDirectory()) {

								System.out.println("se ha podido crear el archivo");

								BufferedInputStream is = new BufferedInputStream(zipDeclaratoria.getInputStream(entry));

								int currentByte;
								// se establece un buffer para escribir el
								// archivo
								byte data[] = new byte[BUFFER];
								// escribir el archivo actual en el disco

								FileOutputStream fos = new FileOutputStream(
										extractFolder + " " + clientes.get(i).getSalesforce() + "_" + "DOC" + "_"
												+ "DECLARATORIA" + "_" + "FISICA." + fe);

								BufferedOutputStream destino = new BufferedOutputStream(fos, BUFFER);

								// lee y escribe hasta encontrar el ultimo byte
								while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
									destino.write(data, 0, currentByte);

								}
								destino.flush();
								destino.close();
								is.close();

							}

						}

						System.out.println("nueeeeeeeeeevoooo ");
						System.out.println("consulta de los datos= " + clientes);
						request.setAttribute("alerta", "OK");
						// request.getRequestDispatcher("exportacion.jsp").forward(request,
						// response);
						response.sendRedirect("exportacion.jsp?alerta=OK");
						// response.sendRedirect("exportacion.jsp");

					} catch (Exception e) {

						e.printStackTrace(System.out);
					}

				}

				// Ahora empezamos a evaluar los datos de las personas morales
				if (clientes.get(i).getTipoPersona().equals("M")) {

					System.out.println("se inicia con el recorrido de archivos, persona moral");

					// ruta a evaluar (en proceso)
					String zipFileConstitutiva = "/home/tomcat9/Carga/" + clientes.get(i).getSalesforce()
							+ "/ACTA_CONSTITUTIVA/" + clientes.get(i).getConstitutiva() + "/";
					String zipFileCedulaFis = "/home/tomcat9/Carga/" + clientes.get(i).getSalesforce() + "/CEDULA/"
							+ clientes.get(i).getCedulaPm() + "/";
					String zipFileDeclaratoria = "/home/tomcat9/Carga/" + clientes.get(i).getSalesforce()
							+ "/DECLARATORIA/" + clientes.get(i).getDeclaratoriaPm() + "/";
					String zipFileId = "/home/tomcat9/Carga/" + clientes.get(i).getSalesforce() + "/RL_ID/"
							+ clientes.get(i).getIdPm() + "/";
					String zipFilePoder = "/home/tomcat9/Carga/" + clientes.get(i).getSalesforce()
							+ "/RL_PODER_NOTARIAL/" + clientes.get(i).getPoderNotarial() + "/";

					// carpeta destino donde se alojaran los documentos
					String extractFolder = rutas.get(j).getNombreArchivo();
					String nombreArchivo = " ";

					try {
						int BUFFER = 2048;// definimos el tamanio del buffer
						File file = new File(zipFileConstitutiva);
						File fileCedula = new File(zipFileCedulaFis);
						File fileDeclaratoria = new File(zipFileDeclaratoria);
						File fileId = new File(zipFileId);
						File filePoder = new File(zipFilePoder);

						ZipFile zipConstitutiva = new ZipFile(file);
						ZipFile zipCedula = new ZipFile(fileCedula);
						ZipFile zipDeclaratoria = new ZipFile(fileDeclaratoria);
						ZipFile zipId = new ZipFile(fileId);
						ZipFile zipPoder = new ZipFile(filePoder);

						System.out.println("evaluando archivos personas morales, Game Over... :) ...");

						// carpeta destino que contendra los archivos de los
						// clientes
						String newPath = extractFolder;

						System.out.println("se esta creando la carpeta destino " + newPath);
						// creamos la carpeta donde se almacenaran los archivos
						new File(newPath).mkdir();

						Enumeration zipFileEntriesConstitutiva = zipConstitutiva
								.entries(); /*
											 * interfaz normalizada para
											 * recorrer los elementos de una
											 * coleccion
											 */
						Enumeration zipFileEntriesCedula = zipCedula.entries();
						Enumeration zipFileEntriesDeclaratoria = zipDeclaratoria.entries();
						Enumeration zipFileEntriesId = zipId.entries();
						Enumeration zipFileEntriesPoder = zipPoder.entries();

						while (zipFileEntriesConstitutiva.hasMoreElements()) {
							// hashMoreElements() : comprueba si ZipFile
							// contiene
							// mas elementos
							System.out.println(
									"contiene el/los elementos:" + zipFileEntriesConstitutiva.hasMoreElements());

							// toma la entrada de un archivo
							ZipEntry entry = (ZipEntry) zipFileEntriesConstitutiva.nextElement();

							/*
							 * Metodo para renombrar los archivos que han sido
							 * descomprimidos
							 */
							nombreArchivo = entry.getName();
							String fe = "";
							int k = nombreArchivo.lastIndexOf(".");
							if (k > 0) {
								fe = nombreArchivo.substring(k + 1);
							}

							System.out.println("Leyendo los archivos: " + entry);

							// obtiene el nombre de los
							String currentEntry = entry.getName();
							// destino de archivos, se almacenaran en la carpeta
							// a
							// crear
							File destFile = new File(newPath, currentEntry);

							/*
							 * getParentFile(): Esta funcion devuelve el archivo
							 * principal del objeto de archivo dado.
							 */
							File destinationParent = destFile.getParentFile();

							// se crea la direccopm de la carpeta principal si
							// es
							// necesario
							destinationParent.mkdirs();

							if (!entry.isDirectory()) {

								System.out.println("se ha podido crear el archivo");

								BufferedInputStream is = new BufferedInputStream(zipConstitutiva.getInputStream(entry));

								int currentByte;
								// se establece un buffer para escribir el
								// archivo
								byte data[] = new byte[BUFFER];
								// escribir el archivo actual en el disco

								FileOutputStream fos = new FileOutputStream(
										extractFolder + " " + clientes.get(i).getSalesforce() + "_" + "DOC" + "_"
												+ "ACTA" + "_" + "CONSTITUTIVA" + "_" + "MORAL." + fe);

								BufferedOutputStream destino = new BufferedOutputStream(fos, BUFFER);

								// lee y escribe hasta encontrar el ultimo byte
								while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
									destino.write(data, 0, currentByte);

								}
								destino.flush();
								destino.close();
								is.close();

							}

						}

						while (zipFileEntriesCedula.hasMoreElements()) {
							// hashMoreElements() : comprueba si ZipFile
							// contiene
							// mas elementos
							System.out.println("contiene el/los elementos:" + zipFileEntriesCedula.hasMoreElements());

							// toma la entrada de un archivo
							ZipEntry entry = (ZipEntry) zipFileEntriesCedula.nextElement();

							/*
							 * Metodo para renombrar los archivos que han sido
							 * descomprimidos
							 */
							nombreArchivo = entry.getName();
							String fe = "";
							int k = nombreArchivo.lastIndexOf(".");
							if (k > 0) {
								fe = nombreArchivo.substring(k + 1);
							}

							System.out.println("Leyendo los archivos: " + entry);

							// obtiene el nombre de los
							String currentEntry = entry.getName();
							// destino de archivos, se almacenaran en la carpeta
							// a
							// crear
							File destFile = new File(newPath, currentEntry);

							/*
							 * getParentFile(): Esta funcion devuelve el archivo
							 * principal del objeto de archivo dado.
							 */
							File destinationParent = destFile.getParentFile();

							// se crea la direccopm de la carpeta principal si
							// es
							// necesario
							destinationParent.mkdirs();

							if (!entry.isDirectory()) {

								System.out.println("se ha podido crear el archivo");

								BufferedInputStream is = new BufferedInputStream(zipCedula.getInputStream(entry));

								int currentByte;
								// se establece un buffer para escribir el
								// archivo
								byte data[] = new byte[BUFFER];
								// escribir el archivo actual en el disco

								FileOutputStream fos = new FileOutputStream(
										extractFolder + " " + clientes.get(i).getSalesforce() + "_" + "DOC" + "_"
												+ "CEDULA" + "_" + "FISCAL" + "_" + "MORAL." + fe);

								BufferedOutputStream destino = new BufferedOutputStream(fos, BUFFER);

								// lee y escribe hasta encontrar el ultimo byte
								while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
									destino.write(data, 0, currentByte);

								}
								destino.flush();
								destino.close();
								is.close();

							}

						}

						while (zipFileEntriesDeclaratoria.hasMoreElements()) {
							// hashMoreElements() : comprueba si ZipFile
							// contiene
							// mas elementos
							System.out.println(
									"contiene el/los elementos:" + zipFileEntriesDeclaratoria.hasMoreElements());

							// toma la entrada de un archivo
							ZipEntry entry = (ZipEntry) zipFileEntriesDeclaratoria.nextElement();

							/*
							 * Metodo para renombrar los archivos que han sido
							 * descomprimidos
							 */
							nombreArchivo = entry.getName();
							String fe = "";
							int k = nombreArchivo.lastIndexOf(".");
							if (k > 0) {
								fe = nombreArchivo.substring(k + 1);
							}

							System.out.println("Leyendo los archivos: " + entry);

							// obtiene el nombre de los
							String currentEntry = entry.getName();
							// destino de archivos, se almacenaran en la carpeta
							// a
							// crear
							File destFile = new File(newPath, currentEntry);

							/*
							 * getParentFile(): Esta funcion devuelve el archivo
							 * principal del objeto de archivo dado.
							 */
							File destinationParent = destFile.getParentFile();

							// se crea la direccopm de la carpeta principal si
							// es
							// necesario
							destinationParent.mkdirs();

							if (!entry.isDirectory()) {

								System.out.println("se ha podido crear el archivo");

								BufferedInputStream is = new BufferedInputStream(zipDeclaratoria.getInputStream(entry));

								int currentByte;
								// se establece un buffer para escribir el
								// archivo
								byte data[] = new byte[BUFFER];
								// escribir el archivo actual en el disco

								FileOutputStream fos = new FileOutputStream(
										extractFolder + " " + clientes.get(i).getSalesforce() + "_" + "DOC" + "_"
												+ "ACTA" + "_" + "DECLARATORIA" + "_" + "MORAL." + fe);

								BufferedOutputStream destino = new BufferedOutputStream(fos, BUFFER);

								// lee y escribe hasta encontrar el ultimo byte
								while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
									destino.write(data, 0, currentByte);

								}
								destino.flush();
								destino.close();
								is.close();

							}

						}

						while (zipFileEntriesId.hasMoreElements()) {
							// hashMoreElements() : comprueba si ZipFile
							// contiene
							// mas elementos
							System.out.println("contiene el/los elementos:" + zipFileEntriesId.hasMoreElements());

							// toma la entrada de un archivo
							ZipEntry entry = (ZipEntry) zipFileEntriesId.nextElement();

							/*
							 * Metodo para renombrar los archivos que han sido
							 * descomprimidos
							 */
							nombreArchivo = entry.getName();
							String fe = "";
							int k = nombreArchivo.lastIndexOf(".");
							if (k > 0) {
								fe = nombreArchivo.substring(k + 1);
							}

							System.out.println("Leyendo los archivos: " + entry);

							// obtiene el nombre de los
							String currentEntry = entry.getName();
							// destino de archivos, se almacenaran en la carpeta
							// a
							// crear
							File destFile = new File(newPath, currentEntry);

							/*
							 * getParentFile(): Esta funcion devuelve el archivo
							 * principal del objeto de archivo dado.
							 */
							File destinationParent = destFile.getParentFile();

							// se crea la direccopm de la carpeta principal si
							// es
							// necesario
							destinationParent.mkdirs();

							if (!entry.isDirectory()) {

								System.out.println("se ha podido crear el archivo");

								BufferedInputStream is = new BufferedInputStream(zipId.getInputStream(entry));

								int currentByte;
								// se establece un buffer para escribir el
								// archivo
								byte data[] = new byte[BUFFER];
								// escribir el archivo actual en el disco

								FileOutputStream fos = new FileOutputStream(
										extractFolder + " " + clientes.get(i).getSalesforce() + "_" + "DOC" + "_" + "ID"
												+ "_" + "FRONT" + "_" + "MORAL." + fe);

								BufferedOutputStream destino = new BufferedOutputStream(fos, BUFFER);

								// lee y escribe hasta encontrar el ultimo byte
								while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
									destino.write(data, 0, currentByte);

								}
								destino.flush();
								destino.close();
								is.close();

							}

						}

						while (zipFileEntriesPoder.hasMoreElements()) {
							// hashMoreElements() : comprueba si ZipFile
							// contiene
							// mas elementos
							System.out.println("contiene el/los elementos:" + zipFileEntriesPoder.hasMoreElements());

							// toma la entrada de un archivo
							ZipEntry entry = (ZipEntry) zipFileEntriesPoder.nextElement();

							/*
							 * Metodo para renombrar los archivos que han sido
							 * descomprimidos
							 */
							nombreArchivo = entry.getName();
							String fe = "";
							int k = nombreArchivo.lastIndexOf(".");
							if (k > 0) {
								fe = nombreArchivo.substring(k + 1);
							}

							System.out.println("Leyendo los archivos: " + entry);

							// obtiene el nombre de los
							String currentEntry = entry.getName();
							// destino de archivos, se almacenaran en la carpeta
							// a
							// crear
							File destFile = new File(newPath, currentEntry);

							/*
							 * getParentFile(): Esta funcion devuelve el archivo
							 * principal del objeto de archivo dado.
							 */
							File destinationParent = destFile.getParentFile();

							// se crea la direccopm de la carpeta principal si
							// es
							// necesario
							destinationParent.mkdirs();

							if (!entry.isDirectory()) {

								System.out.println("se ha podido crear el archivo");

								BufferedInputStream is = new BufferedInputStream(zipPoder.getInputStream(entry));

								int currentByte;
								// se establece un buffer para escribir el
								// archivo
								byte data[] = new byte[BUFFER];
								// escribir el archivo actual en el disco

								FileOutputStream fos = new FileOutputStream(
										extractFolder + " " + clientes.get(i).getSalesforce() + "_" + "DOC" + "_"
												+ "PODER" + "_" + "NOTARIAL" + "_" + "MORAL." + fe);

								BufferedOutputStream destino = new BufferedOutputStream(fos, BUFFER);

								// lee y escribe hasta encontrar el ultimo byte
								while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
									destino.write(data, 0, currentByte);

								}
								destino.flush();
								destino.close();
								is.close();

							}

						}

						System.out.println("es nuevooooo ");
						System.out.println("consulta de los datos= " + clientes);
						request.setAttribute("alerta", "OK");
						// request.getRequestDispatcher("exportacion.jsp").forward(request,
						// response);

						response.sendRedirect("exportacion.jsp?alerta=OK");
						// response.sendRedirect("exportacion.jsp");

					} catch (Exception e) {
						e.printStackTrace(System.out);
					}

				}

			}

		}
	}

}
