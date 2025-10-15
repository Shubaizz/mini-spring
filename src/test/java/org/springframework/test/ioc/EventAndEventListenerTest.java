package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.common.event.CustomEvent;
import org.springframework.test.common.event.HelloEvent;
import org.springframework.test.common.event.HelloEventPublisher;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public class EventAndEventListenerTest {

	@Test
	public void testEventListener() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event-and-event-listener.xml");
		System.out.println("Publishing event...");
		applicationContext.publishEvent(new CustomEvent(applicationContext));

		System.out.println("Publishing context...");
		applicationContext.publishEvent(new HelloEvent("hello"));
		applicationContext.registerShutdownHook();//或者applicationContext.close()主动关闭容器;

		HelloEventPublisher helloEventPublisher = applicationContext.getBean("helloEventPublisher", HelloEventPublisher.class);
		helloEventPublisher.publishEvent("hello me");
	}
}
