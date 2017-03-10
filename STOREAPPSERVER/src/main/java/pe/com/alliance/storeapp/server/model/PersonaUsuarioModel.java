package pe.com.alliance.storeapp.server.model;

public class PersonaUsuarioModel {
	
	private int idPersonaUsuario;
	private PersonaModel personaModel;
	private UsuarioModel usuarioModel;
	
	public int getIdPersonaUsuario() {
		return idPersonaUsuario;
	}
	public void setIdPersonaUsuario(int idPersonaUsuario) {
		this.idPersonaUsuario = idPersonaUsuario;
	}
	public PersonaModel getPersonaModel() {
		return personaModel;
	}
	public void setPersonaModel(PersonaModel personaModel) {
		this.personaModel = personaModel;
	}
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
	
}
