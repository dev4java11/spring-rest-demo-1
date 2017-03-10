package pe.com.alliance.storeapp.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.alliance.storeapp.server.model.PersonaModel;
import pe.com.alliance.storeapp.server.repository.PersonaRepository;
import pe.com.alliance.storeapp.server.service.GestorPersonaService;
import pe.com.alliance.storeapp.server.transformer.PersonaTransformer;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class GestorPersonaServiceImpl implements GestorPersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private PersonaTransformer personaTransformer;
	
	public void setPersonaRepository(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}
	
	public void setPersonaTransformer(PersonaTransformer personaTransformer) {
		this.personaTransformer = personaTransformer;
	}
	
	@Override
	public PersonaModel buscarPersona(int id) {
		return personaTransformer.transformToModel(personaRepository.getOne(id));
	}

}
