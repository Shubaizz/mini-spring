package org.springframework.test.common;

import org.springframework.core.convert.converter.Converter;

/**
 * ClassName: StringToIntegerConverter
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 21:26
 * Version: 1.0
 */
public class StringToIntegerConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }
}
