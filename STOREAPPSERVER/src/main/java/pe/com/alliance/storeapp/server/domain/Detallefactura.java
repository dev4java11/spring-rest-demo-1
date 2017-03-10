package pe.com.alliance.storeapp.server.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the detallefactura database table.
 * 
 */
@Entity
@Table(name="detallefactura")
@NamedQuery(name="Detallefactura.findAll", query="SELECT d FROM Detallefactura d")
public class Detallefactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idDetalleFactura;

	private int cantidadSolicitada;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="idFactura", nullable=false)
	private Factura factura;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="detallefactura")
	private List<Producto> productos;

	public Detallefactura() {
	}

	public int getIdDetalleFactura() {
		return this.idDetalleFactura;
	}

	public void setIdDetalleFactura(int idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public int getCantidadSolicitada() {
		return this.cantidadSolicitada;
	}

	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setDetallefactura(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setDetallefactura(null);

		return producto;
	}

}