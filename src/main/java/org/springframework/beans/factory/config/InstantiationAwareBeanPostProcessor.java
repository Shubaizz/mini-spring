package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;

/**
 * ClassName: InstantiationAwareBeanPostProcessor
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/16 14:58
 * Version: 1.0
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    /**
     * 在bean实例化之前执行
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
