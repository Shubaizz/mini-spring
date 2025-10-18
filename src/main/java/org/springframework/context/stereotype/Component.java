package org.springframework.context.stereotype;

import java.lang.annotation.*;

/**
 * ClassName: Component
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 15:26
 * Version: 1.0
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
