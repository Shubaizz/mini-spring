package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * ClassName: BeanDefinitionRegistry
 * Description: BeanDefinition注册表接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 11:18
 * Version: 1.0
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
