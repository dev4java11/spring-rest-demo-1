package pe.com.alliance.storeapp.server.service;

import java.util.List;

import pe.com.alliance.storeapp.server.model.EmpleadoModel;

public interface GestorEmpleadoService {
	
	public List<EmpleadoModel> buscarTodosEmpleados();
	public EmpleadoModel buscarEmpleado(int idEmpleado);
	public List<EmpleadoModel> buscarPaginacionEmpleados(int page, int size);

}
