package pe.com.alliance.storeapp.server.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.com.alliance.storeapp.server.domain.Empleado;
import pe.com.alliance.storeapp.server.model.EmpleadoModel;
import pe.com.alliance.storeapp.server.util.DateUtilTransformer;

@Component
public class EmpleadoTransformer extends GenericTransformer<EmpleadoModel, Empleado>{
	
	@Autowired
	private PersonaTransformer personaTransformer;
	
	public void setPersonaTransformer(PersonaTransformer personaTransformer) {
		this.personaTransformer = personaTransformer;
	}

	@Override
	public EmpleadoModel transformToModel(Empleado entidad) {
		EmpleadoModel model = new EmpleadoModel();
		if(entidad != null){
			model.setIdEmpleado(entidad.getIdEmpleado());
			model.setCodigo(entidad.getCodigo());
			model.setSueldo(entidad.getSueldo());
			model.setFechaIngreso(DateUtilTransformer.transformToDate(entidad.getFechaIngreso()));
			if(entidad.getPersona() != null){
			model.setPersona(personaTransformer.transformToModel(entidad.getPersona()));
			}
		}
		return model;
	}
	
	@Override
	public Empleado transformToEntidad(EmpleadoModel model) {
		Empleado entidad = new Empleado();
		return entidad;
	}

}
