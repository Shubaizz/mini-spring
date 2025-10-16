package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * ClassName: MethodAfterAdvice
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/16 16:32
 * Version: 1.0
 */
public interface MethodAfterAdvice extends AfterAdvice{
    void after(Method method, Object[] args, Object target) throws Throwable;
}
