package org.springframework.aop;

import org.aopalliance.intercept.MethodInvocation;

/**
 * ClassName: MethodAroundAdvice
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/16 16:33
 * Version: 1.0
 */
public interface MethodAroundAdvice extends AroundAdvice{
    Object around(MethodInvocation invocation) throws Throwable;
}
