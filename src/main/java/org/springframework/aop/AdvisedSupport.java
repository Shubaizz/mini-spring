package org.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * ClassName: AdvisedSupport
 * Description: 用于保存通知（Advice）和目标对象（Target）相关信息的支持类
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 13:43
 * Version: 1.0
 */
public class AdvisedSupport {

    //是否使用cglib代理
    private boolean proxyTargetClass = false;

    private TargetSource targetSource;

    // 方法拦截器，包含了要织入目标方法的横切逻辑（如前置、后置、环绕通知等）
    private MethodInterceptor methodInterceptor;

    private MethodMatcher methodMatcher;

    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
