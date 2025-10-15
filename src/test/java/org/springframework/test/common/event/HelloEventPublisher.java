package org.springframework.test.common.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.common.event.HelloEvent;

/**
 * ClassName: MyHelloEventListener
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/15 15:32
 * Version: 1.0
 */
public class HelloEventPublisher implements ApplicationContextAware  {

    // TODO 等待@Autowired注解 来完善，现在先用setApplicationContext来
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationEventPublisher = applicationContext;
    }

    public void publishEvent(String msg) {
        HelloEvent event = new HelloEvent(msg);
        applicationEventPublisher.publishEvent(event);
    }
}
