package org.springframework.core.convert.support;

import org.springframework.core.convert.converter.ConverterRegistry;

/**
 * ClassName: DefaultConversionService
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 20:54
 * Version: 1.0
 */
public class DefaultConversionService extends GenericConversionService{

    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
        //TODO 添加其他ConverterFactory
    }
}
