package pe.com.alliance.storeapp.server.model;

import java.util.List;

public class UsuarioModel {

	private int idUsuario;
	private int bloqued;
	private int changePassword;
	private String email;
	private int enable;
	private int expired;
	private String password;
	private String username;
	private List<PersonaUsuarioModel> personasUsuarioModel;
	private List<UsuarioRolModel> usuariosRolModel;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getBloqued() {
		return bloqued;
	}
	public void setBloqued(int bloqued) {
		this.bloqued = bloqued;
	}
	public int getChangePassword() {
		return changePassword;
	}
	public void setChangePassword(int changePassword) {
		this.changePassword = changePassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getExpired() {
		return expired;
	}
	public void setExpired(int expired) {
		this.expired = expired;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<PersonaUsuarioModel> getPersonasUsuarioModel() {
		return personasUsuarioModel;
	}
	public void setPersonasUsuarioModel(List<PersonaUsuarioModel> personasUsuarioModel) {
		this.personasUsuarioModel = personasUsuarioModel;
	}
	public List<UsuarioRolModel> getUsuariosRolModel() {
		return usuariosRolModel;
	}
	public void setUsuariosRolModel(List<UsuarioRolModel> usuariosRolModel) {
		this.usuariosRolModel = usuariosRolModel;
	}
	
	

}
