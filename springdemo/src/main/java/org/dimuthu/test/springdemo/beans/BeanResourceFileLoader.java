package org.dimuthu.test.springdemo.beans;

import org.dimuthu.test.springdemo.beans.event.BeanResourceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class BeanResourceFileLoader implements ApplicationEventPublisherAware{

	@Autowired
	private MessageSource messageResource;

	private ApplicationEventPublisher eventPublisher;

	public void printGreetingByMyMessageFile(){
		System.out.println(messageResource.getMessage("myMessageFile.greetings", null, null));
	}

	public void printGreetingByMyContentFile(){
		System.out.println(messageResource.getMessage("myContentFile.greetings", null, null));
	}
	
	public void printCustomisedGreetingByMyMessageFile(){
		System.out.println(messageResource.getMessage("myMessageFile.customGreting", new Object[]{"Mr Tony"}, null));
	}

	public void printCustomisedGreetingByMyContentFile(){
		System.out.println(messageResource.getMessage("myContentFile.customGreting", new Object[]{"Mr Tony"}, null));
	}

	public MessageSource getMessageResource() {
		return messageResource;
	}

	public void setMessageResource(MessageSource messageResource) {
		this.messageResource = messageResource;
	}
	
	public void customEventThrower(){
		BeanResourceEvent event = new BeanResourceEvent(this);
		this.eventPublisher.publishEvent(event);
	}

	
	
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.eventPublisher = publisher;		
	}
}
