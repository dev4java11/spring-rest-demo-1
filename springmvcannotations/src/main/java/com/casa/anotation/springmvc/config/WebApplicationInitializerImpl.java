package com.casa.anotation.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplicationInitializerImpl 
//implements WebApplicationInitializer 
{
//
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//		ctx.register(MvcConfig.class);
//		ctx.setServletContext(servletContext);
//		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
//		servlet.addMapping("/springmvcannotations/");
//		servlet.setLoadOnStartup(1);
//	}

}
