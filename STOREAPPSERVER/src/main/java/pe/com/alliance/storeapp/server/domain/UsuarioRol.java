package pe.com.alliance.storeapp.server.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_rol database table.
 * 
 */
@Entity
@Table(name="usuario_rol")
@NamedQuery(name="UsuarioRol.findAll", query="SELECT u FROM UsuarioRol u")
public class UsuarioRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idUsuario_Rol;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idRol", nullable=false)
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario", nullable=false)
	private Usuario usuario;

	public UsuarioRol() {
	}

	public int getIdUsuario_Rol() {
		return this.idUsuario_Rol;
	}

	public void setIdUsuario_Rol(int idUsuario_Rol) {
		this.idUsuario_Rol = idUsuario_Rol;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}