package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Car;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ClassName: ValueAnnotationTest
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 15:51
 * Version: 1.0
 */
public class ValueAnnotationTest {
    @Test
    public void testValueAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:value-annotation.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand()).isEqualTo("lamborghini");
        System.out.println(car);
    }
}
