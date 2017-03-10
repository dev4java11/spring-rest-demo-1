package com.casa.anotation.springmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.casa.anotation.springmvc.domain.Product;
import com.casa.anotation.springmvc.model.GenericProductModel;
import com.casa.anotation.springmvc.model.ProductModelView;

public interface ProductService {
	
	public List<ProductModelView> obtenerStockProductos();
	
	public void agregarProducto(Product product, String productLine, int scale);
	
	public void agregarNuevoProducto(ProductModelView model);
	
	public void actualizarProducto(ProductModelView model);
	
	public void eliminarProducto(ProductModelView model);
	
	public void eliminarProducto(String id);
	
	public List<String> obtenerLineaProductos();
	
	public Page<Product> obtenerStockProductos(int pagina, int cantidadPagina);
	
	public List<? extends GenericProductModel> obtenerProductosModel(int pagina, int cantidadPagina);
	
	public int getNumberTotalPage();
	
	public GenericProductModel obtenerProductoModel(int numProduct, String codeProduct);
	
	

}
