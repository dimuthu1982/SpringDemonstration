package org.dimuthu.test.SpringAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.dimuthu.test.beans.MainLogicBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAopApplication {

	private static final AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static final MainLogicBean logicBean = context.getBean("mainLogicBean",MainLogicBean.class);


	public static void main(String[] args) {


		//		applyTwoAdvicesSamePointCut();

		//		applyArgumentSpecificPointCut();

		//		applyAfterPointCut();

		//		applyAfterReturningPontCut();

		//		applyAfterThrowingPontCut();


//		applyAroundPointCut();
		
		applyCustomAdvice();
	}

	private static void applyCustomAdvice() {
		logicBean.callingCustomAnnotatedPointCutMethod();
		
	}

	/**
	 * Following methods Point cut happens around the method
	 * @Around("execution(* callingAroundPointCutMethod())")
	 * 
	 * for this, it is mandatory for the Advice to take ProceedingJoinPoint joinPoint as a parameter to delegate to the subsequest 
	 * codes by calling proceed() method.
	 */
	private static void applyAroundPointCut() {
		logicBean.callingAroundPointCutMethod();		
	}

	/**
	 * Following method will throw an Runtime exception which the point cut will trigger.
	 * @AfterThrowing(pointcut="execution(* callingAfterThrowingPointCutMethod())", throwing="ex")
	 */
	private static void applyAfterThrowingPontCut() {
		logicBean.callingAfterThrowingPointCutMethod();
	}

	/**
	 * Following method will concatenated the two parameters and prepend "Mr" causing the returning value to be "Mr. Mark Antony"
	 * @AfterReturning(pointcut="execution(* callingAfterReturningPointCutMethod(..))", returning="returningVal") will trigger
	 * the call to applyAfterReturningPointCut()
	 */
	private static void applyAfterReturningPontCut() {
		logicBean.callingAfterReturningPointCutMethod("Mark","Antony");
	}

	private static void applyAfterPointCut() {
		logicBean.callingAfterPointCutMethod();
	}

	/**
	 * Apply Advice to a point cut which takes an argument as String
	 */
	private static void applyArgumentSpecificPointCut() {
		logicBean.callingArgumentSpecificPointCutMethod("Dimuthu Kasun");

	}


	/**
	 * Following method apply two advises to the same point cut
	 * This an be handled by adding point cut as follows:
	 *  @Pointcut("execution(* applyTwoPointCuts())") : Defined a point cut when executing applyTwoPointCuts() method. This will point to a dummy method.
	 *  @Before("applyTwoPointCutTemplte()") : This will apply on top of the actual method.
	 */
	private static void applyTwoAdvicesSamePointCut() {
		logicBean.callingTwoPointCutMethod();
	}

}
