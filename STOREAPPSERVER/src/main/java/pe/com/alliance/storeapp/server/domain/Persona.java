package pe.com.alliance.storeapp.server.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idPersona;

	@Column(length=45)
	private String apmaterno;

	@Column(length=45)
	private String appaterno;

	@Column(length=45)
	private String direccion;

	@Column(length=45)
	private String dni;

	private int edad;

	@Column(length=45)
	private String genero;

	@Column(length=45)
	private String nombres;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="persona")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="persona")
	private List<Empleado> empleados;

	//bi-directional many-to-one association to PersonaUsuario
	@OneToMany(mappedBy="persona")
	private List<PersonaUsuario> personaUsuarios;

	public Persona() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getApmaterno() {
		return this.apmaterno;
	}

	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}

	public String getAppaterno() {
		return this.appaterno;
	}

	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setPersona(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setPersona(null);

		return cliente;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setPersona(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setPersona(null);

		return empleado;
	}

	public List<PersonaUsuario> getPersonaUsuarios() {
		return this.personaUsuarios;
	}

	public void setPersonaUsuarios(List<PersonaUsuario> personaUsuarios) {
		this.personaUsuarios = personaUsuarios;
	}

	public PersonaUsuario addPersonaUsuario(PersonaUsuario personaUsuario) {
		getPersonaUsuarios().add(personaUsuario);
		personaUsuario.setPersona(this);

		return personaUsuario;
	}

	public PersonaUsuario removePersonaUsuario(PersonaUsuario personaUsuario) {
		getPersonaUsuarios().remove(personaUsuario);
		personaUsuario.setPersona(null);

		return personaUsuario;
	}

}