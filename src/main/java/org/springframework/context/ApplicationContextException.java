package org.springframework.context;

import org.springframework.beans.BeansException;

/**
 * ClassName: ApplicationContextException
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/21 14:36
 * Version: 1.0
 */
public class ApplicationContextException extends BeansException {
    public ApplicationContextException(String msg) {
        super(msg);
    }

    public ApplicationContextException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
