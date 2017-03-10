package pe.com.alliance.storeapp.server.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tienda database table.
 * 
 */
@Entity
@Table(name="tienda")
@NamedQuery(name="Tienda.findAll", query="SELECT t FROM Tienda t")
public class Tienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idAlmacen;

	@Column(length=800)
	private String descripcion;

	@Column(length=45)
	private String nombre;

	@Column(length=45)
	private String parametro;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="tienda")
	private List<Producto> productos;

	public Tienda() {
	}

	public int getIdAlmacen() {
		return this.idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getParametro() {
		return this.parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setTienda(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setTienda(null);

		return producto;
	}

}