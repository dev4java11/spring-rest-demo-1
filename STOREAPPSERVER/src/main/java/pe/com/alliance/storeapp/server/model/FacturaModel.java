package pe.com.alliance.storeapp.server.model;

import java.util.Date;
import java.util.List;

public class FacturaModel {
	
	private int idFactura;
	private String codigo;
	private Date fechaFacturacion;
	private float igv;
	private float importe;
	private float montoFinal;
	private List<DetalleFacturaModel> detalleFacturasModel;
	private ClienteModel clienteModel;
	private EmpleadoModel empleadoModel;
	private ModoPagoModel modoPagoModel;
	
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}
	public void setFechaFacturacion(Date fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}
	public float getIgv() {
		return igv;
	}
	public void setIgv(float igv) {
		this.igv = igv;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public float getMontoFinal() {
		return montoFinal;
	}
	public void setMontoFinal(float montoFinal) {
		this.montoFinal = montoFinal;
	}
	public List<DetalleFacturaModel> getDetalleFacturasModel() {
		return detalleFacturasModel;
	}
	public void setDetalleFacturasModel(List<DetalleFacturaModel> detalleFacturasModel) {
		this.detalleFacturasModel = detalleFacturasModel;
	}
	public ClienteModel getClienteModel() {
		return clienteModel;
	}
	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}
	public EmpleadoModel getEmpleadoModel() {
		return empleadoModel;
	}
	public void setEmpleadoModel(EmpleadoModel empleadoModel) {
		this.empleadoModel = empleadoModel;
	}
	public ModoPagoModel getModoPagoModel() {
		return modoPagoModel;
	}
	public void setModoPagoModel(ModoPagoModel modoPagoModel) {
		this.modoPagoModel = modoPagoModel;
	}
	
	
	
}
