package org.springframework.context.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * ClassName: ApplicationEventMulticaster
 * Description: 注册监听器和发布事件的抽象接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/23 14:51
 * Version: 1.0
 */
public interface ApplicationEventMulticaster {

    /**
     * 添加监听器
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 移除监听器
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 发布事件
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
