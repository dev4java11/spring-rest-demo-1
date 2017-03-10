package com.casa.anotation.springmvc.audit;

import java.util.Calendar;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class ApplicationAuditSystem {
	
	@Pointcut("execution (* com.casa.anotation.springmvc.service.*.*(..))")
	public void audit(){}
	
	
	

	//@Before("audit()")
	public void preMethod(JoinPoint joinPoint){
		System.out.println("*************************** PreMethod **********************************");
		System.out.println("Se ejecutara el metodo: "+ joinPoint.getSignature().getName());
		System.out.println("************************************************************************");
		
	}
	
	@After("audit()")
	public void postMethod(JoinPoint joinPoint){
		System.out.println("*************************** PostMethod **********************************");
		System.out.println("Se ejecuto el metodo: "+ joinPoint.getSignature().getName() + " en la fecha: " + Calendar.getInstance());
		System.out.println("*************************************************************************");
	}
	
	//@Around("audit()")
	public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("*************************** PreMethod **********************************");
		System.out.println("Se ejecutara el metodo: "+ joinPoint.getSignature().getName());
		System.out.println("************************************************************************");
		joinPoint.proceed();
		System.out.println("*************************** PostMethod **********************************");
		System.out.println("Se ejecuto el metodo: "+ joinPoint.getSignature().getName() + " en la fecha: " + (new Date()));
		System.out.println("*************************************************************************");
	}
	
	@AfterThrowing(value = "audit()", throwing = "error")
	public void exceptionMethod(JoinPoint joinPoint, Throwable error){
		System.out.println("*************************** PostMethod **********************************");
		System.out.println("Se ejecuto el metodo: "+ joinPoint.getSignature().getName() + " en la fecha: " + (new Date()));
		System.out.println("Arrojo un error: "+ error);
		System.out.println("*************************************************************************");
	}
	
	//@AfterReturning(value = execution_application, returning = "result")
	public void resultMethod(JoinPoint joinPoint, Object result){
		
	}
}
