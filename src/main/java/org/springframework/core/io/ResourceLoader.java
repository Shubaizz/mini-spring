package org.springframework.core.io;

/**
 * ClassName: ResourceLoader
 * Description: 资源加载器接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 16:01
 * Version: 1.0
 */
public interface ResourceLoader {

    Resource getResource(String location);
}
