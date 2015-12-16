package org.dimuthu.test.springdemo.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Following is the code sample to demonstrate the Bean life cycle callback methods.
 * Sample Output : 
				Setter Methods Called
				InitializingBean.afterPropertiesSet()
				Spring XML.init-method="initMethod"
				DisposableBean.destroy()
				Spring XML.destroy-method="destroyMethod"
  Method Calling sequence: 
 	1. setMyName()
 	2. InitializingBean.afterPropertiesSet()
 	3. Spring Bean Configurations initMethod()
 	4. DisposableBean.destroy()
 	5. Spring Bean Configurations destroyMethod()
  		
 * @author Dimuthu Abeynayake
 *
 */
public class CallBackBeanMethods implements InitializingBean,DisposableBean{

	private String myName;
	
	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		System.out.println("Setter Methods Called");
		this.myName = myName;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean.afterPropertiesSet()");
	}
	
	public void initMethod(){
		System.out.println("Spring XML.init-method=\"initMethod\"");
	}
	
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destroy()");
	}
	
	
	public void destroyMethod(){
		System.out.println("Spring XML.destroy-method=\"destroyMethod\"");
	}
	
}
