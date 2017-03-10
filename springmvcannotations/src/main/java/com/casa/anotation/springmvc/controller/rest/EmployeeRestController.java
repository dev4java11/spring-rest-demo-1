package com.casa.anotation.springmvc.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casa.anotation.springmvc.model.EmployeeModelView;
import com.casa.anotation.springmvc.service.EmployeeService;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<EmployeeModelView> getAllEmployees(){
		return employeeService.obtenerTodosEmpleados();
	}
	
	@RequestMapping(value= "/page", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<EmployeeModelView> getPageEmployees(@RequestParam("page") int page, @RequestParam("size") int size){
		return employeeService.obtenerEmpleados(page, size);
	}
	
	

}
