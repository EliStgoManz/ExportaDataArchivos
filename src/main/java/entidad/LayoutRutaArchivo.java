package entidad;

public class LayoutRutaArchivo{
	int idArchivo;
	String nombreArchivo;
	
	
	public LayoutRutaArchivo() {

	}

	public LayoutRutaArchivo(int idArchivo, String nombreArchivo) {
		this.idArchivo = idArchivo;
		this.nombreArchivo = nombreArchivo;
	}

	public int getIdArchivo() {
		return idArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public boolean setIdArchivo(int idArchivo) {
		if (idArchivo>=0) {
			this.idArchivo = idArchivo;
			return true;
		}
		return false;
	}

	public boolean setNombreArchivo(String nombreArchivo) {
		if (!nombreArchivo.isEmpty()) {
			this.nombreArchivo = nombreArchivo;
			return true;
		}
		return false;
	}

}

