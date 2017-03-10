package pe.com.alliance.storeapp.server.model;

import java.util.List;

public class ModoPagoModel {

	private int idModoPago;
	private String nombre;
	private String parametro;
	private List<FacturaModel> facturasModel;
	
	public int getIdModoPago() {
		return idModoPago;
	}
	public void setIdModoPago(int idModoPago) {
		this.idModoPago = idModoPago;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getParametro() {
		return parametro;
	}
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	public List<FacturaModel> getFacturasModel() {
		return facturasModel;
	}
	public void setFacturasModel(List<FacturaModel> facturasModel) {
		this.facturasModel = facturasModel;
	}
	
	
}
