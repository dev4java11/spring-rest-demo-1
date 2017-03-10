package pe.com.alliance.storeapp.server.model;

import java.util.List;

public class DetalleFacturaModel {
	
	private int idDetalleFactura;
	private int cantidadSolicitada;
	private FacturaModel facturaModel;
	private List<ProductoModel> productosModel;
	
	public DetalleFacturaModel() {
		// TODO Auto-generated constructor stub
	}

	public int getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(int idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public FacturaModel getFacturaModel() {
		return facturaModel;
	}

	public void setFacturaModel(FacturaModel facturaModel) {
		this.facturaModel = facturaModel;
	}

	public List<ProductoModel> getProductosModel() {
		return productosModel;
	}

	public void setProductosModel(List<ProductoModel> productosModel) {
		this.productosModel = productosModel;
	}
	
	
}
