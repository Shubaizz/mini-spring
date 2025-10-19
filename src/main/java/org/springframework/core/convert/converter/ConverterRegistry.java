package org.springframework.core.convert.converter;

/**
 * ClassName: ConverterRegistry
 * Description: 类型转换器注册接口
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 20:49
 * Version: 1.0
 */
public interface ConverterRegistry {

    void addConverter(Converter<?, ?> converter);

    void addConverterFactory(ConverterFactory<?, ?> converterFactory);

    void addConverter(GenericConverter converter);
}
