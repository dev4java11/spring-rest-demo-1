package com.casa.anotation.springmvc.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
//@ComponentScan("com.casa.anotation.springmvc.repository")
@EnableJpaRepositories(basePackages = {"com.casa.anotation.springmvc.repository"})
@PropertySource("classpath:prop/database.properties")
public class PersistenceConfig {
	
	@Autowired
	private Environment environment;
	
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("database.driverclass"));
		dataSource.setUrl(environment.getProperty("database.url"));
		dataSource.setUsername(environment.getProperty("database.username"));
		dataSource.setPassword(environment.getProperty("database.password"));
		return dataSource;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setPackagesToScan("com.casa.anotation.springmvc.domain");
		factoryBean.setDataSource(dataSource());
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}
	
	
}
