package org.springframework.aop;

/**
 * ClassName: ClassFilter
 * Description: 需要匹配类，定义ClassFilter接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 13:27
 * Version: 1.0
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
