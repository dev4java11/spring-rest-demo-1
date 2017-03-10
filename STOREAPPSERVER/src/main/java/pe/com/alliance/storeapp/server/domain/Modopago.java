package pe.com.alliance.storeapp.server.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the modopago database table.
 * 
 */
@Entity
@Table(name="modopago")
@NamedQuery(name="Modopago.findAll", query="SELECT m FROM Modopago m")
public class Modopago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idModoPago;

	@Column(length=45)
	private String nombre;

	@Column(length=45)
	private String parametro;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="modopago")
	private List<Factura> facturas;

	public Modopago() {
	}

	public int getIdModoPago() {
		return this.idModoPago;
	}

	public void setIdModoPago(int idModoPago) {
		this.idModoPago = idModoPago;
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

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setModopago(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setModopago(null);

		return factura;
	}

}