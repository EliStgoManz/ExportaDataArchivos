package entidad;

//import java.sql.Date;
import java.text.SimpleDateFormat;

/*Elaboro: Eli Santiago Manzano*/

public class LayoutCliente {
	String salesforce;
	String cveTipoPersona;
	String tipoP;
	String tipoPersona;
	String tipoRl;
	String clientePadre;
	String nombrePersona;
	String nombreMoral;
	String apellidoPaterno;
	String apellidopMoral;
	String apellidoMaterno;
	String apellidomMoral;
	String dsRazonsocial;
	String cveNacionalidad;
	String dsCalle;
	String noExterior;
	String noInterior;
	String codigoPostal;
	String numTelCasa;
	String email;
	String fechaNacimiento;
	String fechaNacimientoRl;
	String fechaConstitucion;
	String curp;
	String rfcCliente;
	String rfcMoral;
	String cveActividadEconomica;
	String numeroEscritura;
	String fechaEscritura;
	String notaria;
	String dsIdentificacion;
	// String rlidentifica_id;
	// String usuariovalido;
	SimpleDateFormat formato;

	/* SobreCarga de Conatructores */
	/* Constructor vacio */
	public LayoutCliente() {

	}

	public LayoutCliente(String salesforce) {
		this.salesforce = salesforce;

	}

	public LayoutCliente(String salesforce, String cveTipoPersona, String tipoP, String tipoRl, String tipoPersona,
			String clientePadre, String nombrePersona, String nombreMoral, String apellidoPaterno,
			String apellidopMoral, String apellidoMaterno, String apellidomMoral, String dsRazonsocial,
			String cveNacionalidad, String dsCalle, String noExterior, String noInterior, String codigoPostal,
			String numTelCasa, String email, String fechaNacimiento, String fechaNacimientoRl, String fechaConstitucion,
			String curp, String rfcCliente,String rfcMoral, String cveActividadEconomica,String numeroEscritura,String fechaEscritura,String notaria, String dsIdentificacion) {

		this.salesforce = salesforce;
		this.cveTipoPersona = cveTipoPersona;
		this.tipoP = tipoP;
		this.tipoRl = tipoRl;
		this.tipoPersona = tipoPersona;
		this.clientePadre = clientePadre;
		this.nombrePersona = nombrePersona;
		this.nombreMoral = nombreMoral;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidopMoral = apellidopMoral;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidomMoral = apellidomMoral;
		this.dsRazonsocial = dsRazonsocial;
		this.cveNacionalidad = cveNacionalidad;
		this.dsCalle = dsCalle;
		this.noExterior = noExterior;
		this.noInterior = noInterior;
		this.codigoPostal = codigoPostal;
		this.numTelCasa = numTelCasa;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaNacimientoRl = fechaNacimientoRl;
		this.fechaConstitucion = fechaConstitucion;
		this.curp = curp;
		this.rfcCliente = rfcCliente;
		this.rfcMoral=rfcMoral;
		this.cveActividadEconomica = cveActividadEconomica;
		this.numeroEscritura=numeroEscritura;
		this.fechaEscritura=fechaEscritura;
		this.notaria=notaria;
		this.dsIdentificacion = dsIdentificacion;
		// this.rlidentifica_id = rlidentifica_id;
		// this.usuariovalido = usuariovalido;

	}

	public String getSalesForce() {
		return salesforce;
	}

	public String getTipoPersona() {
		return cveTipoPersona;
	}

	public String getTipoP() {
		return tipoP;
	}

	public String getTipoPerson() {
		return tipoPersona;
	}

	public String getTipoRl() {
		return tipoRl;
	}

	public String getClientePadre() {
		return clientePadre;
	}

	public String getNombre() {
		return nombrePersona;
	}

	public String getNombreMoral() {
		return nombreMoral;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public String getApellidoPMoral() {
		return apellidopMoral;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public String getApellidoMMoral() {
		return apellidomMoral;
	}

	public String getRazonsocial() {
		return dsRazonsocial;
	}

	public String getPaisnacim() {
		return cveNacionalidad;
	}

	public String getCalle() {
		return dsCalle;
	}

	public String getNumExterior() {
		return noExterior;
	}

	public String getNumInterior() {
		return noInterior;
	}

	public String getCodPostal() {
		return codigoPostal;
	}

	public String getTelefono() {
		return numTelCasa;
	}

	public String getEmail() {
		return email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getFechaNacimientoRl() {
		return fechaNacimientoRl;
	}

	public String getFechaConstitucion() {
		return fechaConstitucion;
	}

	public String getCurp() {
		return curp;
	}

	public String getRfc() {
		return rfcCliente;
	}
	
	public String getRfcM(){
		return rfcMoral;
	}

	public String getActividadId() {
		return cveActividadEconomica;
	}
	
	
	public String getNumeroEscritura(){
		return numeroEscritura;
	}
	
	public String getFechaEscritura(){
		return fechaEscritura;
	}
	
	public String getNotaria(){
		return notaria;
	}
	

	public String getIdentificaId() {
		return dsIdentificacion;
	}

	public boolean setSalesForce(String salesforce) {
		if (!salesforce.isEmpty()) {
			this.salesforce = salesforce;
			return true;
		}
		return false;
	}

	public boolean setTipoPersona(String cveTipoPersona) {
		if (!cveTipoPersona.isEmpty()) {
			this.cveTipoPersona = cveTipoPersona;
			return true;
		}
		return false;
	}

	public boolean setTipoP(String tipoP) {
		if (!tipoP.isEmpty()) {
			this.tipoP = tipoP;
			return true;
		}
		return false;
	}

	public boolean setTipoRL(String tipoP) {
		if (!tipoP.isEmpty()) {
			this.tipoP = tipoP;
			return true;
		}
		return false;
	}

	public boolean setClientePadre(String clientePadre) {
		if (!clientePadre.isEmpty()) {
			this.clientePadre = clientePadre;
			return true;
		}
		return false;
	}

	public boolean setNombre(String nombrePersona) {
		if (!nombrePersona.isEmpty()) {
			this.nombrePersona = nombrePersona;
			return true;
		}
		return false;
	}

	public boolean setNombreMoral(String nombreMoral) {
		if (!nombreMoral.isEmpty()) {
			this.nombreMoral = nombreMoral;
			return true;
		}
		return false;
	}

	public boolean setApellidoPaterno(String apellidoPaterno) {
		if (!apellidoPaterno.isEmpty()) {
			this.apellidoPaterno = apellidoPaterno;
			return true;
		}
		return false;
	}

	public boolean setApellidoPaternoMoral(String apellidopMoral) {
		if (!apellidopMoral.isEmpty()) {
			this.apellidopMoral = apellidopMoral;
			return true;
		}
		return false;
	}

	public boolean setApellidoMaterno(String apellidoMaterno) {
		if (!apellidoMaterno.isEmpty()) {
			this.apellidoMaterno = apellidoMaterno;
			return true;
		}
		return false;
	}

	public boolean setApellidoMaternoMoral(String apellidomMoral) {
		if (!apellidomMoral.isEmpty()) {
			this.apellidomMoral = apellidomMoral;
			return true;
		}
		return false;
	}

	public boolean setRazonSocial(String dsRazonsocial) {
		if (!dsRazonsocial.isEmpty()) {
			this.dsRazonsocial = dsRazonsocial;
			return true;
		}
		return false;
	}

	public boolean setPaisNac(String cveNacionalidad) {
		if (!cveNacionalidad.isEmpty()) {
			this.cveNacionalidad = cveNacionalidad;
			return true;
		}
		return false;
	}

	public boolean setCalle(String dsCalle) {
		if (!dsCalle.isEmpty()) {
			this.dsCalle = dsCalle;
			return true;
		}
		return false;
	}

	public boolean setNumExterior(String noExterior) {
		if (!noExterior.isEmpty()) {
			this.noExterior = noExterior;
			return true;
		}
		return false;
	}

	public boolean setNumInterior(String noInterior) {
		if (!noInterior.isEmpty()) {
			this.noInterior = noInterior;
			return true;

		}
		return false;
	}

	public boolean setCodPostal(String codigoPostal) {
		if (!codigoPostal.isEmpty()) {
			this.codigoPostal = codigoPostal;
			return true;
		}
		return false;
	}

	public boolean setTelefono(String numTelCasa) {
		if (!numTelCasa.isEmpty()) {
			this.numTelCasa = numTelCasa;
			return true;
		}
		return false;
	}

	public boolean setEmail(String email) {
		if (!email.isEmpty()) {
			this.email = email;
			return true;
		}
		return false;
	}

	public boolean setFechaNacimiento(String fechaNacimiento) {
		if (!fechaNacimiento.isEmpty()) {
			this.fechaNacimiento = fechaNacimiento;
			return true;
		}
		return false;
	}

	public boolean setFechaNacimientoRl(String fechaNacimientoRl) {
		if (!fechaNacimientoRl.isEmpty()) {
			this.fechaNacimientoRl = fechaNacimientoRl;
			return true;
		}
		return false;
	}

	public boolean setFechaConstitucion(String fechaConstitucion) {
		if (!fechaConstitucion.isEmpty()) {
			this.fechaConstitucion = fechaConstitucion;
			return true;
		}
		return false;
	}

	public boolean setCurp(String curp) {
		if (!curp.isEmpty()) {
			this.curp = curp;
			return true;
		}
		return false;
	}

	public boolean setRfc(String rfcCliente) {
		if (!rfcCliente.isEmpty()) {
			this.rfcCliente = rfcCliente;
			return true;
		}
		return false;
	}
	
	public boolean setRfcMoral(String rfcMoral){
		if(!rfcMoral.isEmpty()){
			this.rfcMoral=rfcMoral;
			return true;
		}
		return false;
	}

	public boolean setActividadEco(String cveActividadEconomica) {
		if (!cveActividadEconomica.isEmpty()) {
			this.cveActividadEconomica = cveActividadEconomica;
			return true;

		}
		return false;
	}
	
	
	public boolean setNumEscritura(String numeroEscritura){
		if(!numeroEscritura.isEmpty()){
			this.numeroEscritura=numeroEscritura;
			return true;
		}
		return false;
		
	}
	
	public boolean setFechEscritura(String fechaEscritura){
		  if(!fechaEscritura.isEmpty()){
			  this.fechaEscritura=fechaEscritura;
			  return true;
		  }
		  return false;
		
	}
	
	public boolean setNotaria(String Notaria){
		if(!notaria.isEmpty()){
			this.notaria=notaria;
			return true;
		}
		return false;
	}
	

	public boolean setIdentificaId(String dsIdentificacion) {
		if (!dsIdentificacion.isEmpty()) {
			this.dsIdentificacion = dsIdentificacion;
			return true;
		}
		return false;
	}

	public String toString() {
		return "LayoutCliente(" + "salesforce=" + salesforce + ", cveTipoPersona= " + cveTipoPersona
				+ ", clientePadre= " + clientePadre + ", nombrePersona=" + nombrePersona + ", apellidoPaterno="
				+ apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", dsRazonsocial=" + dsRazonsocial
				+ ", cveNacionalidad" + cveNacionalidad + ", dsCalle=" + dsCalle + ", noExterior=" + noExterior
				+ ", noInterior=" + noInterior + ", codigoPostal=" + codigoPostal + ", numTelCasa =" + numTelCasa
				+ ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + ", fechaConstitucion="
				+ fechaConstitucion + ", curp" + curp + ", rfcCliente" + rfcCliente + ", cveActividadEconomica="
				+ cveActividadEconomica + ", dsIdentificacion=" + dsIdentificacion + ")";
	}

	/*
	 * public boolean setRlidentificaId(String rlidentifica_id) { if
	 * (!rlidentifica_id.isEmpty()) { this.rlidentifica_id = rlidentifica_id;
	 * return true; } return false; }
	 */

	/*
	 * public boolean setUsuarioValido(String usuariovalido) { if
	 * (!usuariovalido.isEmpty()) { this.usuariovalido = usuariovalido; return
	 * true; } return false; }
	 */

}

