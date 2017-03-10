package com.casa.anotation.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.casa.anotation.springmvc.audit.ApplicationAuditSystem;
import com.casa.anotation.springmvc.audit.ApplicationTransactionAuditSystem;

@Configuration
@ComponentScan(basePackages={"com.casa.anotation.springmvc.audit"})
@EnableAspectJAutoProxy
public class AuditConfig {
	
	
	@Bean
	public ApplicationAuditSystem applicationAuditSystem(){
		ApplicationAuditSystem applicationAuditSystem = new ApplicationAuditSystem();
		return applicationAuditSystem;
	}

	
	@Bean
	public ApplicationTransactionAuditSystem applicationTransactionAuditSystem(){
		ApplicationTransactionAuditSystem applicationTransactionAuditSystem = new ApplicationTransactionAuditSystem();
		return applicationTransactionAuditSystem;
	}
}
