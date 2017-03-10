package pe.com.alliance.storeapp.server.model;

import java.util.List;

public class ClienteModel {
	
	private int idCliente;
	private String codigo;
	private PersonaModel personaModel;
	private List<FacturaModel> facturasModel;

	public ClienteModel() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public PersonaModel getPersonaModel() {
		return personaModel;
	}

	public void setPersonaModel(PersonaModel personaModel) {
		this.personaModel = personaModel;
	}

	public List<FacturaModel> getFacturasModel() {
		return facturasModel;
	}

	public void setFacturasModel(List<FacturaModel> facturasModel) {
		this.facturasModel = facturasModel;
	}
	
	
}
