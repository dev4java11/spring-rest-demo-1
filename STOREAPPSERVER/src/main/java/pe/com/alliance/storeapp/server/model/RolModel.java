package pe.com.alliance.storeapp.server.model;

import java.util.List;

public class RolModel {
	
	private int idRol;
	private String nombreRol;
	private String parametroRol;
	private int peso;
	private List<UsuarioRolModel> usuariosRolModel;
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public String getParametroRol() {
		return parametroRol;
	}
	public void setParametroRol(String parametroRol) {
		this.parametroRol = parametroRol;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public List<UsuarioRolModel> getUsuariosRolModel() {
		return usuariosRolModel;
	}
	public void setUsuariosRolModel(List<UsuarioRolModel> usuariosRolModel) {
		this.usuariosRolModel = usuariosRolModel;
	}
	
	
	

}
