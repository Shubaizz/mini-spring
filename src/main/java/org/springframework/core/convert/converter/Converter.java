package org.springframework.core.convert.converter;

/**
 * ClassName: Converter
 * Description: 类型转换抽象接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 20:47
 * Version: 1.0
 */
public interface Converter<S, T> {

    /**
     * 类型转换
     */
    T convert(S source);
}
