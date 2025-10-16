package org.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * ClassName: Advisor
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/16 13:55
 * Version: 1.0
 */
public interface Advisor {

    Advice getAdvice();
}
