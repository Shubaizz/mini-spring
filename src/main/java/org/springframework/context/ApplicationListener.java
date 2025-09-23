package org.springframework.context;

import java.util.EventListener;

/**
 * ClassName: ApplicationListener
 * Description: 监听器
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/23 14:49
 * Version: 1.0
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
