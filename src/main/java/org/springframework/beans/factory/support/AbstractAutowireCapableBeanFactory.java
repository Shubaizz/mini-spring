package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Method;

/**
 * ClassName: AbstractAutowireCapableBeanFactory
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 11:22
 * Version: 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        return doCreateBean(beanName, beanDefinition);
    }

    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition);
            //为bean填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 为bean填充属性
     *
     * @param bean
     * @param beanDefinition
     */
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            Class beanClass = beanDefinition.getBeanClass();

            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if(value instanceof BeanReference){
                    // beanA依赖beanB，先实例化beanB
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 通过属性的set方法设置属性
                Class<?> type = beanClass.getDeclaredField(name).getType();
                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                Method method = beanClass.getDeclaredMethod(methodName, new Class[]{type});
                method.invoke(bean, new Object[]{value});
            }
        }catch (Exception ex){
            throw new BeansException("Error setting property values for bean: " + beanName, ex);
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition){
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
