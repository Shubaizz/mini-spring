package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * ClassName: InstantiationStrategy
 * Description: Bean的实例化策略
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 14:56
 * Version: 1.0
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
