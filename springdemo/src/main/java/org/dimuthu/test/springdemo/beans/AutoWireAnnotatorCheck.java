package org.dimuthu.test.springdemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * By setting the @Autowired annotation, Spring container will look for the type (ByType) that matches the HelloWorld for injection. If not found then search upon the 
 * name (ByName) "helloWorldInjection". If not found, which means there is no type by the defined, or there are multiple beans belongs to the same type.
 * In such a case we have to specify a @Qualifier to narrow the search down.
 * @author Dimuthu Abeynayake
 *
 */
public class AutoWireAnnotatorCheck {

	private HelloWorld helloWorldInjection;

	public HelloWorld getHelloWorldInjection() {
		return helloWorldInjection;
	}

	@Autowired
	@Qualifier("helloWorldPlaceHolder")
	public void setHelloWorldInjection(HelloWorld helloWorldInjection) {
		this.helloWorldInjection = helloWorldInjection;
	}

}
