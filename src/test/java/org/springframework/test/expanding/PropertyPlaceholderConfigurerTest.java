package org.springframework.test.expanding;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Car;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ClassName: PropertyPlaceholderConfigurerTest
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 15:16
 * Version: 1.0
 */
public class PropertyPlaceholderConfigurerTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:property-placeholder-configurer.xml");

        Car car = applicationContext.getBean("car", Car.class);
        System.out.println(car);
        assertThat(car.getBrand()).isEqualTo("lamborghini");
    }
}
