package com.casa.anotation.springmvc.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.casa.anotation.springmvc.domain.Product;
import com.casa.anotation.springmvc.model.ProductModelView;

@Component("productValidator")
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	/*
	  int numGenericProductModel,
			String codeProductModel, String nameProductModel,
			String lineProductModel, String scaleProductModel,
			String vendorProductModel, String descriptionProductModel,
			int stockProductModel, double priceProductModel,
			double msrpProductModel, int formScaleProductModel
	*/
	
	@Override
	public void validate(Object target, Errors errors) {
		ProductModelView p = (ProductModelView) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameProductModel", "error.productname.empty", "The name of the product is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formScaleProductModel", "error.formScaleProductModel.empty", "The scale of the product is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vendorProductModel", "error.vendorProductModel.empty", "The vendor of the product is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descriptionProductModel", "error.productname.empty", "The name of the product is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stockProductModel", "error.stockProductModel.empty", "The stock of the product is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "priceProductModel", "error.priceProductModel.empty", "The price of the product is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "msrpProductModel", "error.msrpProductModel.empty", "The MSRP of the product is required.");
		
		if(p.getFormScaleProductModel()<=0){
			errors.rejectValue("formScaleProductModel", "error.formScaleProductModel.negative", "The scale of product is negative.");
		}
		if(p.getStockProductModel()<=0){
			errors.rejectValue("stockProductModel", "error.stockProductModel.negative", "The stock of product is negative.");
		}
		if(p.getPriceProductModel()<=0){
			errors.rejectValue("priceProductModel", "error.priceProductModel.negative", "The price of product is negative.");
		}
		if(p.getMsrpProductModel()<=0){
			errors.rejectValue("msrpProductModel", "error.msrpProductModel.negative", "The MSRP of product is negative.");
		}
	}

}
