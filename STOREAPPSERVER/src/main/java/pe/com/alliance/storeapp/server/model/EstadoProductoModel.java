package pe.com.alliance.storeapp.server.model;

import java.util.List;

public class EstadoProductoModel {
	
	private int idEstadoProducto;
	private String nombre;
	private String parametro;
	private List<ProductoModel> productosModel;
	
	public EstadoProductoModel() {
		// TODO Auto-generated constructor stub
	}

	public int getIdEstadoProducto() {
		return idEstadoProducto;
	}

	public void setIdEstadoProducto(int idEstadoProducto) {
		this.idEstadoProducto = idEstadoProducto;
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

	public List<ProductoModel> getProductosModel() {
		return productosModel;
	}

	public void setProductosModel(List<ProductoModel> productosModel) {
		this.productosModel = productosModel;
	}
	
	
}
