package com.casa.anotation.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casa.anotation.springmvc.domain.Employee;
import com.casa.anotation.springmvc.model.EmployeeModelView;
import com.casa.anotation.springmvc.model.GenericEmployeeModel;
import com.casa.anotation.springmvc.model.GenericOfficeModel;
import com.casa.anotation.springmvc.repository.EmployeeRepository;
import com.casa.anotation.springmvc.repository.OfficeRepository;
import com.casa.anotation.springmvc.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	private int cantidadTotalPaginas = -1;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OfficeRepository officeRepository;
	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public void setOfficeRepository(OfficeRepository officeRepository) {
		this.officeRepository = officeRepository;
	}
	
	@Override
	public int getCantidadTotalPaginas() {
		return cantidadTotalPaginas;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeModelView> obtenerTodosEmpleados(){
		List<EmployeeModelView> listModel = new ArrayList<EmployeeModelView>();
		List<Employee> employees = employeeRepository.findAllEmployeesJoinOffice();
		if(!employees.isEmpty()){
			for(int i=0;i<employees.size();i++){
				EmployeeModelView model = transformToModel(employees.get(i));
				model.getEmployeeModel().setNumGeneralEmployeeModel(i);
				listModel.add(model);
			}
		}
		return listModel;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeModelView> obtenerEmpleados(int pagina, int cantidadPagina){
		List<EmployeeModelView> listModel = new ArrayList<EmployeeModelView>();
		Sort sort = new Sort(Sort.Direction.ASC, "lastName", "firstName");
		Pageable pageable = new PageRequest(pagina, cantidadPagina, sort);
		Page<Employee> pageEmployees = employeeRepository.findAllEmployeesJoinOffice(pageable);
		List<Employee> employees = pageEmployees.getContent();
		cantidadTotalPaginas = pageEmployees.getTotalPages();
		if(!employees.isEmpty()){
			for(int i=0;i<employees.size();i++){
				EmployeeModelView model = transformToModel(employees.get(i));
				model.getEmployeeModel().setNumGeneralEmployeeModel(i);
				listModel.add(model);
			}
		}
		return listModel;
	}
	
	@Override
	@Transactional(readOnly = true)
	public EmployeeModelView obtenerEmpleado(int idEmployee){
		return transformToModel(employeeRepository.findEmployeeWithId(idEmployee));
	}
	
	@Override
	@Transactional(readOnly = true)
	public EmployeeModelView obtenerJefe(int idEmployeeBoss){
		return transformToModel(employeeRepository.findEmployeeWithId(idEmployeeBoss));
	}
	
	@Override
	@Transactional(readOnly = true)
	public EmployeeModelView obtenerJefeOficina(int idEmployeeBoss, String idOffice){
		return transformToModel(employeeRepository.findBossWithOfficeCode(idEmployeeBoss, idOffice));
	}
	
	private EmployeeModelView transformToModel(Employee entity){
		EmployeeModelView model = new EmployeeModelView();
		if(entity != null){
			model.setEmployeeModel(new GenericEmployeeModel());
			model.getEmployeeModel().setIdEmployeeModel(entity.getEmployeeNumber());
			model.getEmployeeModel().setFirstNameEmployeeModel(entity.getFirstName());
			model.getEmployeeModel().setLastNameEmployeeModel(entity.getLastName());
			model.getEmployeeModel().setExtensionEmployeeModel(entity.getExtension());
			model.getEmployeeModel().setEmailEmployeeModel(entity.getEmail());
			model.getEmployeeModel().setJobTitleEmployeeModel(entity.getJobTitle());
			model.getEmployeeModel().setReportsToEmployeeModel((entity.getEmployee() == null? -1:entity.getEmployee().getEmployeeNumber()));
			model.getEmployeeModel().setOfficeCodeEmployeeModel(entity.getOffice().getOfficeCode());
			
			model.setOfficeModel(new GenericOfficeModel());
			model.getOfficeModel().setOfficeCodeOfficeModel(entity.getOffice().getOfficeCode());
			model.getOfficeModel().setAddressLine1OfficeModel(entity.getOffice().getAddressLine1());
			model.getOfficeModel().setAddressLine2OfficeModel(entity.getOffice().getAddressLine2());
			model.getOfficeModel().setCityOfficeModel(entity.getOffice().getCity());
			model.getOfficeModel().setCountryOfficeModel(entity.getOffice().getCountry());
			model.getOfficeModel().setPhoneOfficeModel(entity.getOffice().getPhone());
			model.getOfficeModel().setPostalCodeOfficeModel(entity.getOffice().getPostalCode());
			model.getOfficeModel().setStateOfficeModel(entity.getOffice().getState());
			model.getOfficeModel().setTerritoryOfficeModel(entity.getOffice().getTerritory());
		}
		return model;
	}

}
