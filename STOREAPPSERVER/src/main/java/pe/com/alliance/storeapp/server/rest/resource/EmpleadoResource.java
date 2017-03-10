package pe.com.alliance.storeapp.server.rest.resource;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

public class EmpleadoResource extends ResourceSupport{

	private int idEmpleado;
	private String codigo;
	private Date fechaIngreso;
	private String sueldo;
	
	public EmpleadoResource() {
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
}
