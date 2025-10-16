package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * ClassName: MethodThrowsAdvice
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/16 16:34
 * Version: 1.0
 */
public interface MethodThrowsAdvice extends ThrowsAdvice{
    void throwsHandle(Throwable throwable, Method method, Object[] args, Object target);
}
