package pe.com.alliance.storeapp.server.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@Table(name="factura")
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idFactura;

	@Column(length=45)
	private String codigo;

	private Timestamp fechaFacturacion;

	private float igv;

	private float importe;

	private float montoFinal;

	//bi-directional many-to-one association to Detallefactura
	@OneToMany(mappedBy="factura")
	private List<Detallefactura> detallefacturas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idCliente", nullable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idEmpleado", nullable=false)
	private Empleado empleado;

	//bi-directional many-to-one association to Modopago
	@ManyToOne
	@JoinColumn(name="idModoPago", nullable=false)
	private Modopago modopago;

	public Factura() {
	}

	public int getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Timestamp getFechaFacturacion() {
		return this.fechaFacturacion;
	}

	public void setFechaFacturacion(Timestamp fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}

	public float getIgv() {
		return this.igv;
	}

	public void setIgv(float igv) {
		this.igv = igv;
	}

	public float getImporte() {
		return this.importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public float getMontoFinal() {
		return this.montoFinal;
	}

	public void setMontoFinal(float montoFinal) {
		this.montoFinal = montoFinal;
	}

	public List<Detallefactura> getDetallefacturas() {
		return this.detallefacturas;
	}

	public void setDetallefacturas(List<Detallefactura> detallefacturas) {
		this.detallefacturas = detallefacturas;
	}

	public Detallefactura addDetallefactura(Detallefactura detallefactura) {
		getDetallefacturas().add(detallefactura);
		detallefactura.setFactura(this);

		return detallefactura;
	}

	public Detallefactura removeDetallefactura(Detallefactura detallefactura) {
		getDetallefacturas().remove(detallefactura);
		detallefactura.setFactura(null);

		return detallefactura;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Modopago getModopago() {
		return this.modopago;
	}

	public void setModopago(Modopago modopago) {
		this.modopago = modopago;
	}

}