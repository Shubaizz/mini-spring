package org.springframework.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * ClassName: ReflectiveMethodInvocation
 * Description: 反射的方法调用器
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 13:44
 * Version: 1.0
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    // 目标对象（被调用方法所属的实例）
    protected final Object target;

    // 要调用的方法对象
    protected final Method method;

    // 方法调用时需要传递的参数数组
    protected final Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    // 核心方法，通过反射调用目标方法
    @Override
    public Object proceed() throws Throwable {
        // JDK的反射调用目标方法
        return method.invoke(target, arguments);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
