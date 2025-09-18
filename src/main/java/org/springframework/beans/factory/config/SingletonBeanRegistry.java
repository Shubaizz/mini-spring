package org.springframework.beans.factory.config;

/**
 * ClassName: SingletonBeanRegistry
 * Description: 单例注册表
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 11:19
 * Version: 1.0
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
