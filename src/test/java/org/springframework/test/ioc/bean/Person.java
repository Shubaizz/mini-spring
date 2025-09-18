package org.springframework.test.ioc.bean;

/**
 * ClassName: Person
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 15:28
 * Version: 1.0
 */
public class Person {

    private String name;

    private int age;

    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}