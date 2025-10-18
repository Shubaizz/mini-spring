package org.springframework.test.service;

import org.springframework.context.stereotype.Component;

/**
 * ClassName: MyServiceImpl
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/18 19:05
 * Version: 1.0
 */
@Component
public class MyServiceImpl implements MyService{
    @Override
    public void doSomething() {
        System.out.println("doSomething lllllllllllllll");
    }
}
