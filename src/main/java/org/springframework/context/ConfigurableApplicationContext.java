package org.springframework.context;

import org.springframework.beans.BeansException;

/**
 * ClassName: ConfigurableApplicationContext
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/21 14:38
 * Version: 1.0
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
