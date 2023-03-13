package entidad;

public class LayoutArchivos {
	private String idPersona;
	private String tipoDePersona;
	private String tipoPerson;
	private String dniFisica;
	private String cedulaFiscalFisica;
	private String dniMoral;

	private String cedulaFiscalMoral;
	private String poderNotarial;
	private String actaConstitutiva;

	public LayoutArchivos() {

	}

	public LayoutArchivos(String idPersona, String tipoDePersona, String tipoPerson, String dniFisica,
			String cedulaFiscalFisica, String dniMoral, String cedulaFiscalMoral, String poderNotarial,
			String actaConstitutiva) {
		this.idPersona = idPersona;
		this.tipoDePersona = tipoDePersona;
		this.tipoPerson = tipoPerson;
		this.dniFisica = dniFisica;
		this.cedulaFiscalFisica = cedulaFiscalFisica;
		this.dniMoral = dniMoral;
		this.cedulaFiscalMoral = cedulaFiscalMoral;
		this.poderNotarial = poderNotarial;
		this.actaConstitutiva = actaConstitutiva;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public String getTipoPersona() {
		return tipoDePersona;
	}

	public String getTipoP() {
		return tipoPerson;
	}

	public String getDniFisi() {
		return dniFisica;
	}

	public String getDniMor() {
		return dniMoral;
	}

	public String getCedulaFiscalFis() {
		return cedulaFiscalFisica;
	}

	public String getCedulaFisMor() {
		return cedulaFiscalMoral;
	}

	public String getPoderNotarial() {
		return poderNotarial;
	}

	public String getActaConst() {
		return actaConstitutiva;
	}

	public boolean setIdPersona(String idPersona) {
		if (!idPersona.isEmpty()) {
			this.idPersona = idPersona;
			return true;
		}
		return false;
	}

	public boolean setTipoPersona(String tipoDePersona) {
		if (!tipoDePersona.isEmpty()) {
			this.tipoDePersona = tipoDePersona;
			return true;
		}
		return false;
	}

	public boolean setDniFisica(String dniFisica) {
		if (!dniFisica.isEmpty()) {
			this.dniFisica = dniFisica;
			return true;
		}
		return false;
	}

	public boolean setDniMoral(String dniMoral) {
		if (!dniMoral.isEmpty()) {
			this.dniMoral = dniMoral;
			return true;
		}
		return false;
	}

	public boolean setCedulaFiscFis(String cedulaFiscalFisica) {
		if (!cedulaFiscalFisica.isEmpty()) {
			this.cedulaFiscalFisica = cedulaFiscalFisica;
			return true;
		}
		return false;
	}

	public boolean setCedulaFiscMor(String cedulaFiscalMoral) {
		if (!cedulaFiscalMoral.isEmpty()) {
			this.cedulaFiscalMoral = cedulaFiscalMoral;
			return true;
		}
		return false;
	}
	
	public boolean setPoderNotarial(String poderNotarial){
		if(!poderNotarial.isEmpty()){
			this.poderNotarial=poderNotarial;
			return true;
		}
		return false;
	}

	public boolean setActaConstitutiva(String actaConstitutiva) {
		if (!actaConstitutiva.isEmpty()) {
			this.actaConstitutiva = actaConstitutiva;
			return true;
		}
		return false;
	}

}
