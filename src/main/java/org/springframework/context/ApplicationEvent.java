package org.springframework.context;

import java.util.EventObject;

/**
 * ClassName: ApplicationEvent
 * Description: 抽象的事件类
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/23 14:46
 * Version: 1.0
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
