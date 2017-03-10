package pe.com.alliance.storeapp.server.rest.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import pe.com.alliance.storeapp.server.controller.GestorPersonaController;
import pe.com.alliance.storeapp.server.model.PersonaModel;
import pe.com.alliance.storeapp.server.rest.resource.PersonaResource;

@Component
public class PersonaResourceAssembler extends ResourceAssemblerSupport<PersonaModel, PersonaResource>{

	public PersonaResourceAssembler() {
		super(GestorPersonaController.class, PersonaResource.class);
	}

	@Override
	public PersonaResource toResource(PersonaModel entity) {
		PersonaResource personaResource = createResourceWithId(entity.getIdPersona(), entity);
		personaResource.setIdPersona(entity.getIdPersona());
		personaResource.setAppaterno(entity.getAppaterno());
		personaResource.setApmaterno(entity.getApmaterno());
		personaResource.setNombres(entity.getNombres());
		personaResource.setDireccion(entity.getDireccion());
		personaResource.setDni(entity.getDni());
		personaResource.setEdad(entity.getEdad());
		personaResource.setGenero(entity.getGenero());
		return personaResource;
	}
}
