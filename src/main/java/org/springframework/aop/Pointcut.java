package org.springframework.aop;

/**
 * ClassName: Pointcut
 * Description: 切点抽象  PointCut需要同时匹配类和方法
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 13:27
 * Version: 1.0
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
