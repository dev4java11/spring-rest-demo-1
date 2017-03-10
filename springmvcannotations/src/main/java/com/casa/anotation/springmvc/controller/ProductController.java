package com.casa.anotation.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.casa.anotation.springmvc.model.ProductModelView;
import com.casa.anotation.springmvc.service.ProductService;
import com.casa.anotation.springmvc.service.impl.ProductServiceImpl;
import com.casa.anotation.springmvc.util.ProductValidator;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private static final int CANTIDAD_PAGINA = 10;
	private static final int PAGINA_INICIO = 0;
	
	@Autowired
	private ProductValidator productValidator;
	
	@Autowired
	private ProductService productService;

	public void setProductValidator(ProductValidator productValidator) {
		this.productValidator = productValidator;
	}
	
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	
	@RequestMapping(value="/productlist.htm", method = {RequestMethod.GET, RequestMethod.POST})
	@SuppressWarnings("unchecked")
	public String productList(@RequestParam(value="page_var", defaultValue="0") int page, Model model){
		List<ProductModelView> products = (List<ProductModelView>) productService.obtenerProductosModel(page, CANTIDAD_PAGINA);
		List<String> lines = productService.obtenerLineaProductos();  
		model.addAttribute("products", products);
		model.addAttribute("pages", productService.getNumberTotalPage());
		model.addAttribute("pageActual", page);
		model.addAttribute("numPerPage", CANTIDAD_PAGINA);
		if(!model.containsAttribute("productRegister")){
			model.addAttribute("productRegister", new ProductModelView());
		}
		model.addAttribute("lines", lines);
		return "products/productlist";
	}
	
	@RequestMapping(value="/register.htm", method = RequestMethod.POST)
	public String registerProduct(@ModelAttribute("productRegister") ProductModelView product, RedirectAttributes redAtt, BindingResult bindingResult, Model model){
		System.out.println("Product: "+product.toString());
		productValidator.validate(product, bindingResult);
		if(bindingResult.hasErrors()){
			redAtt.addFlashAttribute("org.springframework.validation.BindingResult.productRegister", bindingResult);
			redAtt.addFlashAttribute("productRegister", product);
			redAtt.addFlashAttribute("formMsg", "error");
			return "redirect:/products/productlist.htm?page_var=0";
		}
		productService.agregarNuevoProducto(product);
		redAtt.addFlashAttribute("formMsg", "success");
		return "redirect:/products/productlist.htm?page_var=0";
	}
	
//	@RequestMapping(value="/edit.htm")
//	public String editProduct(@RequestParam("productCode") String productCode){
//		System.out.println("Product: "+productCode + " decode: "+ EncriptorUtil.decode(productCode));
//		return "products/edit";
//	}
	
	@RequestMapping(value="/{productNum}/{productId}/edit.htm", method = RequestMethod.GET)
	public String editProduct(@PathVariable("productNum") int productNum ,@PathVariable("productId") String productCode, Model model){
		System.out.println("Product: "+productCode);
		System.out.println("Num; "+productNum);
		ProductModelView productModel = (ProductModelView) productService.obtenerProductoModel(productNum, productCode);
		model.addAttribute("product", productModel);
		return "products/edit";
	}
	
	@RequestMapping(value="/editProduct.htm" ,method = RequestMethod.POST)
	public String editProduct(@ModelAttribute("product") ProductModelView productModel){
		productService.actualizarProducto(productModel);
		return "redirect:/products/productlist.htm?page_var=0";
	}
	
	@RequestMapping(value="/{productDeleteCode}/deleteProduct.htm", method = RequestMethod.POST)
	public String deleteProduct(@PathVariable("productDeleteCode") String productCode){
		System.out.println("Product: "+productCode);
		return "redirect:/products/productlist.htm?page_var=0";
	}
	
	@RequestMapping(value="/deleteProduct.htm", method = RequestMethod.POST)
	public String deleteProductTable(@RequestParam("codeProductModel") String productCode, @ModelAttribute("productTable") ProductModelView productModel){
		System.out.println("Product code: "+productCode);
		System.out.println(productModel.toString());
		return "redirect:/products/productlist.htm?page_var=0";
	}
	
	
}
