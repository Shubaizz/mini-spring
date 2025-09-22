package org.springframework.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;

/**
 * ClassName: ApplicationContextAware
 * Description: 实现该接口，能感知所属ApplicationContext
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/22 16:24
 * Version: 1.0
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
