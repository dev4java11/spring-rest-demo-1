package com.casa.anotation.springmvc.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import javax.activation.FileDataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.casa.anotation.springmvc.model.EmployeeModelView;
import com.casa.anotation.springmvc.service.EmployeeService;
import com.casa.anotation.springmvc.service.impl.EmployeeServiceImpl;

public class ServiceTest extends ApplicationTest{

	@Autowired
	private EmployeeService employeeService;
	
	
	@Test
	public void test() {
		EmployeeModelView model = employeeService.obtenerJefeOficina(1002, "1");
		System.out.println(model.getEmployeeModel().toString());
	}
	
	//@Test
	public void test2(){
		String path = "C:\\opt\\software\\key\\MGIN\\clavesegurades.key";
		FileDataSource dataSource = new FileDataSource(new File(path));
		StringBuilder sb = new StringBuilder();
		BufferedReader buffer = null;
		try {
			InputStream ist = dataSource.getInputStream();
			buffer = new BufferedReader(new InputStreamReader(ist));
			String line = "";
			while((line = buffer.readLine()) != null){
				sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(buffer != null){
				try {
					buffer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(sb);
	}
	
}
