package org.dimuthu.test.springdemo.beans.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BeanResourceEventListener implements ApplicationListener<BeanResourceEvent> {

	public void onApplicationEvent(BeanResourceEvent bean) {
		System.out.println("Bean Has Fired an Event : " + bean.toString());		
	}

}
