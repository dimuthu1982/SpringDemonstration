package org.dimuthu.test.springdemo.beans;

import org.springframework.beans.factory.annotation.Required;

/**
 * Defining the Required annotation indicates that it is mandatory for the property to set a value for the bean to function. Otherwise an error is thrown
 * at the run-time.
 * By setting the Required annotation and registering RequiredAnnotationBeanPostProcessor in Spring xml, Spring container validates the annotation and throws an 
 * exception after validating the context which has been loaded.   
 * @author Dimuthu Abeynayake
 *
 */
public class AnnotationCheckerBean {

	private String message;

	public String getMessage() {
		return message;
	}

	@Required
	public void setMessage(String message) {
		this.message = message;
	}
}
