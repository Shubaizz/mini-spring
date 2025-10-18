package org.springframework.test.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.stereotype.Component;

/**
 * ClassName: Car
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 15:45
 * Version: 1.0
 */
@Component
public class Car {

    @Value("${brand}")
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}

