package org.springframework.beans.factory;

/**
 * ClassName: FactoryBean
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/23 14:24
 * Version: 1.0
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    boolean isSingleton();
}
