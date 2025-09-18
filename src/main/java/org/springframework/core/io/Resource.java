package org.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * ClassName: Resource
 * Description: 资源的抽象接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 15:52
 * Version: 1.0
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
