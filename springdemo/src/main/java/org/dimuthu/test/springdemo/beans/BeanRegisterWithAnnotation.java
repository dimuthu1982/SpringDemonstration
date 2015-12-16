package org.dimuthu.test.springdemo.beans;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class BeanRegisterWithAnnotation {

	private HelloWorld helloWorld;

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	@Resource(name="helloWorldExtendor")
	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}
}
