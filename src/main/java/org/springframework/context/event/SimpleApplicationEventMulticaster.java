package org.springframework.context.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ClassName: SimpleApplicationEventMulticaster
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/23 14:55
 * Version: 1.0
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener<ApplicationEvent> applicationListener : applicationListeners) {
            if (supportsEvent(applicationListener, event)) {
                applicationListener.onApplicationEvent(event);
            }
        }
    }

    /**
     * 监听器是否对该事件感兴趣
     *
     * @param applicationListener
     * @param event
     * @return
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        /**
         *  获取监听器 实现的泛型参数
         *  HelloEventListener implements ApplicationListener<HelloEvent>
         *      下面type 获取 到是 ApplicationListener<HelloEvent>
         */
        Type type = applicationListener.getClass().getGenericInterfaces()[0];
        // 抽取 出 泛型参数 HelloEvent.class
        Type actualTypeArgument = ((ParameterizedType) type).getActualTypeArguments()[0];
        // 获取 HelloEvent的 全限定类名
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            // 根据类名字符串获取对应的 Class 对象
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }
        // 判断当前事件对象是否属于（或继承自）目标事件类型
        return eventClassName.isAssignableFrom(event.getClass());
    }
}
