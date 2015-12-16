package org.dimuthu.test.springdemo;

import org.dimuthu.test.springdemo.beans.AnnotationCheckerBean;
import org.dimuthu.test.springdemo.beans.AutoWireAnnotatorCheck;
import org.dimuthu.test.springdemo.beans.BeanResourceFileLoader;
import org.dimuthu.test.springdemo.beans.CallBackBeanMethods;
import org.dimuthu.test.springdemo.beans.HelloWorld;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This is the entry point of the Spring Bean Injection demonstration. 
 * @author Dimuthu Abeynayake
 *
 */
public class MainApplication 
{
	private static AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

	public static void main( String[] args )
	{
		//    	Calling Bean Injection
		beanInjectionDemo();

		//    	LifeCycle CallBack Bean
		beanLifeCycleDemo();

		//    	Place Holder Bean
		beanPlaceHolderDemo();

		//    	@Required annotated
		beanRequiredAnnotationDemo();

		//    	Auto Wire
		beanAutoWireDemo();

		//      Resource file location
		beanResourceFileDemo();

		//		Custom Event Handling
		beanCustomEventHandlingDemo();

	}

	/**
	 * Registered an event in the customEventThrower method which requires implementing ApplicationEventPublisherAware interface, which 
	 * give-away Spring container to provide with ApplicationEventPublisher object by the time application starts up. With the use of ApplicationEventPublisher
	 * object, BeanResourceFileLoader can publish the custom made event (BeanResourceEvent). 
	 * Once the event is thrown, it will be handled by the BeanResourceEvent listener namely BeanResourceEventListener.
	 */
	private static void beanCustomEventHandlingDemo() {
		printSeperator("beanCustomEventHandlingDemo","\n");
		
		BeanResourceFileLoader beanResourceFileLoader = (BeanResourceFileLoader) context.getBean("beanResourceFileLoader");
		beanResourceFileLoader.customEventThrower();
		
		printSeperator("beanCustomEventHandlingDemo","");
	}

	/**
	 * This method prints property keys listed out in MyContent.properties and MyMessages.properties.
	 * For the operation ResourceBundleMessageSource is register in the Bean.xml and provide the mentioned files to load.
	 * Configuration is injected to a bean called BeanResourceFileLoader to locate the subjecting files and print appropriate message.
	 */
	private static void beanResourceFileDemo() {
		printSeperator("beanResourceFileDemo","\n");
		
		BeanResourceFileLoader beanResourceFileLoader = (BeanResourceFileLoader) context.getBean("beanResourceFileLoader");
		beanResourceFileLoader.printGreetingByMyContentFile();
		beanResourceFileLoader.printGreetingByMyMessageFile();

		beanResourceFileLoader.printCustomisedGreetingByMyContentFile();
		beanResourceFileLoader.printCustomisedGreetingByMyMessageFile();
		
		printSeperator("beanResourceFileDemo","");
	}


	/**Property Place Holder was register to inject the values from SpringData.properties
	 * So the value is printed as : My Message for Place Holder
	 */
	private static void beanPlaceHolderDemo() {
		printSeperator("beanPlaceHolderDemo","\n");
		
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorldPlaceHolder");
		System.out.println("helloWorld.getMessage() : " + helloWorld.getMessage());
		
		printSeperator("beanPlaceHolderDemo","");
	}

	/**
	 * Typical Bean injection
	 */
	private static void beanInjectionDemo() {
		printSeperator("beanInjectionDemo","\n");
		
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		System.out.println("helloWorld.getMessage() : " + helloWorld.getMessage());
		
		printSeperator("beanInjectionDemo","");
	}

	/**
	 * Explains  the life cycle of a bean, creating initialization methods and the destroy methods which can be configured in the 
	 * InitializingBean and DisposableBean interfaces implementation and configuring  init-method and destroy-method attributes 
	 * in Beans.xml
	 */
	private static void beanLifeCycleDemo() {
		printSeperator("beanLifeCycleDemo","\n");
		
		context.registerShutdownHook();
		CallBackBeanMethods obj = (CallBackBeanMethods) context.getBean("callbackBean");
		System.out.println("Your Message : " + obj.getMyName());
		
		printSeperator("beanLifeCycleDemo","");
	}

	/**
	 * By setting the @Autowired annotation, Spring container will look for the type (ByType) that matches the HelloWorld for injection. If not found then search upon the 
	 * name (ByName) "helloWorldInjection". If not found, which means there is no type by the defined, or there are multiple beans belongs to the same type.
	 * In such a case we have to specify a @Qualifier to narrow the search down.
	 */
	private static void beanAutoWireDemo() {
		printSeperator("beanAutoWireDemo","\n");
		
		AutoWireAnnotatorCheck autoWireAnnotatorCheck = (AutoWireAnnotatorCheck) context.getBean("autoWireAnnotationChecker");
		System.out.println("autoWireAnnotatorCheck.getMessage() : " + autoWireAnnotatorCheck.getHelloWorldInjection().getMessage());
		
		printSeperator("beanAutoWireDemo","");
	}

	/**
	 * Defining the Required annotation indicates that it is mandatory for the property to set a value for the bean to function. Otherwise an error is thrown
	 * at the run-time.
	 * By setting the Required annotation and registering RequiredAnnotationBeanPostProcessor in Spring xml, Spring container validates the annotation and throws an 
	 * exception after validating the context which has been loaded. 
	 */
	private static void beanRequiredAnnotationDemo() {
		printSeperator("beanRequiredAnnotationDemo","\n");
		
		AnnotationCheckerBean annotationCheckerBean = (AnnotationCheckerBean) context.getBean("annotationChecker");
		System.out.println("helloWorld.getMessage() : " + annotationCheckerBean.getMessage());
		
		printSeperator("beanRequiredAnnotationDemo","");
	}
	
	private static void printSeperator(String... methodName) {
		System.out.println(String.format("%s======================={%s}=============================", methodName[1],methodName[0]));	
		
	}
}
