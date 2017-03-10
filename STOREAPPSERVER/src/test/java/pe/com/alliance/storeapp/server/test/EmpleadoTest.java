package pe.com.alliance.storeapp.server.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;

import pe.com.alliance.storeapp.server.service.GestorEmpleadoService;

public class EmpleadoTest extends ApplicationTest {

	@Autowired
	private GestorEmpleadoService empleadoService;
	
	@Test
	public void test() {
		System.out.println(empleadoService.buscarPaginacionEmpleados(0, 10));
	}

}
