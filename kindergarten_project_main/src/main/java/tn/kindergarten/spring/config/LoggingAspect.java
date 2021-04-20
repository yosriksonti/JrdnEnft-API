package tn.kindergarten.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component

	@Aspect
	 

	public class LoggingAspect {
	private static final Logger logger =
	(Logger) LogManager.getLogger(LoggingAspect.class);
	@Before("execution(* tn.kindergarten.spring.service.EventServiceImpl.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	System.out.println("Before");
	System.out.println(joinPoint.getSignature().getName()+ "called with");
	System.out.println(Arrays.toString(joinPoint.getArgs()));
	}
	@After("execution(* tn.kindergarten.spring.service.EventServiceImpl.*(..))")
	public void logMethodExit(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	System.out.println(joinPoint.getSignature().getName());
	
	}}

