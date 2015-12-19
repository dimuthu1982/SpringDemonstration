package org.dimuthu.test.SpringAOP;

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
		
		applyAfterThrowingPontCut();
	}

	private static void applyAfterThrowingPontCut() {
		logicBean.callingAfterThrowingPointCutMethod("Dimuthu");
		
	}

	private static void applyAfterReturningPontCut() {
		logicBean.callingAfterReturningPointCutMethod("Dimuthu");
	}

	private static void applyAfterPointCut() {
		logicBean.callingAfterPointCutMethod();
	}

	/**
	 * Applys Advice to a point cut which takes an argument as String
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
