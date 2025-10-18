package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.bean.Car;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * ClassName: PackageScanTest
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 15:34
 * Version: 1.0
 */
public class PackageScanTest {
    @Test
    public void testScanPackage() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:package-scan.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car).isNotNull();
        System.out.println(car);
    }
}
