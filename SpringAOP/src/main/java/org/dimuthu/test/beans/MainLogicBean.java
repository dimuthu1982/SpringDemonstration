package org.dimuthu.test.beans;

import org.dimuthu.test.aspects.MyCustomPointCut;
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

	public String callingAfterReturningPointCutMethod(String firstName,String lastName) {
		System.out.println("Calling After Returning PointCut Method { First Name=("+firstName+"), Last Name=("+lastName+")}");
		return "Mr. ".concat(firstName).concat(" ").concat(lastName);
	}

	public void callingAfterThrowingPointCutMethod() {
		System.out.println("Calling After Throwinng PointCut Method");
		throw new RuntimeException("Find Throwing PointCut");
	}

	public void callingAroundPointCutMethod() {
		System.out.println("Calling Around Method");
	}

	@MyCustomPointCut
	public void callingCustomAnnotatedPointCutMethod() {
		System.out.println("Calling Custom Annotated Method");
	}
	
	
	
	
}
