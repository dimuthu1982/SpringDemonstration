package org.dimuthu.test.beans;

import org.springframework.stereotype.Component;

@Component
public class MainLogicBean {

	public void callingTwoPointCutMethod(){
		System.out.println("Calling Two Pontcut Method");
	}

	public void callingArgumentSpecificPointCutMethod(String myName) {
		System.out.println("Calling Argument Specific PointCut Method: Argument ("+myName+")");
	}

	public void callingAfterPointCutMethod() {
		System.out.println("Calling After PointCut Method");
	}

	public String callingAfterReturningPointCutMethod(String name) {
		System.out.println("Calling After Returning PointCut Method name=("+name+")");
		return name.concat(" Kasun");
	}

	public String callingAfterThrowingPointCutMethod(String name) {
		System.out.println("Calling After Throwinng PointCut Method name=("+name+")");
		return name.concat(" Kasun");
	}
	
	
}
