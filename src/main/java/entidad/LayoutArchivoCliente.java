package entidad;

public class LayoutArchivoCliente {
	String salesforce;
	String tipoPersona;
	/*datos de persona fisica*/
	String idPf;
	String declaratoriaPf;
	String cedulaFiscalPf;
	String curpPf;
	
	/*datos de persona moral*/
	String constitutivaPM;
	String cedulaFiscalPM;
	String idPM;
	String poderNotarialPM;
	String declaratoriaPM;
	
	
	

	public LayoutArchivoCliente() {

	}

	public LayoutArchivoCliente(String salesforce, String tipoPersona,String idPf,String declaratoriaPf,String cedulaFiscalPf,String curpPf,
			String constitutivaPM,String cedulaFiscalPM,String idPM,String poderNotarialPM,String declaratoriaPM) {
		this.salesforce = salesforce;
		this.tipoPersona = tipoPersona;
		this.idPf=idPf;
		this.declaratoriaPf=declaratoriaPf;
		this.cedulaFiscalPf=cedulaFiscalPf;
		this.curpPf=curpPf;
		this.constitutivaPM=constitutivaPM;
		this.cedulaFiscalPM=cedulaFiscalPM;
		this.idPM=idPM;
		this.poderNotarialPM=poderNotarialPM;
		this.declaratoriaPM=declaratoriaPM;
		
	}

	public String getSalesforce() {
		return salesforce;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}
	
	public String getId(){
		return idPf;
	}
	
	public String getDeclaratoria(){
		return declaratoriaPf;
	}
	
	public String getCedula(){
		return cedulaFiscalPf;
	}
	
	public String getCurp(){
		return curpPf;
	}
	
	public String getConstitutiva(){
		return constitutivaPM;
	}
	
	public String getCedulaPm(){
		return cedulaFiscalPM;
	}
	
	public String getIdPm(){
		return idPM;
	}
	
	public String getPoderNotarial(){
		return poderNotarialPM;
	}
	
	public String getDeclaratoriaPm(){
		return declaratoriaPM;
	}
	
	
	

	public boolean setSalesForce(String salesforce) {
		if (!salesforce.isEmpty()) {
			this.salesforce = salesforce;
			return true;
		}
		return false;
	}

	public boolean setTipoPersona(String tipoPersona) {
		if (!tipoPersona.isEmpty()) {
			this.tipoPersona = tipoPersona;
			return true;
		}
		return false;

	}

}
