package org.springframework.context.event;

import org.springframework.context.ApplicationEvent;

/**
 * ClassName: ContextRefreshedEvent
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/23 14:54
 * Version: 1.0
 */
public class ContextRefreshedEvent extends ApplicationEvent {

    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
