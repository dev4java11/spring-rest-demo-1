package com.casa.anotation.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ServiceConfig.class, UtilConfig.class, AuditConfig.class})
public class ApplicationConfig {

}
