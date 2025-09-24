package org.springframework.test.bean;

/**
 * ClassName: Car
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 15:45
 * Version: 1.0
 */
public class Car {

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

