package org.springframework.beans;

/**
 * ClassName: BeansException
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 11:13
 * Version: 1.0
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
