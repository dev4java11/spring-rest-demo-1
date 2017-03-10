package pe.com.alliance.storeapp.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.alliance.storeapp.server.model.EmpleadoModel;
import pe.com.alliance.storeapp.server.rest.assembler.EmpleadoResourceAssembler;
import pe.com.alliance.storeapp.server.rest.resource.EmpleadoResource;
import pe.com.alliance.storeapp.server.service.GestorEmpleadoService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RestController
@ExposesResourceFor(EmpleadoModel.class)
@RequestMapping("/empleados")
public class GestorEmpleadoController {
	
	@Autowired
	private GestorEmpleadoService empleadoService;
	
	@Autowired
	private EmpleadoResourceAssembler empleadoResourceAssembler;
	
	public void setEmpleadoService(GestorEmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}
	
	public void setEmpleadoResourceAssembler(EmpleadoResourceAssembler empleadoResourceAssembler) {
		this.empleadoResourceAssembler = empleadoResourceAssembler;
	}

//	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
	public ResponseEntity<List<EmpleadoResource>> buscarTodosEmpleados(){
		List<EmpleadoModel> list = empleadoService.buscarTodosEmpleados();
		return new ResponseEntity<List<EmpleadoResource>>(empleadoResourceAssembler.toResources(list) , HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resources<Resource<EmpleadoModel>>> obtenerTodosEmpleados(){
		List<EmpleadoModel> list = empleadoService.buscarTodosEmpleados();
		List<Resource<EmpleadoModel>> list_ = new ArrayList<Resource<EmpleadoModel>>();
		Link linkEmpleados = linkTo(methodOn(GestorEmpleadoController.class).buscarTodosEmpleados()).withRel("empleados");
		for(EmpleadoModel e : list){
			Link linkPersona = linkTo(methodOn(GestorPersonaController.class).buscarPersonaResource(e.getPersona().getIdPersona())).withRel("persona");
			Link linkEmpleado = linkTo(methodOn(GestorEmpleadoController.class).buscarEmpleadoResource(e.getIdEmpleado())).withRel("empleado");
			Resource<EmpleadoModel> resource = new Resource<EmpleadoModel>(e, linkEmpleado, linkPersona);
			list_.add(resource);
		}
		Resources<Resource<EmpleadoModel>> listResources = new Resources<>(list_, linkEmpleados);
		
		return new ResponseEntity<Resources<Resource<EmpleadoModel>>>(listResources, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/paginacion/{page}/{size}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpleadoResource>> buscarPaginaEmpleados(@PathVariable("page")int page, @PathVariable("size") int size){
		List<EmpleadoModel> list = empleadoService.buscarPaginacionEmpleados(page, size);
		return new ResponseEntity<List<EmpleadoResource>>(empleadoResourceAssembler.toResources(list), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpleadoResource> buscarEmpleadoResource(@PathVariable("id") int id){
		EmpleadoModel empleadoModel = empleadoService.buscarEmpleado(id);
		if(empleadoModel == null){
			
		}
		EmpleadoResource empleadoResource = empleadoResourceAssembler.toResource(empleadoModel);
		return new ResponseEntity<EmpleadoResource>(empleadoResource, HttpStatus.FOUND);
	}

	
}
