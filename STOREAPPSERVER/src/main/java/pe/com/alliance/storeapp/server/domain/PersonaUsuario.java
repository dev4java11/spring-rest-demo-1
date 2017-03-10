package pe.com.alliance.storeapp.server.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the persona_usuario database table.
 * 
 */
@Entity
@Table(name="persona_usuario")
@NamedQuery(name="PersonaUsuario.findAll", query="SELECT p FROM PersonaUsuario p")
public class PersonaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idPersona_Usuario;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idPersona", nullable=false)
	private Persona persona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario", nullable=false)
	private Usuario usuario;

	public PersonaUsuario() {
	}

	public int getIdPersona_Usuario() {
		return this.idPersona_Usuario;
	}

	public void setIdPersona_Usuario(int idPersona_Usuario) {
		this.idPersona_Usuario = idPersona_Usuario;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}