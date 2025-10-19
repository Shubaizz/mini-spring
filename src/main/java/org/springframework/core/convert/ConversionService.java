package org.springframework.core.convert;

/**
 * ClassName: ConversionService
 * Description:类型转换抽象接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 20:55
 * Version: 1.0
 */
public interface ConversionService {

    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    <T> T convert(Object source, Class<T> targetType);
}
