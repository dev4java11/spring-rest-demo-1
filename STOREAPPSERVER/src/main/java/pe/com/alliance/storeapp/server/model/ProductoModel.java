package pe.com.alliance.storeapp.server.model;

import java.util.List;

public class ProductoModel {
	
	private int idProducto;
	private String nombre;
	private float precio;
	private List<CategoriaModel> categoriasModel;
	private TiendaModel tiendaModel;
	private DetalleFacturaModel detalleFacturaModel;
	private EstadoProductoModel estadoProductoModel;
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public List<CategoriaModel> getCategoriasModel() {
		return categoriasModel;
	}
	public void setCategoriasModel(List<CategoriaModel> categoriasModel) {
		this.categoriasModel = categoriasModel;
	}
	public TiendaModel getTiendaModel() {
		return tiendaModel;
	}
	public void setTiendaModel(TiendaModel tiendaModel) {
		this.tiendaModel = tiendaModel;
	}
	public DetalleFacturaModel getDetalleFacturaModel() {
		return detalleFacturaModel;
	}
	public void setDetalleFacturaModel(DetalleFacturaModel detalleFacturaModel) {
		this.detalleFacturaModel = detalleFacturaModel;
	}
	public EstadoProductoModel getEstadoProductoModel() {
		return estadoProductoModel;
	}
	public void setEstadoProductoModel(EstadoProductoModel estadoProductoModel) {
		this.estadoProductoModel = estadoProductoModel;
	}

	
}
