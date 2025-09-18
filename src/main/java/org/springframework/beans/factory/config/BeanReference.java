package org.springframework.beans.factory.config;

/**
 * ClassName: BeanReference
 * Description: 一个bean对另一个bean的引用
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 15:43
 * Version: 1.0
 */
public class BeanReference {

    private final String beanName;


    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
