package pe.com.alliance.storeapp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.alliance.storeapp.server.model.PersonaModel;
import pe.com.alliance.storeapp.server.rest.assembler.PersonaResourceAssembler;
import pe.com.alliance.storeapp.server.rest.resource.PersonaResource;
import pe.com.alliance.storeapp.server.service.GestorPersonaService;

@RestController
@RequestMapping("/personas")
public class GestorPersonaController {
	
	@Autowired
	private GestorPersonaService personaService;
	
	@Autowired
	private PersonaResourceAssembler personaResourceAssembler;

	public void setPersonaService(GestorPersonaService personaService) {
		this.personaService = personaService;
	}
	
	public void setPersonaResourceAssembler(PersonaResourceAssembler personaResourceAssembler) {
		this.personaResourceAssembler = personaResourceAssembler;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonaResource> buscarPersonaResource(@PathVariable("id") int id){
		PersonaModel personaModel = personaService.buscarPersona(id);
		if(personaModel == null){
			
		}
		return new ResponseEntity<PersonaResource>(personaResourceAssembler.toResource(personaModel), HttpStatus.FOUND);
	}
}
