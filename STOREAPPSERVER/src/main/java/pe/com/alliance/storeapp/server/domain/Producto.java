package pe.com.alliance.storeapp.server.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idProducto;

	@Column(length=45)
	private String nombre;

	private float precio;

	//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="producto")
	private List<Categoria> categorias;

	//bi-directional many-to-one association to Detallefactura
	@ManyToOne
	@JoinColumn(name="idDetalleFactura", nullable=false)
	private Detallefactura detallefactura;

	//bi-directional many-to-one association to Estadoproducto
	@ManyToOne
	@JoinColumn(name="idEstadoProducto", nullable=false)
	private Estadoproducto estadoproducto;

	//bi-directional many-to-one association to Tienda
	@ManyToOne
	@JoinColumn(name="idAlmacen", nullable=false)
	private Tienda tienda;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria addCategoria(Categoria categoria) {
		getCategorias().add(categoria);
		categoria.setProducto(this);

		return categoria;
	}

	public Categoria removeCategoria(Categoria categoria) {
		getCategorias().remove(categoria);
		categoria.setProducto(null);

		return categoria;
	}

	public Detallefactura getDetallefactura() {
		return this.detallefactura;
	}

	public void setDetallefactura(Detallefactura detallefactura) {
		this.detallefactura = detallefactura;
	}

	public Estadoproducto getEstadoproducto() {
		return this.estadoproducto;
	}

	public void setEstadoproducto(Estadoproducto estadoproducto) {
		this.estadoproducto = estadoproducto;
	}

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

}