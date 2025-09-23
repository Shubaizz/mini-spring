package org.springframework.context;

/**
 * ClassName: ApplicationEventPublisher
 * Description: 事件发布者接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/23 14:47
 * Version: 1.0
 */
public interface ApplicationEventPublisher {

    /**
     * 发布事件
     *
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
