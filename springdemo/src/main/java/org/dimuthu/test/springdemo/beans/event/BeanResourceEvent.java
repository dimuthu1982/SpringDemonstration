package org.dimuthu.test.springdemo.beans.event;

import org.springframework.context.ApplicationEvent;

public class BeanResourceEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BeanResourceEvent(Object source) {
		super(source);
	}

	public String toString(){
		return "Bean Event Fired";
	}

}
