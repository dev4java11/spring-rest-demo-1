package pe.com.alliance.storeapp.server.model;

public class CategoriaModel {

	private int idCategoria;
	private String nombre;
	private ProductoModel productoModel;

	public CategoriaModel() {
	
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProductoModel getProductoModel() {
		return productoModel;
	}

	public void setProductoModel(ProductoModel productoModel) {
		this.productoModel = productoModel;
	}
	
	
}
