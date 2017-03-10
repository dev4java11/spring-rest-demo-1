package pe.com.alliance.storeapp.server.model;

import java.util.List;

public class TiendaModel {

	private int idAlmacen;
	private String descripcion;
	private String nombre;
	private String parametro;
	private List<ProductoModel> productosModel;
	
	public int getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
