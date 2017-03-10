package com.casa.anotation.springmvc.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import java.util.List;

import javax.xml.transform.Source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.casa.anotation.springmvc.controller")
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		if(!registry.hasMappingForPattern("/bootstrap/**")){
			registry.addResourceHandler("/bootstrap/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/3.3.5/");
		}
		if(!registry.hasMappingForPattern("/jquery/**")){
			registry.addResourceHandler("/jquery/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/jquery/1.11.1/");
		}
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("prop/messages");
		return bundleMessageSource;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

//	@Bean
//	public InternalResourceViewResolver viewResolver(){
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/views/");
//		viewResolver.setSuffix(".jsp");
//		viewResolver.setViewClass(JstlView.class);
//		return viewResolver;
//	}
	
	@Bean
	public ServletContextTemplateResolver templateResolver(){
		ServletContextTemplateResolver contextTemplateResolver = new ServletContextTemplateResolver();
		contextTemplateResolver.setPrefix("/WEB-INF/views/");
		contextTemplateResolver.setSuffix(".html");
		contextTemplateResolver.setTemplateMode("HTML5");
		contextTemplateResolver.setCacheable(false);
		return contextTemplateResolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine(ServletContextTemplateResolver resolver){
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(resolver);
		springTemplateEngine.addDialect(new LayoutDialect());
		return springTemplateEngine;
	}
	
	@Bean
	public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}
	
	
	/*Soporte para producir JSON */
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true)
		//.favorParameter(true)
		.ignoreAcceptHeader(true)
		.useJaf(false)
		.defaultContentType(MediaType.TEXT_HTML)
		.mediaType("html", MediaType.TEXT_HTML)
		.mediaType("json", MediaType.APPLICATION_JSON);
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
		stringConverter.setWriteAcceptCharset(false);
		converters.add(new ByteArrayHttpMessageConverter());
        converters.add(stringConverter);
        converters.add(new ResourceHttpMessageConverter());
        converters.add(new SourceHttpMessageConverter<Source>());
        converters.add(new AllEncompassingFormHttpMessageConverter());
		converters.add(jackson2HttpMessageConverter());
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter(){
		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jackson2HttpMessageConverter.setObjectMapper(objectMapper());
		return jackson2HttpMessageConverter;
	}
	
	@Bean
	public ObjectMapper objectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		return objectMapper;
	}
	
}
