package com.casa.anotation.springmvc.model;

public class GenericEmployeeModel {

	private int numGeneralEmployeeModel = -1;
	private int idEmployeeModel;
	private String emailEmployeeModel;
	private String extensionEmployeeModel;
	private String firstNameEmployeeModel;
	private String jobTitleEmployeeModel;
	private String lastNameEmployeeModel;
	private int reportsToEmployeeModel;
	private String officeCodeEmployeeModel;
	
	
	public GenericEmployeeModel() {
	}

	public GenericEmployeeModel(int numGeneralEmployeeModel, int idEmployeeModel, String emailEmployeeModel,
			String extensionEmployeeModel, String firstNameEmployeeModel, String jobTitleEmployeeModel,
			String lastNameEmployeeModel, int reportsToEmployeeModel, String officeCodeEmployeeModel) {
		super();
		this.numGeneralEmployeeModel = numGeneralEmployeeModel;
		this.idEmployeeModel = idEmployeeModel;
		this.emailEmployeeModel = emailEmployeeModel;
		this.extensionEmployeeModel = extensionEmployeeModel;
		this.firstNameEmployeeModel = firstNameEmployeeModel;
		this.jobTitleEmployeeModel = jobTitleEmployeeModel;
		this.lastNameEmployeeModel = lastNameEmployeeModel;
		this.reportsToEmployeeModel = reportsToEmployeeModel;
		this.officeCodeEmployeeModel = officeCodeEmployeeModel;
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

	@Override
	public String toString() {
		return "GenericEmployeeModel [numGeneralEmployeeModel=" + numGeneralEmployeeModel + ", idEmployeeModel="
				+ idEmployeeModel + ", emailEmployeeModel=" + emailEmployeeModel + ", extensionEmployeeModel="
				+ extensionEmployeeModel + ", firstNameEmployeeModel=" + firstNameEmployeeModel
				+ ", jobTitleEmployeeModel=" + jobTitleEmployeeModel + ", lastNameEmployeeModel="
				+ lastNameEmployeeModel + ", reportsToEmployeeModel=" + reportsToEmployeeModel
				+ ", officeCodeEmployeeModel=" + officeCodeEmployeeModel + "]";
	}
	
	
}
