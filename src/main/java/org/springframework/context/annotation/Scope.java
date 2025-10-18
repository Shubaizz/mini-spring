package org.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * ClassName: Scope
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 15:27
 * Version: 1.0
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
