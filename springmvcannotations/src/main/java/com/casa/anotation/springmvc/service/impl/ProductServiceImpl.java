package com.casa.anotation.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.casa.anotation.springmvc.domain.Product;
import com.casa.anotation.springmvc.domain.Productline;
import com.casa.anotation.springmvc.model.GenericProductModel;
import com.casa.anotation.springmvc.model.ProductModelView;
import com.casa.anotation.springmvc.repository.ProductLineRepository;
import com.casa.anotation.springmvc.repository.ProductRepository;
import com.casa.anotation.springmvc.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	private int numberTotalPage = 0;
	
	private ProductRepository productRepository;
	
	private ProductLineRepository productLineRepository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Autowired
	public void setProductLineRepository(ProductLineRepository productLineRepository) {
		this.productLineRepository = productLineRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductModelView> obtenerStockProductos(){
		List<Product> products = productRepository.findAll();
		List<ProductModelView> models = new ArrayList<ProductModelView>();
		int i = 0;
		for(Product p: products){
			models.add(transforToModel(i, p));
			i++;
		}
		return models;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW , isolation = Isolation.SERIALIZABLE, readOnly = false,rollbackFor={Exception.class})
	public void agregarProducto(Product product, String productLine, int scale){
		String codeProduct = productRepository.generateProductCode(scale);
		Productline line = productLineRepository.findByproductLine(productLine);
		product.setProductCode(codeProduct);
		product.setProductline(line);
		productRepository.save(product);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW , isolation = Isolation.SERIALIZABLE, readOnly = false, rollbackFor={Exception.class})
	public void agregarNuevoProducto(ProductModelView model){
		String codeProduct = productRepository.generateProductCode(model.getFormScaleProductModel());
		Product product = new Product();
		product.setProductCode(codeProduct);
		product.setProductName(model.getNameProductModel());
		Productline pl = productLineRepository.findByproductLine(model.getLineProductModel());
		product.setProductline(pl);
		product.setProductScale("1:"+String.valueOf(model.getFormScaleProductModel()));
		product.setProductVendor(model.getVendorProductModel());
		product.setQuantityInStock((short) model.getStockProductModel());
		product.setBuyPrice(model.getPriceProductModel());
		product.setMsrp(model.getMsrpProductModel());
		product.setProductDescription(model.getDescriptionProductModel());
		productRepository.save(product);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false, rollbackFor = {Exception.class})
	public void actualizarProducto(ProductModelView model){
		if(productRepository.exists(model.getCodeProductModel())){
			Product product = transformToEntity(model);
			productRepository.save(product);
		}else{
			throw new EntityNotFoundException("No existe el producto.");
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false, rollbackFor = {Exception.class})
	public void eliminarProducto(ProductModelView model){
		if(productRepository.exists(model.getCodeProductModel())){
			Product product = transformToEntity(model);
			productRepository.delete(product);
		}else{
			throw new EntityNotFoundException("No existe el producto.");
		}
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false, rollbackFor = {Exception.class})
	public void eliminarProducto(String id){
		if(productRepository.exists(id)){
			productRepository.delete(id);
		}else{
			throw new EntityNotFoundException("No existe el producto.");
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<String> obtenerLineaProductos(){
		List<String> lineas = new ArrayList<String>();
		List<Productline> productlines = productLineRepository.findAll();
		for(Productline pl : productlines){
			lineas.add(pl.getProductLine());
		}
		return lineas;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> obtenerStockProductos(int pagina, int cantidadPagina){
		Sort sort = new Sort(Sort.Direction.ASC, "productCode");
		Pageable pageable = new PageRequest(pagina, cantidadPagina, sort);
		return productRepository.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<? extends GenericProductModel> obtenerProductosModel(int pagina, int cantidadPagina){
		Sort sort = new Sort(Sort.Direction.ASC, "productCode");
		Pageable pageable = new PageRequest(pagina, cantidadPagina, sort);
		Page<Product> pageProducts = productRepository.findAll(pageable);
		numberTotalPage = pageProducts.getTotalPages();
		List<Product> list = pageProducts.getContent();
		List<ProductModelView> modelList = new ArrayList<ProductModelView>();
		for(int i=0;i<list.size();i++){
			Product p = list.get(i);
			ProductModelView model = transforToModel(i, p);
			modelList.add(model);
		}
		return modelList;
	}
	
	@Override
	public int getNumberTotalPage() {
		return numberTotalPage;
	}
	
	@Override
	@Transactional(readOnly = true)
	public GenericProductModel obtenerProductoModel(int numProduct, String codeProduct){
		Product p =  productRepository.findOne(codeProduct);
		return transforToModel(numProduct, p);
	}
	
	private ProductModelView transforToModel(int numProduct, Product p){
		ProductModelView model = new ProductModelView(numProduct, p.getProductCode(), p.getProductName(), p.getProductline().getProductLine(), p.getProductScale(), p.getProductVendor(), p.getProductDescription(), p.getQuantityInStock(), p.getBuyPrice(), p.getMsrp());
		return model;
	}
	
	private Product transformToEntity(ProductModelView model){
		Product product = new Product();
		if(model.getCodeProductModel() == null || model.getCodeProductModel().isEmpty()){
			String codeProduct = productRepository.generateProductCode(model.getFormScaleProductModel());
			product.setProductCode(codeProduct);
		}else{
			product.setProductCode(model.getCodeProductModel());
		}
		product.setProductName(model.getNameProductModel());
		Productline pl = productLineRepository.findByproductLine(model.getLineProductModel());
		product.setProductline(pl);
		if(model.getScaleProductModel() == null || model.getScaleProductModel().isEmpty()){
			product.setProductScale("1:"+String.valueOf(model.getFormScaleProductModel()));
		}else{
			product.setProductScale(model.getScaleProductModel());
		}
		product.setProductVendor(model.getVendorProductModel());
		product.setQuantityInStock((short) model.getStockProductModel());
		product.setBuyPrice(model.getPriceProductModel());
		product.setMsrp(model.getMsrpProductModel());
		product.setProductDescription(model.getDescriptionProductModel());
		return product;
	}
	
}
