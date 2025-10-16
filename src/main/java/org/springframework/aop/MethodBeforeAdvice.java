package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * ClassName: MethodBeforeAdvice
 * Description:
 *
 * Author: shubaizz
 * DateTime: 2025/10/16 16:35
 * Version: 1.0
 */
public interface MethodBeforeAdvice extends BeforeAdvice{
    void before(Method method, Object[] args, Object target) throws Throwable;
}
