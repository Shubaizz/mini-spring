package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;

/**
 * ClassName: InstantiationAwareBeanPostProcessor
 * Description: 实例化 感知 Bean后处理器 ， 新增 实例化前 实例化后感知
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/16 14:58
 * Version: 1.0
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    /**
     * 在bean实例化之前执行
     * 可以返回一个自定义的 bean 实例，直接替代 Spring 默认的实例化过程。如果返回非null值，Spring 会终止后续的实例化流程
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * bean实例化之后，设置属性之前执行
     * 返回boolean值，false表示阻止后续的属性注入（即 Spring 不再为该 bean 设置属性），true表示允许继续注入。
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * bean实例化之后，设置属性之前执行 在 postProcessAfterInstantiation()方法之后执行
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName)
            throws BeansException;


}
