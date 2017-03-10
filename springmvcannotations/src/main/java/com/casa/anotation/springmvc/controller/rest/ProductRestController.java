package com.casa.anotation.springmvc.controller.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.casa.anotation.springmvc.model.GenericProductModel;
import com.casa.anotation.springmvc.model.ProductModelView;
import com.casa.anotation.springmvc.model.json.ResultStateMessage;
import com.casa.anotation.springmvc.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<ProductModelView> getAllProducts(){
		return productService.obtenerStockProductos();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/page", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<ProductModelView> getPageProducts(@RequestParam("page") int page, @RequestParam("size") int size){
		return (List<ProductModelView>) productService.obtenerProductosModel(page, size);
	}
	
	@RequestMapping(value = "/{cod}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public GenericProductModel getProduct(@PathVariable("cod") String cod){
		return productService.obtenerProductoModel(-1, cod);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultStateMessage> insertProduct(@RequestBody ProductModelView pmv){
		try{
			if(pmv.isEmpty()){
				return new ResponseEntity<ResultStateMessage>(new ResultStateMessage(false, "No hay contenido en el producto", pmv), HttpStatus.NO_CONTENT);
			}else{
				productService.agregarNuevoProducto(pmv);
				return new ResponseEntity<ResultStateMessage>(new ResultStateMessage(true, "Se creo el Producto.", pmv), HttpStatus.ACCEPTED);
			}
		}catch(Exception ex){
			return new ResponseEntity<ResultStateMessage>(new ResultStateMessage(false, "Error en el Servidor.", pmv), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultStateMessage> updateProduct(@RequestBody ProductModelView pmv){
		try{
			if(pmv.isEmpty()){
				return new ResponseEntity<ResultStateMessage>(new ResultStateMessage(false, "No hay contenido en el producto", pmv), HttpStatus.NO_CONTENT);
			}else{
				productService.actualizarProducto(pmv);
				return new ResponseEntity<ResultStateMessage>(new ResultStateMessage(true, "Se actualizo el Producto.", pmv), HttpStatus.ACCEPTED);
			}
		}catch(EntityNotFoundException enfe){
			return new ResponseEntity<ResultStateMessage>(new ResultStateMessage(false, "No se encontro el producto.", pmv), HttpStatus.NOT_FOUND);
		}catch(Exception ex){
			return new ResponseEntity<ResultStateMessage>(new ResultStateMessage(false, "Error en el Servidor.", pmv), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultStateMessage> deleteProduct(@RequestParam("idProduct") String idProduct){
		try{
			productService.eliminarProducto(idProduct);
			return new ResponseEntity<ResultStateMessage>(new ResultStateMessage(true, "Se elimino el producto."), HttpStatus.ACCEPTED);
		}catch(EntityNotFoundException enfe){
			return new ResponseEntity<ResultStateMessage>(new ResultStateMessage(false, "No se encontro el producto."), HttpStatus.NOT_FOUND);
		}catch(Exception ex){
			return new ResponseEntity<ResultStateMessage>(new ResultStateMessage(false, "Error en el Servidor."), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
