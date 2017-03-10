package com.casa.anotation.springmvc.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.casa.anotation.springmvc.config.ApplicationConfig;
import com.casa.anotation.springmvc.config.MvcConfig;
import com.casa.anotation.springmvc.controller.EmployeeController;
import com.casa.anotation.springmvc.controller.HomeController;
import com.casa.anotation.springmvc.model.EmployeeModelView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class, ApplicationConfig.class})
@WebAppConfiguration
public class SpringMVCTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		//this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
	}
	
	//@Test
	public void test() {
		System.out.println("inicializando");
		try {
			MvcResult result = this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("home"))
			.andReturn();
			System.out.println(result.getRequest().getSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testProductController() throws Exception{
		MvcResult result = this.mockMvc.perform(get("/products/productlist.htm?page_var={page_var}",1))
				.andExpect(view().name("products/productlist"))
				.andExpect(status().isOk())
				.andReturn();
		System.out.println(result.getModelAndView().getModel().get("pages"));
	}
	
	//@Test
	public void testEmployeeController() throws Exception{
		MvcResult result = this.mockMvc.perform(get("/employees/employeelist.htm").param("page_var", "0"))
				.andExpect(view().name("employees/employeelist"))
				.andExpect(status().isOk())
				.andReturn();
		System.out.println(result.getModelAndView().getModelMap().get("totalPages"));
	}
	
	@Test
	public void testEmployeeEdit() throws Exception{
		MvcResult result = this.mockMvc.perform(get("/employees/{employee_id}/employee_edit.htm", 1002))
				.andExpect(view().name("employees/employee_edit"))
				.andExpect(status().isOk())
				.andReturn();
		EmployeeModelView model = (EmployeeModelView) result.getModelAndView().getModelMap().get("employee");
		System.out.println(model.getEmployeeModel().toString());
	}

}
