package org.springframework.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: ClassPathResource
 * Description: 类路径下的资源
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 15:52
 * Version: 1.0
 */
public class ClassPathResource implements Resource{

    private final String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException("resource cannot be opened because it does not exist");
        }
        return is;
    }


}
