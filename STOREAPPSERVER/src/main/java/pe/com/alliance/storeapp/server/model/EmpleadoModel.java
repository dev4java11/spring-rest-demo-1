package pe.com.alliance.storeapp.server.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("empleado")
public class EmpleadoModel {
	
	private int idEmpleado;
	
	private String codigo;
	private Date fechaIngreso;
	private String sueldo;
	
	@JsonIgnore
	private PersonaModel persona;
	
	@JsonIgnore
	private List<FacturaModel> facturasModel;
	
	public EmpleadoModel() {
		// TODO Auto-generated constructor stub
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getSueldo() {
		return sueldo;
	}

	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}

	public PersonaModel getPersona() {
		return persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

	public List<FacturaModel> getFacturasModel() {
		return facturasModel;
	}

	public void setFacturasModel(List<FacturaModel> facturasModel) {
		this.facturasModel = facturasModel;
	}

	@Override
	public String toString() {
		return "EmpleadoModel [idEmpleado=" + idEmpleado + ", codigo=" + codigo + ", fechaIngreso=" + fechaIngreso
				+ ", sueldo=" + sueldo + ", persona=" + persona + ", facturasModel=" + facturasModel + "]";
	}
	
	
	
}
