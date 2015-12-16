package org.dimuthu.test.springdemo;

import org.dimuthu.test.springdemo.beans.BeanRegusterWithAnnotation;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class MainApplication 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	
//    	Calling Bean Injection
    	/*HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
    	System.out.println("helloWorld.getMessage() : " + helloWorld.getMessage());*/
    	
//    	LifeCycle CallBack Bean
/*    	
    	context.registerShutdownHook();
    	CallBackBeanMethods obj = (CallBackBeanMethods) context.getBean("callbackBean");
		System.out.println("Your Message : " + obj.getMyName());*/
    	
    	/*Property Place Holder was register to inject the values from SpringData.properties
    	 * So the value is printed as : My Message for Place Holder
    	 */
    	/*HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorldPlaceHolder");
    	System.out.println("helloWorld.getMessage() : " + helloWorld.getMessage());
    	*/
    	
//    	@Required annotated
    	/*AnnotationCheckerBean annotationCheckerBean = (AnnotationCheckerBean) context.getBean("annotationChecker");
    	System.out.println("helloWorld.getMessage() : " + annotationCheckerBean.getMessage());*/
    	
//    	Auto Wire
    	/*AutoWireAnnotatorCheck autoWireAnnotatorCheck = (AutoWireAnnotatorCheck) context.getBean("autoWireAnnotationChecker");
    	System.out.println("autoWireAnnotatorCheck.getMessage() : " + autoWireAnnotatorCheck.getHelloWorldInjection().getMessage());*/
    	
    	BeanRegusterWithAnnotation beanRegusterWithAnnotation = (BeanRegusterWithAnnotation) context.getBean("beanRegusterWithAnnotation");
    	System.out.println("BeanRegusterWithAnnotation.getMessage() : " + beanRegusterWithAnnotation.getHelloWorld().getMessage());
    }
}
