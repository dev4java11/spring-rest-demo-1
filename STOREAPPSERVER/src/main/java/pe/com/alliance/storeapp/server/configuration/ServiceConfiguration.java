package pe.com.alliance.storeapp.server.configuration;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static pe.com.alliance.storeapp.server.util.Constantes.*;

@Configuration
@Import(RepositoryConfiguration.class)
@ComponentScan(basePackages = {SCAN_PKG_SERVICE, SCAN_PKG_TRANSFORMER})
@EnableTransactionManagement
public class ServiceConfiguration {

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

}
