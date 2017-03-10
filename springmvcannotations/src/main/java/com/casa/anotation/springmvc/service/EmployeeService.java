package com.casa.anotation.springmvc.service;

import java.util.List;

import com.casa.anotation.springmvc.model.EmployeeModelView;

public interface EmployeeService {
	
	public List<EmployeeModelView> obtenerTodosEmpleados();
	
	public List<EmployeeModelView> obtenerEmpleados(int pagina, int cantidadPagina);
	
	public int getCantidadTotalPaginas();
	
	public EmployeeModelView obtenerEmpleado(int idEmployee);
	
	public EmployeeModelView obtenerJefe(int idEmployeeBoss);
	
	public EmployeeModelView obtenerJefeOficina(int idEmployeeBoss, String idOffice);
	
	
}
