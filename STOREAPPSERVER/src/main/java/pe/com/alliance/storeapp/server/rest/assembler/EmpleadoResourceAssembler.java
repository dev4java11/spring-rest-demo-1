package pe.com.alliance.storeapp.server.rest.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import pe.com.alliance.storeapp.server.controller.GestorEmpleadoController;
import pe.com.alliance.storeapp.server.controller.GestorPersonaController;
import pe.com.alliance.storeapp.server.model.EmpleadoModel;
import pe.com.alliance.storeapp.server.rest.resource.EmpleadoResource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Component
public class EmpleadoResourceAssembler extends ResourceAssemblerSupport<EmpleadoModel, EmpleadoResource> {

	public EmpleadoResourceAssembler() {
		super(GestorEmpleadoController.class, EmpleadoResource.class);
	}

	@Override
	public EmpleadoResource toResource(EmpleadoModel entity) {
		EmpleadoResource empleadoResource = createResourceWithId(entity.getIdEmpleado(), entity);
		empleadoResource.setIdEmpleado(entity.getIdEmpleado());
		empleadoResource.setCodigo(entity.getCodigo());
		empleadoResource.setFechaIngreso(entity.getFechaIngreso());
		empleadoResource.setSueldo(entity.getSueldo());
		addPersonaResourceLink(empleadoResource, entity.getPersona().getIdPersona());
		return empleadoResource;
	}

	
	private void addPersonaResourceLink(EmpleadoResource empleadoResource, int idPersona){
		empleadoResource.add(linkTo(methodOn(GestorPersonaController.class).buscarPersonaResource(idPersona)).withRel("persona"));
	}
}
