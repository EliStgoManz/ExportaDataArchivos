package entidad;

public class LayoutDatoArchivo {
	private String idCliente;
	private String tipoPersona;
	
	public LayoutDatoArchivo(){
		
	}
	
	public LayoutDatoArchivo(String idCliente, String tipoPersona){
		this.idCliente=idCliente;
		this.tipoPersona=tipoPersona;
	}
	
	
	public String getIdCliente(){
		return idCliente;
	}
	
	public String getTipoPersona(){
		return tipoPersona;
	}
	
	
	public boolean setIdCliente(String idCliente){
		if(!idCliente.isEmpty()){
			this.idCliente=idCliente;
			return true;
		}
		return false;
	}
	
	public boolean setTipoPersona(String tipoPersona){
		if(!tipoPersona.isEmpty()){
			this.tipoPersona=tipoPersona;
			return true;
		}
		return false;
		
	}

}
