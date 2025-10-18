package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * ClassName: BeanFactory
 * Description: bean容器
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 11:14
 * Version: 1.0
 */
public interface BeanFactory {

    /**
     * 获取bean
     *
     * @param name
     * @return
     * @throws BeansException bean不存在时
     */
    Object getBean(String name) throws BeansException;

    /**
     * 根据名称和类型查找bean
     *
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;
}
