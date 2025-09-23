package org.springframework.test.ioc.common.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * ClassName: HelloEvent
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/23 15:05
 * Version: 1.0
 */
public class HelloEvent extends ApplicationEvent {

    public HelloEvent(Object source) {
        super(source);
    }
}
