package pe.com.mycompany.rest.model;

public class ProductModelView extends GenericProductModel{

	private int formScaleProductModel = 0;
	
	public ProductModelView() {
	}

	public ProductModelView(int numGenericProductModel,
			String codeProductModel, String nameProductModel,
			String lineProductModel, String scaleProductModel,
			String vendorProductModel, String descriptionProductModel,
			int stockProductModel, double priceProductModel,
			double msrpProductModel) {
		super(numGenericProductModel, codeProductModel, nameProductModel,
				lineProductModel, scaleProductModel, vendorProductModel,
				descriptionProductModel, stockProductModel, priceProductModel,
				msrpProductModel);
	}




	public ProductModelView(int numGenericProductModel,
			String codeProductModel, String nameProductModel,
			String lineProductModel, String scaleProductModel,
			String vendorProductModel, String descriptionProductModel,
			int stockProductModel, double priceProductModel,
			double msrpProductModel, int formScaleProductModel) {
		super(numGenericProductModel, codeProductModel, nameProductModel,
				lineProductModel, scaleProductModel, vendorProductModel,
				descriptionProductModel, stockProductModel, priceProductModel,
				msrpProductModel);
		this.formScaleProductModel = formScaleProductModel;
	}



	public int getFormScaleProductModel() {
		return formScaleProductModel;
	}

	public void setFormScaleProductModel(int formScaleProductModel) {
		this.formScaleProductModel = formScaleProductModel;
	}

	@Override
	public String toString() {
		return "ProductModelView [formScaleProductModel="
				+ formScaleProductModel + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
