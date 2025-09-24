package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * ClassName: AfterReturningAdvice
 * Description: 后置增强
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 15:08
 * Version: 1.0
 */
public interface AfterReturningAdvice {
    void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable;
}
