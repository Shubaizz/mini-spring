package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.core.convert.support.StringToNumberConverterFactory;
import org.springframework.test.common.StringToBooleanConverter;
import org.springframework.test.common.StringToIntegerConverter;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ClassName: TypeConversionFirstPartTest
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 21:26
 * Version: 1.0
 */
public class TypeConversionFirstPartTest {

    @Test
    public void testStringToIntegerConverter() throws Exception {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("123");
        System.out.println(result);
    }

    @Test
    public void testStringToNumberConverterFactory() throws Exception {
        StringToNumberConverterFactory converterFactory = new StringToNumberConverterFactory();

        Converter<String, Integer> converter = converterFactory.getConverter(Integer.class);
        Integer result = converter.convert("123");
        System.out.println(result);

        Converter<String, Long> converter1 = converterFactory.getConverter(Long.class);
        Long result1 = converter1.convert("123");
        System.out.println(result1);
    }

    @Test
    public void testGenericConverter() throws Exception {
        StringToBooleanConverter converter = new StringToBooleanConverter();

        Boolean flag = (Boolean) converter.convert("true", String.class, Boolean.class);
        assertThat(flag).isTrue();
    }

    @Test
    public void testGenericConversionService() throws Exception {
        GenericConversionService conversionService = new GenericConversionService();
        conversionService.addConverter(new StringToIntegerConverter());

        Integer intNum = conversionService.convert("8888", Integer.class);
        assertThat(conversionService.canConvert(String.class, Integer.class)).isTrue();
        assertThat(intNum).isEqualTo(8888);

        conversionService.addConverterFactory(new StringToNumberConverterFactory());
        assertThat(conversionService.canConvert(String.class, Long.class)).isTrue();
        Long longNum = conversionService.convert("8888", Long.class);
        assertThat(longNum).isEqualTo(8888L);

        conversionService.addConverter(new StringToBooleanConverter());
        assertThat(conversionService.canConvert(String.class, Boolean.class)).isTrue();
        Boolean flag = conversionService.convert("true", Boolean.class);
        assertThat(flag).isTrue();
    }
}
