package pe.com.mycompany.rest.model;

public class GenericProductModel {

	private int numGenericProductModel;
	private String codeProductModel;
	private String nameProductModel;
	private String lineProductModel;
	private String scaleProductModel;
	private String vendorProductModel;
	private String descriptionProductModel;
	private int stockProductModel;
	private double priceProductModel;
	private double msrpProductModel;
	
	
	public GenericProductModel() {
	}


	public GenericProductModel(int numGenericProductModel,
			String codeProductModel, String nameProductModel,
			String lineProductModel, String scaleProductModel,
			String vendorProductModel, String descriptionProductModel,
			int stockProductModel, double priceProductModel,
			double msrpProductModel) {
		super();
		this.numGenericProductModel = numGenericProductModel;
		this.codeProductModel = codeProductModel;
		this.nameProductModel = nameProductModel;
		this.lineProductModel = lineProductModel;
		this.scaleProductModel = scaleProductModel;
		this.vendorProductModel = vendorProductModel;
		this.descriptionProductModel = descriptionProductModel;
		this.stockProductModel = stockProductModel;
		this.priceProductModel = priceProductModel;
		this.msrpProductModel = msrpProductModel;
	}


	public int getNumGenericProductModel() {
		return numGenericProductModel;
	}


	public void setNumGenericProductModel(int numGenericProductModel) {
		this.numGenericProductModel = numGenericProductModel;
	}


	public String getCodeProductModel() {
		return codeProductModel;
	}


	public void setCodeProductModel(String codeProductModel) {
		this.codeProductModel = codeProductModel;
	}


	public String getNameProductModel() {
		return nameProductModel;
	}


	public void setNameProductModel(String nameProductModel) {
		this.nameProductModel = nameProductModel;
	}


	public String getLineProductModel() {
		return lineProductModel;
	}


	public void setLineProductModel(String lineProductModel) {
		this.lineProductModel = lineProductModel;
	}


	public String getScaleProductModel() {
		return scaleProductModel;
	}


	public void setScaleProductModel(String scaleProductModel) {
		this.scaleProductModel = scaleProductModel;
	}


	public String getVendorProductModel() {
		return vendorProductModel;
	}


	public void setVendorProductModel(String vendorProductModel) {
		this.vendorProductModel = vendorProductModel;
	}


	public String getDescriptionProductModel() {
		return descriptionProductModel;
	}


	public void setDescriptionProductModel(String descriptionProductModel) {
		this.descriptionProductModel = descriptionProductModel;
	}


	public int getStockProductModel() {
		return stockProductModel;
	}


	public void setStockProductModel(int stockProductModel) {
		this.stockProductModel = stockProductModel;
	}


	public double getPriceProductModel() {
		return priceProductModel;
	}


	public void setPriceProductModel(double priceProductModel) {
		this.priceProductModel = priceProductModel;
	}


	public double getMsrpProductModel() {
		return msrpProductModel;
	}


	public void setMsrpProductModel(double msrpProductModel) {
		this.msrpProductModel = msrpProductModel;
	}


	@Override
	public String toString() {
		return "GenericProductModel [numGenericProductModel="
				+ numGenericProductModel + ", codeProductModel="
				+ codeProductModel + ", nameProductModel=" + nameProductModel
				+ ", lineProductModel=" + lineProductModel
				+ ", scaleProductModel=" + scaleProductModel
				+ ", vendorProductModel=" + vendorProductModel
				+ ", descriptionProductModel=" + descriptionProductModel
				+ ", stockProductModel=" + stockProductModel
				+ ", priceProductModel=" + priceProductModel
				+ ", msrpProductModel=" + msrpProductModel + "]";
	}


	

	
	
}
