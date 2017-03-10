package pe.com.alliance.storeapp.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.alliance.storeapp.server.domain.Empleado;
import pe.com.alliance.storeapp.server.model.EmpleadoModel;
import pe.com.alliance.storeapp.server.repository.EmpleadoRepository;
import pe.com.alliance.storeapp.server.service.GestorEmpleadoService;
import pe.com.alliance.storeapp.server.transformer.EmpleadoTransformer;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class GestorEmpleadoServiceImpl implements GestorEmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private EmpleadoTransformer empleadoTransformer;
	
	public void setEmpleadoRepository(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	public void setEmpleadoTransformer(EmpleadoTransformer empleadoTransformer) {
		this.empleadoTransformer = empleadoTransformer;
	}
	
	@Override
	public List<EmpleadoModel> buscarTodosEmpleados() {
		return empleadoTransformer.transformToModel(empleadoRepository.findAll());
	}
	
	@Override
	public EmpleadoModel buscarEmpleado(int idEmpleado) {
		return empleadoTransformer.transformToModel(empleadoRepository.findOne(idEmpleado));
	}

	@Override
	public List<EmpleadoModel> buscarPaginacionEmpleados(int page, int size) {
		Pageable pageable = new PageRequest(page, size, new Sort(Sort.Direction.ASC, "persona.appaterno", "persona.apmaterno", "persona.nombres"));
		Page<Empleado> pageEmpleados = empleadoRepository.buscarPaginacionEmpleados(pageable);
		return empleadoTransformer.transformToModel(pageEmpleados.getContent());
	}


}
