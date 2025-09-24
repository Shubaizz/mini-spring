package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * ClassName: MethodMatcher
 * Description: 匹配方法，定义MethodMatcher接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 13:28
 * Version: 1.0
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
