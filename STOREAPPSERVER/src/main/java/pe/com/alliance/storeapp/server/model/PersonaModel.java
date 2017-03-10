package pe.com.alliance.storeapp.server.model;

import java.util.List;

public class PersonaModel {
	
	private int idPersona;
	private String apmaterno;
	private String appaterno;
	private String direccion;
	private String dni;
	private int edad;
	private String genero;
	private String nombres;
	private List<ClienteModel> clientesModel;
	private List<EmpleadoModel> empleadosModel;
	private List<PersonaUsuarioModel> personasUsuarioModel;
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getApmaterno() {
		return apmaterno;
	}
	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}
	public String getAppaterno() {
		return appaterno;
	}
	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public List<ClienteModel> getClientesModel() {
		return clientesModel;
	}
	public void setClientesModel(List<ClienteModel> clientesModel) {
		this.clientesModel = clientesModel;
	}
	public List<EmpleadoModel> getEmpleadosModel() {
		return empleadosModel;
	}
	public void setEmpleadosModel(List<EmpleadoModel> empleadosModel) {
		this.empleadosModel = empleadosModel;
	}
	public List<PersonaUsuarioModel> getPersonasUsuarioModel() {
		return personasUsuarioModel;
	}
	public void setPersonasUsuarioModel(List<PersonaUsuarioModel> personasUsuarioModel) {
		this.personasUsuarioModel = personasUsuarioModel;
	}
	
	

}
