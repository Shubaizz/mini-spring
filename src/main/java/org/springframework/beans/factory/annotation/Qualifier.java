package org.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * ClassName: Qualifier
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 16:07
 * Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";

}