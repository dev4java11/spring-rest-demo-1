package com.casa.anotation.springmvc.audit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ApplicationTransactionAuditSystem {

	@Pointcut("@within(org.springframework.transaction.annotation.Transactional)")
	public void auditTransactional(){}
	
	//@Around(value="auditTransactional()")
	public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("[Transaccion] -> Iniciando Transaccion: "+ joinPoint.getSignature().getName());
		joinPoint.proceed();
		System.out.println("[Transaccion] -> Transaccion finalizada con exito!!");
		System.out.println("****************************************************************");
	}
	
	@Before("auditTransactional()")
	public void preTransaction(JoinPoint joinPoint){
		System.out.println("[Transaccion] -> Iniciando Transaccion: "+ joinPoint.getSignature().getName());
	}
}
