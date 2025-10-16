package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * ClassName: MethodAfterReturningAdvice
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/16 16:33
 * Version: 1.0
 */
public interface MethodAfterReturningAdvice extends AfterReturningAdvice{
    void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable;
}
