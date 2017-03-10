package pe.com.alliance.storeapp.server.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import pe.com.alliance.storeapp.server.configuration.ApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
@TestExecutionListeners(listeners={
		DirtiesContextTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class
})
@TransactionConfiguration(defaultRollback = false)
public class ApplicationTest {

	
	
	@Test
	public void test() {
		
	}

}
