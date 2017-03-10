package com.casa.anotation.springmvc.model;

public class GenericOfficeModel {
	
	private int numGenericOfficeModel = -1;
	private String officeCodeOfficeModel;
	private String cityOfficeModel;
	private String phoneOfficeModel;
	private String addressLine1OfficeModel;
	private String addressLine2OfficeModel;
	private String stateOfficeModel;
	private String countryOfficeModel;
	private String postalCodeOfficeModel;
	private String territoryOfficeModel;
	
	public GenericOfficeModel() {
		// TODO Auto-generated constructor stub
	}

	public GenericOfficeModel(int numGenericOfficeModel, String officeCodeOfficeModel, String cityOfficeModel,
			String phoneOfficeModel, String addressLine1OfficeModel, String addressLine2OfficeModel,
			String stateOfficeModel, String countryOfficeModel, String postalCodeOfficeModel,
			String territoryOfficeModel) {
		super();
		this.numGenericOfficeModel = numGenericOfficeModel;
		this.officeCodeOfficeModel = officeCodeOfficeModel;
		this.cityOfficeModel = cityOfficeModel;
		this.phoneOfficeModel = phoneOfficeModel;
		this.addressLine1OfficeModel = addressLine1OfficeModel;
		this.addressLine2OfficeModel = addressLine2OfficeModel;
		this.stateOfficeModel = stateOfficeModel;
		this.countryOfficeModel = countryOfficeModel;
		this.postalCodeOfficeModel = postalCodeOfficeModel;
		this.territoryOfficeModel = territoryOfficeModel;
	}

	public int getNumGenericOfficeModel() {
		return numGenericOfficeModel;
	}

	public void setNumGenericOfficeModel(int numGenericOfficeModel) {
		this.numGenericOfficeModel = numGenericOfficeModel;
	}

	public String getOfficeCodeOfficeModel() {
		return officeCodeOfficeModel;
	}

	public void setOfficeCodeOfficeModel(String officeCodeOfficeModel) {
		this.officeCodeOfficeModel = officeCodeOfficeModel;
	}

	public String getCityOfficeModel() {
		return cityOfficeModel;
	}

	public void setCityOfficeModel(String cityOfficeModel) {
		this.cityOfficeModel = cityOfficeModel;
	}

	public String getPhoneOfficeModel() {
		return phoneOfficeModel;
	}

	public void setPhoneOfficeModel(String phoneOfficeModel) {
		this.phoneOfficeModel = phoneOfficeModel;
	}

	public String getAddressLine1OfficeModel() {
		return addressLine1OfficeModel;
	}

	public void setAddressLine1OfficeModel(String addressLine1OfficeModel) {
		this.addressLine1OfficeModel = addressLine1OfficeModel;
	}

	public String getAddressLine2OfficeModel() {
		return addressLine2OfficeModel;
	}

	public void setAddressLine2OfficeModel(String addressLine2OfficeModel) {
		this.addressLine2OfficeModel = addressLine2OfficeModel;
	}

	public String getStateOfficeModel() {
		return stateOfficeModel;
	}

	public void setStateOfficeModel(String stateOfficeModel) {
		this.stateOfficeModel = stateOfficeModel;
	}

	public String getCountryOfficeModel() {
		return countryOfficeModel;
	}

	public void setCountryOfficeModel(String countryOfficeModel) {
		this.countryOfficeModel = countryOfficeModel;
	}

	public String getPostalCodeOfficeModel() {
		return postalCodeOfficeModel;
	}

	public void setPostalCodeOfficeModel(String postalCodeOfficeModel) {
		this.postalCodeOfficeModel = postalCodeOfficeModel;
	}

	public String getTerritoryOfficeModel() {
		return territoryOfficeModel;
	}

	public void setTerritoryOfficeModel(String territoryOfficeModel) {
		this.territoryOfficeModel = territoryOfficeModel;
	}

	@Override
	public String toString() {
		return "GenericOfficeModel [numGenericOfficeModel=" + numGenericOfficeModel + ", officeCodeOfficeModel="
				+ officeCodeOfficeModel + ", cityOfficeModel=" + cityOfficeModel + ", phoneOfficeModel="
				+ phoneOfficeModel + ", addressLine1OfficeModel=" + addressLine1OfficeModel
				+ ", addressLine2OfficeModel=" + addressLine2OfficeModel + ", stateOfficeModel=" + stateOfficeModel
				+ ", countryOfficeModel=" + countryOfficeModel + ", postalCodeOfficeModel=" + postalCodeOfficeModel
				+ ", territoryOfficeModel=" + territoryOfficeModel + "]";
	}
	
	
	
}
