package com.casa.anotation.springmvc.model;

public class EmployeeModelView{
	
	private GenericEmployeeModel employeeModel;
	private GenericOfficeModel officeModel;
	
	public EmployeeModelView() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeModelView(GenericEmployeeModel employeeModel, GenericOfficeModel officeModel) {
		super();
		this.employeeModel = employeeModel;
		this.officeModel = officeModel;
	}

	public GenericEmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(GenericEmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}

	public GenericOfficeModel getOfficeModel() {
		return officeModel;
	}

	public void setOfficeModel(GenericOfficeModel officeModel) {
		this.officeModel = officeModel;
	}
	
	
}
