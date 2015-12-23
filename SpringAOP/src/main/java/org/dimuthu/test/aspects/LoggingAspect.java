package org.dimuthu.test.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("applyTwoPointCutTemplte()")
	public void applyPointCutOne(JoinPoint point){
		System.out.println("Applying Advice 1: ");
	}
	
	@Before("applyTwoPointCutTemplte()")
	public void applyPointCutTwo(){
		System.out.println("Applying Advice 2");
	}
	
	@Pointcut("execution(* callingTwoPointCutMethod())")
	public void applyTwoPointCutTemplte(){}
	
	@Before("args(passingName)")
	public void applyArgumentSpecificPointCut(String passingName){
		System.out.println("Apply Argument Specific Advice by Name ("+passingName+")");
	}
	
	@After("execution(* callingAfterPointCutMethod())")
	public void applyAfterPointCut(){
		System.out.println("Apply @After annotation");
	}
	
	@AfterReturning(pointcut="execution(* callingAfterReturningPointCutMethod(..))", returning="returningVal")
	public void applyAfterReturningPointCut(String returningVal){
		System.out.println("Apply @AfterReturning annotation Value Returned ("+returningVal+")");
	}
	
	@AfterThrowing(pointcut="execution(* callingAfterThrowingPointCutMethod())", throwing="ex")
	public void applyAfterExceptionPointCut(RuntimeException ex){
		System.out.println("Apply @AfterThrowing annotation Exception Caught ("+ex+")");
	}
	
	@Around("execution(* callingAroundPointCutMethod())")
	public void applyAfterPointCut(ProceedingJoinPoint joinPoint){
		System.out.println("Apply @Around annotation Before");
		try {
			Object obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Apply @Around annotation After");
	}
	
	
	@Around("@annotation(org.dimuthu.test.aspects.MyCustomPointCut)")
	public void applyCustomAnnotatedPointCut(ProceedingJoinPoint joinPoint){
		System.out.println("Apply @MyCustomPointCut annotation Before");
		try {
			Object obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Apply @MyCustomPointCut annotation After");
	}
}
