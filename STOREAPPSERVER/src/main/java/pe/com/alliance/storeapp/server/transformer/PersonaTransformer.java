package pe.com.alliance.storeapp.server.transformer;

import org.springframework.stereotype.Component;

import pe.com.alliance.storeapp.server.domain.Persona;
import pe.com.alliance.storeapp.server.model.PersonaModel;

@Component
public class PersonaTransformer extends GenericTransformer<PersonaModel, Persona>{
	
	@Override
	public PersonaModel transformToModel(Persona entidad){
		if(entidad != null){
			PersonaModel model = new PersonaModel();
			model.setIdPersona(entidad.getIdPersona());
			model.setAppaterno(entidad.getAppaterno());
			model.setApmaterno(entidad.getApmaterno());
			model.setNombres(entidad.getNombres());
			model.setDireccion(entidad.getDireccion());
			model.setDni(entidad.getDni());
			model.setEdad(entidad.getEdad());
			model.setGenero(entidad.getGenero());
			return model;
		}
		return null;
	}
	
	@Override
	public Persona transformToEntidad(PersonaModel model){
		if(model != null){
			Persona entidad = new Persona();
			entidad.setIdPersona(model.getIdPersona());
			entidad.setAppaterno(model.getAppaterno());
			entidad.setApmaterno(model.getApmaterno());
			entidad.setNombres(model.getNombres());
			entidad.setDireccion(model.getDireccion());
			entidad.setDni(model.getDni());
			entidad.setEdad(model.getEdad());
			entidad.setGenero(model.getGenero());
			return entidad;
		}
		return null;
	}
}
