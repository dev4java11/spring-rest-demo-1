package com.casa.anotation.springmvc.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.casa.anotation.springmvc.config.ApplicationConfig;
import com.casa.anotation.springmvc.config.PersistenceConfig;
import com.casa.anotation.springmvc.config.ServiceConfig;
import com.casa.anotation.springmvc.domain.Product;
import com.casa.anotation.springmvc.domain.Productline;
import com.casa.anotation.springmvc.model.GenericProductModel;
import com.casa.anotation.springmvc.model.ProductModelView;
import com.casa.anotation.springmvc.repository.ProductLineRepository;
import com.casa.anotation.springmvc.repository.ProductRepository;
import com.casa.anotation.springmvc.service.ProductService;
import com.casa.anotation.springmvc.service.impl.ProductServiceImpl;
import com.casa.anotation.springmvc.util.EncriptorUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class
	,TransactionalTestExecutionListener.class})
public class ApplicationTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductLineRepository productLineRepository;
	
	@Autowired
	private ProductService productService;
	
	//@Test
	public void testApplication(){
		System.out.println(productRepository);
	}
	
	//@Test
	public void test() {
		Sort sort = new Sort(Sort.Direction.ASC, "quantityInStock");
		Pageable pageable = new PageRequest(20, 10, sort);
		Page<Product> pageProduct = productRepository.findAll(pageable);
		System.out.println(pageProduct.getTotalPages());
		System.out.println(pageProduct.getContent().size());
		for(Product p : pageProduct.getContent()){
			System.out.println(p.getProductCode()+ " - "+p.getQuantityInStock());
		}
		
	}
	
	///@Test
	public void test2(){
		List<Productline> lines = productLineRepository.findAll();
		Productline pl = productLineRepository.findByproductLine(lines.get(0).getProductLine());
		System.out.println(pl.getProductLine());
	}
	
	//@Test
	public void testProcedure(){
		String code = productRepository.generateProductCode(12);
		System.out.println(code);
	}
	
	//@Test
	public void testTransactionAgregar(){
		ProductModelView pm = new ProductModelView(-1, null, "NAME", "Planes", null, "VENDOR", "DESCRIPTION", 15, 77.27, 157.69, 120);
		productService.agregarNuevoProducto(pm);
	}
	
	//@Test
	public void encriptacion(){
		String cad = "hernan";
		String encode = EncriptorUtil.encode(cad);
		System.out.println(encode);
		String decode = EncriptorUtil.decode(encode);
		System.out.println(decode);
	}
	
	

}
