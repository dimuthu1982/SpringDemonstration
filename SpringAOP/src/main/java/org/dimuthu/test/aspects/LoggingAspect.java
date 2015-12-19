package org.dimuthu.test.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	@AfterReturning(pointcut="execution(* callingAfterReturningPointCutMethod())")
	public void applyAfterReturningPointCut(String passingVal){
		System.out.println("Apply @AfterReturning annotation passingVal("+passingVal+"), nameReturning("+null+")");
	}
	
}
