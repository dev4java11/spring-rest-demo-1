package com.casa.anotation.springmvc.config;


import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.casa.anotation.springmvc.audit.ApplicationAuditSystem;
import com.casa.anotation.springmvc.audit.ApplicationTransactionAuditSystem;

@Configuration
@ComponentScan(basePackages={"com.casa.anotation.springmvc.service.impl"})
@Import(value = {PersistenceConfig.class})
@EnableTransactionManagement
public class ServiceConfig{
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}
	
}
