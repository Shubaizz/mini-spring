package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: Resource
 * Description: 资源的抽象接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 15:52
 * Version: 1.0
 */
public interface Resource {

    // 获取资源的URL
    InputStream getInputStream() throws IOException;

}
