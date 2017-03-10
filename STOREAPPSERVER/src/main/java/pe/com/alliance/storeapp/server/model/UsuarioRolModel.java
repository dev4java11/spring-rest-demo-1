package pe.com.alliance.storeapp.server.model;

public class UsuarioRolModel {
	
	private int idUsuarioRol;
	private RolModel rolModel;
	private UsuarioModel usuarioModel;
	
	public int getIdUsuarioRol() {
		return idUsuarioRol;
	}
	public void setIdUsuarioRol(int idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}
	public RolModel getRolModel() {
		return rolModel;
	}
	public void setRolModel(RolModel rolModel) {
		this.rolModel = rolModel;
	}
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
	

}
