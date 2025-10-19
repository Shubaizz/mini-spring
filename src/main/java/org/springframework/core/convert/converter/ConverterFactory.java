package org.springframework.core.convert.converter;

/**
 * ClassName: ConverterFactory
 * Description: 类型转换工厂
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 20:48
 * Version: 1.0
 */
public interface ConverterFactory<S, R> {

    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
