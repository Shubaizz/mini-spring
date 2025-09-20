package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;

/**
 * ClassName: BeanPostProcessor
 * Description: 用于修改实例化后的bean的修改扩展点
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/20 13:51
 * Version: 1.0
 */
public interface BeanPostProcessor {

    /**
     * 在bean执行初始化方法之前执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean执行初始化方法之后执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
