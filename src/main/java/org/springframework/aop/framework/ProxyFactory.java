package org.springframework.aop.framework;

import org.springframework.aop.AdvisedSupport;

/**
 * ClassName: ProxyFactory
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 14:59
 * Version: 1.0
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new CglibAopProxy(advisedSupport);
        }

        return new JdkDynamicAopProxy(advisedSupport);
    }
}
