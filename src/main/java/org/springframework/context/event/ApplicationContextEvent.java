package org.springframework.context.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

/**
 * ClassName: ApplicationContextEvent
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/23 14:53
 * Version: 1.0
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
