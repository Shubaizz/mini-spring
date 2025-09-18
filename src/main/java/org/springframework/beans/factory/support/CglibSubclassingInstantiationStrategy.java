package org.springframework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * ClassName: CglibSubclassingInstantiationStrategy
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 14:58
 * Version: 1.0
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    /**
     * 使用CGLIB动态生成子类
     *
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 调用被代理类的原始方法（父类方法），不做任何额外增强
                return methodProxy.invokeSuper(o, objects);
            }
        });
        return enhancer.create();
    }
}
