package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * ClassName: BeforeAdvice
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 15:08
 * Version: 1.0
 */
public interface BeforeAdvice {
    void before(Method method, Object[] args, Object target) throws Throwable;
}
