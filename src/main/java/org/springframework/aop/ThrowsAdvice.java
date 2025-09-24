package org.springframework.aop;

import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

/**
 * ClassName: ThrowsAdvice
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 15:09
 * Version: 1.0
 */
public interface ThrowsAdvice extends Advice {
    void throwsHandle(Throwable throwable, Method method, Object[] args, Object target);
}
