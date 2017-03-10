package pe.com.alliance.storeapp.server.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadoproducto database table.
 * 
 */
@Entity
@Table(name="estadoproducto")
@NamedQuery(name="Estadoproducto.findAll", query="SELECT e FROM Estadoproducto e")
public class Estadoproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idEstadoProducto;

	@Column(length=45)
	private String nombre;

	@Column(length=45)
	private String parametro;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="estadoproducto")
	private List<Producto> productos;

	public Estadoproducto() {
	}

	public int getIdEstadoProducto() {
		return this.idEstadoProducto;
	}

	public void setIdEstadoProducto(int idEstadoProducto) {
		this.idEstadoProducto = idEstadoProducto;
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
		producto.setEstadoproducto(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setEstadoproducto(null);

		return producto;
	}

}