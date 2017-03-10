package com.casa.anotation.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.casa.anotation.springmvc.model.EmployeeModelView;
import com.casa.anotation.springmvc.model.json.EmployeeJson;
import com.casa.anotation.springmvc.service.EmployeeService;
import com.casa.anotation.springmvc.service.impl.EmployeeServiceImpl;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private static final String view_employees_list = "employees/employeelist";
	private static final String view_employee_edit = "employees/employee_edit";
	
	private static final int default_rows = 10;
	
	private int totalFilasPagina = default_rows;
	
	@Autowired
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void setTotalFilasPagina(int totalFilasPagina) {
		this.totalFilasPagina = totalFilasPagina;
	}
	
	@RequestMapping(value = "/employeelist.htm", method = {RequestMethod.GET})
	public String goEmployeeList(@RequestParam(value="page_var", defaultValue="0") int page ,Model model){
		List<EmployeeModelView> employeeList = employeeService.obtenerEmpleados(page, totalFilasPagina);
		model.addAttribute("employees", employeeList);
		model.addAttribute("totalPages", employeeService.getCantidadTotalPaginas());
		return view_employees_list;
	}
	
//	@RequestMapping(value = "/rest/employeelist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(HttpStatus.OK)
//	public @ResponseBody List<EmployeeJson> getAllEmployees(Model model){
//		List<EmployeeModelView> list = employeeService.obtenerTodosEmpleados();
//		List<EmployeeJson> listJson = new ArrayList<EmployeeJson>();
//		for(EmployeeModelView emp: list){
//			listJson.add(new EmployeeJson(emp.getEmployeeModel()));
//		}
//		return listJson;
//	}
//	
//	@RequestMapping(value="/rest/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(HttpStatus.OK)
//	public @ResponseBody List<EmployeeModelView> getEmployees(){
//		List<EmployeeModelView> list = employeeService.obtenerTodosEmpleados();
//		return list;
//	}
	
	@RequestMapping(value="/{employee_id}/employee_edit.htm", method=RequestMethod.GET)
	public String goEmployeeEdit(@PathVariable("employee_id") int employeeId, Model model){
		EmployeeModelView employee = employeeService.obtenerEmpleado(employeeId);
		EmployeeModelView boss = employeeService.obtenerJefeOficina(employee.getEmployeeModel().getReportsToEmployeeModel(), employee.getOfficeModel().getOfficeCodeOfficeModel());
		model.addAttribute("employee", employee);
		model.addAttribute("boss", boss);
		return view_employee_edit;
	}

}
