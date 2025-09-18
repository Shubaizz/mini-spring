package org.springframework.test.ioc.service;

/**
 * ClassName: HelloService
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 14:45
 * Version: 1.0
 */
public class HelloService {

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}
