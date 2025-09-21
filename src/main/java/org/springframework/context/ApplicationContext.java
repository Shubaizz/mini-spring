package org.springframework.context;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.core.io.ResourceLoader;

/**
 * ClassName: ApplicationContext
 * Description: 应用上下文
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/21 14:32
 * Version: 1.0
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
