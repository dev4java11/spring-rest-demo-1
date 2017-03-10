package pe.com.alliance.storeapp.server.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idUsuario;

	private int bloqued;

	private int changePassword;

	@Column(length=45)
	private String email;

	private int enable;

	private int expired;

	@Column(length=45)
	private String password;

	@Column(length=45)
	private String username;

	//bi-directional many-to-one association to PersonaUsuario
	@OneToMany(mappedBy="usuario")
	private List<PersonaUsuario> personaUsuarios;

	//bi-directional many-to-one association to UsuarioRol
	@OneToMany(mappedBy="usuario")
	private List<UsuarioRol> usuarioRols;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getBloqued() {
		return this.bloqued;
	}

	public void setBloqued(int bloqued) {
		this.bloqued = bloqued;
	}

	public int getChangePassword() {
		return this.changePassword;
	}

	public void setChangePassword(int changePassword) {
		this.changePassword = changePassword;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnable() {
		return this.enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getExpired() {
		return this.expired;
	}

	public void setExpired(int expired) {
		this.expired = expired;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<PersonaUsuario> getPersonaUsuarios() {
		return this.personaUsuarios;
	}

	public void setPersonaUsuarios(List<PersonaUsuario> personaUsuarios) {
		this.personaUsuarios = personaUsuarios;
	}

	public PersonaUsuario addPersonaUsuario(PersonaUsuario personaUsuario) {
		getPersonaUsuarios().add(personaUsuario);
		personaUsuario.setUsuario(this);

		return personaUsuario;
	}

	public PersonaUsuario removePersonaUsuario(PersonaUsuario personaUsuario) {
		getPersonaUsuarios().remove(personaUsuario);
		personaUsuario.setUsuario(null);

		return personaUsuario;
	}

	public List<UsuarioRol> getUsuarioRols() {
		return this.usuarioRols;
	}

	public void setUsuarioRols(List<UsuarioRol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}

	public UsuarioRol addUsuarioRol(UsuarioRol usuarioRol) {
		getUsuarioRols().add(usuarioRol);
		usuarioRol.setUsuario(this);

		return usuarioRol;
	}

	public UsuarioRol removeUsuarioRol(UsuarioRol usuarioRol) {
		getUsuarioRols().remove(usuarioRol);
		usuarioRol.setUsuario(null);

		return usuarioRol;
	}

}