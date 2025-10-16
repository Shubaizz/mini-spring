package org.springframework;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;

/**
 * ClassName: PointcutAdvisor
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/16 13:56
 * Version: 1.0
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
