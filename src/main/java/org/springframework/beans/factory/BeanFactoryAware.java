package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * ClassName: BeanFactoryAware
 * Description: 实现该接口，能感知所属BeanFactory
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/22 16:22
 * Version: 1.0
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
