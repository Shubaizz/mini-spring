package org.springframework.aop;

import org.aopalliance.intercept.MethodInvocation;

/**
 * ClassName: AroundAdvice
 * Description: 环绕通知
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 15:08
 * Version: 1.0
 */
public interface AroundAdvice {
    Object around(MethodInvocation invocation) throws Throwable;
}
