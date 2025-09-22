package org.springframework.beans.factory;

/**
 * ClassName: InitializingBean
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/22 15:37
 * Version: 1.0
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
