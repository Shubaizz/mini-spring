package org.springframework.test.common;

import org.junit.Test;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ClassName: TypeConversionFirstPartTest
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 21:24
 * Version: 1.0
 */
public class StringToBooleanConverter implements GenericConverter {


    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, Boolean.class));
    }

    @Override
    public Object convert(Object source, Class sourceType, Class targetType) {
        return Boolean.valueOf((String) source);
    }
}
