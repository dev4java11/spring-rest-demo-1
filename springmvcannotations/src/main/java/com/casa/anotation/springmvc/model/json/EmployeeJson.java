package com.casa.anotation.springmvc.model.json;

import java.io.Serializable;

import com.casa.anotation.springmvc.model.GenericEmployeeModel;

public class EmployeeJson implements Serializable {
	
	private int numGeneralEmployeeModel = -1;
	private int idEmployeeModel;
	private String emailEmployeeModel;
	private String extensionEmployeeModel;
	private String firstNameEmployeeModel;
	private String jobTitleEmployeeModel;
	private String lastNameEmployeeModel;
	private int reportsToEmployeeModel;
	private String officeCodeEmployeeModel;
	
	public EmployeeJson() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeJson(GenericEmployeeModel model){
		numGeneralEmployeeModel = model.getNumGeneralEmployeeModel();
		idEmployeeModel = model.getIdEmployeeModel();
		emailEmployeeModel = model.getEmailEmployeeModel();
		extensionEmployeeModel = model.getExtensionEmployeeModel();
		firstNameEmployeeModel = model.getFirstNameEmployeeModel();
		jobTitleEmployeeModel = model.getJobTitleEmployeeModel();
		lastNameEmployeeModel = model.getLastNameEmployeeModel();
		reportsToEmployeeModel = model.getReportsToEmployeeModel();
		officeCodeEmployeeModel = model.getOfficeCodeEmployeeModel();
	}

	public int getNumGeneralEmployeeModel() {
		return numGeneralEmployeeModel;
	}

	public void setNumGeneralEmployeeModel(int numGeneralEmployeeModel) {
		this.numGeneralEmployeeModel = numGeneralEmployeeModel;
	}

	public int getIdEmployeeModel() {
		return idEmployeeModel;
	}

	public void setIdEmployeeModel(int idEmployeeModel) {
		this.idEmployeeModel = idEmployeeModel;
	}

	public String getEmailEmployeeModel() {
		return emailEmployeeModel;
	}

	public void setEmailEmployeeModel(String emailEmployeeModel) {
		this.emailEmployeeModel = emailEmployeeModel;
	}

	public String getExtensionEmployeeModel() {
		return extensionEmployeeModel;
	}

	public void setExtensionEmployeeModel(String extensionEmployeeModel) {
		this.extensionEmployeeModel = extensionEmployeeModel;
	}

	public String getFirstNameEmployeeModel() {
		return firstNameEmployeeModel;
	}

	public void setFirstNameEmployeeModel(String firstNameEmployeeModel) {
		this.firstNameEmployeeModel = firstNameEmployeeModel;
	}

	public String getJobTitleEmployeeModel() {
		return jobTitleEmployeeModel;
	}

	public void setJobTitleEmployeeModel(String jobTitleEmployeeModel) {
		this.jobTitleEmployeeModel = jobTitleEmployeeModel;
	}

	public String getLastNameEmployeeModel() {
		return lastNameEmployeeModel;
	}

	public void setLastNameEmployeeModel(String lastNameEmployeeModel) {
		this.lastNameEmployeeModel = lastNameEmployeeModel;
	}

	public int getReportsToEmployeeModel() {
		return reportsToEmployeeModel;
	}

	public void setReportsToEmployeeModel(int reportsToEmployeeModel) {
		this.reportsToEmployeeModel = reportsToEmployeeModel;
	}

	public String getOfficeCodeEmployeeModel() {
		return officeCodeEmployeeModel;
	}

	public void setOfficeCodeEmployeeModel(String officeCodeEmployeeModel) {
		this.officeCodeEmployeeModel = officeCodeEmployeeModel;
	}
	
	
	
}
